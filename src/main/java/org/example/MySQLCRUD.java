/** Project:LAB 3 Database
 * Purpose Details:MYSQL Class to perform CRUD
 * Course: IST242
 * Author:Jordan Borrero
 * Date Developed:2/20/24
 * Last Date Changed:2/21/24
 * Rev:1

 */
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLCRUD {
    //Data of Class
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/School";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";
    private int Customerid;
    private String Customername;
    private int Customerage;
    private String Customeraddress;
    private String Customerupdatedaddress;
    //Perform CRUD
    public void run(String Customername, int Customerid, int Customerage, String Customeraddress, String Customerupdatedaddress) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Create
            insertStudent(connection, Customerid, Customername, Customerage, Customeraddress);

            // Read
            List<Student> students = getAllStudents(connection);
            for (Student student : students) {
                System.out.println(student);
            }

            // Update
            updateStudent(connection, Customerid, Customerupdatedaddress);

            // Read again
            students = getAllStudents(connection);
            for (Student student : students) {
                System.out.println(student);
            }

            // Delete
            deleteStudent(connection, 1);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void insertStudent(Connection connection, int id, String name, int age, String address) throws SQLException {
        String sql = "INSERT INTO students (id, name, age, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, address);
            preparedStatement.executeUpdate();
        }
    }

    private static List<Student> getAllStudents(Connection connection) throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT id, name, age, address FROM students";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                students.add(new Student(id, name, age, address));
            }
        }
        return students;
    }

    private static void updateStudent(Connection connection, int id, String newaddress) throws SQLException {
        String sql = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, newaddress);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        }
    }

    private static void deleteStudent(Connection connection, int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}

class Student {
    private int id;
    private String name;
    private int age;
    private String address;

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
