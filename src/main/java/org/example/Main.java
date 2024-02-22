/** Project:LAB 3 Database
 * Purpose Details:Main Class to provide menu for user and allow inputs
 * Course: IST242
 * Author:Jordan Borrero
 * Date Developed:2/20/24
 * Last Date Changed:2/21/24
 * Rev:1

 */
package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int onOrOff = 1;
        while(onOrOff == 1){  //User menu to enter info and selection
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter full name: ");
            String name = reader.nextLine();
            System.out.println("Enter ID: ");
            int id = reader.nextInt();
            System.out.println("Enter age: ");
            int age = reader.nextInt();
            System.out.println("Enter address: ");
            String address = reader.nextLine();
            System.out.println("Enter updated address: ");
            String updatedaddress = reader.nextLine();
            System.out.println("1) MySQL \n2) Mongo \n3) Blockchain \n4) Redis \n5) Quit \nChoose an option: ");
            String option = reader.nextLine();
            Customer customer = new Customer(name, id, age, address, updatedaddress);  //Creating customer object

            if(option.equals("1")){  //User selects MySQL
                MySQLCRUD SQL = new MySQLCRUD();
                SQL.run(customer.getCustomername(), customer.getCustomerid(), customer.getCustomerage(), customer.getCustomeraddress(), customer.getCustomerupdatedaddress());  //Run
            }else if (option.equals("2")){
                //Mongo Selection
            }else if (option.equals("3")){
                //Blockchain Selection
            }else if (option.equals("4")){
                //Redis Selection
            }else if (option.equals("5")){
                onOrOff = 0;  // Turn Off
            }

        }




    }

}