/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emails;

import java.util.*;
import java.io.*;

/**
 * @author expertize
 */
public class Email {

    //declaring the vairables
    //private can be accessed directly only within same class
    //private needs to create object in order to be accessed from other class 
    //in the same package
    private String firsttName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 1024; //= 1Gb
    private String alternateEmail;
    private int defaultPasswordlength = 10;
    private String email;
    private String company = "xyz";
    private boolean succsufullLogin = false;
    private int passwordlength = 16;
    private int selection;
    public static int count = 0;

    //constructor to receive first name and last names and ask other details
    //constructor makes sure of data enetry vaildation
    public Email(String firstName, String lastName) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the 1st name + last name ");

        firstName = sc.nextLine();
        lastName = sc.nextLine();
        this.firsttName = firstName;
        this.lastName = lastName;
        //calling the methode to set department
        this.department = setDept();
        //Generating email
        this.email = generateEmail();
        //getting the temporary auto generated pass
        this.password = getPassword();
        System.out.println("Password " + getPassword());
        System.out.println("Your email is : " + generateEmail());

        //calling the login method after succssful login
        logIn();

        //if succssful login user will prompt to enter his new pass
        if (succsufullLogin == true) {
            System.out.println("Please enter your new password");
            Scanner sc2 = new Scanner(System.in);
            this.password = sc2.nextLine();
            setpassword(password);
            System.out.println("New Password is  : " + password);
        }

        System.out.println(toString());

    }

    //set dept
    private String setDept() {

        System.out.println("Please enter the department\n"
                + "Type 1 for Sales\n"
                + "Type 2 for IT\n"
                + "Type 3 for HR");

        Scanner sc = new Scanner(System.in);
        String selection = sc.nextLine();

        //using switch to asgin the deparment
        switch (selection) {
            case "1":
                this.department = "Sales";
                System.out.println("Sales");
                break;

            case "2":
                this.department = "IT";
                System.out.println("IT");
                break;

            case "3":
                this.department = "HR";
                System.out.println("HR");
                break;
            // validting the enery to be either 1,2, or 3, else program stopes     
            default:

                if (!selection.equals("1") || !selection.equals("2") || !selection.equals("3")) {
                    System.out.println("selection" + selection);
                    System.out.println("You shout enter a number between 1 and 3");
                }
        }

        return department;
    }

    // Generate random pass
    private String generatePassword() {

        //all possible letter combination, including wild characters
        String passwordPermitedLetters = "ABCDEFGHIJKLMNOPQRSTVWXYZ"
                + "abcdefghijklmnopqrstvwxyz"
                + "!@#$%&";

        // array to store the passord
        char[] pass = new char[defaultPasswordlength];
        //for loop to iterate the array elements
        for (int i = 0; i < pass.length; i++) {
            //the generate a random pass
            int random = (int) (Math.random() * passwordPermitedLetters.length());
            pass[i] = passwordPermitedLetters.charAt(random);
        }

        //assimpling the passord in new string and store it pass vairable
        
       return new String(pass);
        
    }

    private String getPassword() {
        this.password = generatePassword();
        return password;

    }

    //generate email,using concaatination
    private String generateEmail() {

        String generatedEmail = (firsttName.concat(".").concat(lastName).concat("@").concat(company)
                .concat(".").concat(department).concat(".com")).toLowerCase();
        this.email = generatedEmail;
        count++;
        System.out.println("count : " + count);
        return this.email;
    }

    //login method
    private void logIn() {

        System.out.println("Please enter your email to update your password");
        Scanner sc = new Scanner(System.in);
        String loginEmail = sc.nextLine();
        System.out.println("Please enter your temporary password");
        String pass = sc.nextLine();

        if (this.password.equals(pass) && this.email.equals(loginEmail)) {
            System.out.println("Login is granted for user : " + email);
            succsufullLogin = true;
            //System.out.println("Please enter your new pass");

        } else {
            System.out.println("Login is aborted either username or password is wrong !");
        }

    }

    private void setpassword(String newPassword) {

        this.password = newPassword;
    }

    //printing new email details
    @Override
    public String toString() {
        return "FirsttName= " + firsttName + "\nLastName= " + lastName + "\nPpassword= " + password + "\nDepartment= "
                + department + "\nMailboxCapacity=" + mailboxCapacity + "\n Email="
                + email + "\nCompany= " + company
                + "\nSuccsufullLogin= " + succsufullLogin + "\n Count=" + count;
    }

    public void setDefaultPasswordlength(int defaultPasswordlength) {
        this.defaultPasswordlength = defaultPasswordlength;
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }
}
