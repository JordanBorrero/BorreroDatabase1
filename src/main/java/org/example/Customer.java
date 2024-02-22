/** Project:LAB 3 Database
 * Purpose Details:Customer Class with contructor, getters and setters
 * Course: IST242
 * Author:Jordan Borrero
 * Date Developed:2/20/24
 * Last Date Changed:2/21/24
 * Rev:1

 */


package org.example;

public class Customer {
    //Customer Data of Class
    private int Customerid;
    private String Customername;
    private int Customerage;
    private String Customeraddress;
    private String Customerupdatedaddress;
    //Constructor
    Customer(String Customername, int Customerid, int Customerage, String Customeraddress, String Customerupdatedaddress){
        this.Customerid = Customerid;
        this.Customername = Customername;
        this.Customerage = Customerage;
        this.Customeraddress = Customeraddress;
        this.Customerupdatedaddress = Customerupdatedaddress;
    }
// Getters and Setters Below
    public int getCustomerid() {
        return Customerid;
    }

    public void setCustomerid(int customerid) {
        Customerid = customerid;
    }

    public String getCustomername() {
        return Customername;
    }

    public void setCustomername(String customername) {
        Customername = customername;
    }

    public int getCustomerage() {
        return Customerage;
    }

    public void setCustomerage(int customerage) {
        Customerage = customerage;
    }

    public String getCustomeraddress() {
        return Customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        Customeraddress = customeraddress;
    }
    public String getCustomerupdatedaddress() {
        return Customerupdatedaddress;
    }

    public void setCustomerupdatedaddress(String customerupdatedaddress) {
        Customerupdatedaddress = customerupdatedaddress;
    }
}
