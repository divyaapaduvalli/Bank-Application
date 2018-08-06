package userDefined;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bank{


    public void createAccount(Customer customer) {

        System.out.println("\nEnter the following details : ");
        Scanner in = new Scanner(System.in);

        System.out.println("First Name : ");
        String firstName = in.nextLine();
        while (!Pattern.matches("[a-zA-Z][a-zA-Z]*", firstName)) {
            System.out.println("Nope! Enter your First Name : ");
            firstName = in.nextLine();
        }
        customer.setAccountHolderFirstName(firstName);

        System.out.println("Middle Name (if you dont have a middle name then type \"NA\") : ");
        String middleName = in.nextLine();
        while (!Pattern.matches("[a-zA-Z][a-zA-Z]*", middleName) && !Pattern.matches("[nN][aA]", middleName)) {
            System.out.println("Nope! Enter your Middle Name : ");
            middleName = in.nextLine();
        }
        customer.setAccountHolderMiddleName(middleName);

        System.out.println("Last Name (if you dont have a last name \"NA\" : ");
        String lastName = in.nextLine();
        while (!Pattern.matches("[a-zA-Z][a-zA-Z]*", lastName) && !Pattern.matches("[nN][aA]", lastName)) {
            System.out.println("Nope! Enter your Last Name : ");
            lastName = in.nextLine();
        }
        customer.setAccountHolderLastName(lastName);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOne=null;
        Date date= new Date();
        SimpleDateFormat dateFormatOne= new SimpleDateFormat("yyyy");
        int age;
        do {
            //try {
                System.out.println("Your DOB in dd/MM/yyyy format: ");
                String dob = in.nextLine();
                while (!Pattern.matches("^([1-9]|0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)\\d\\d$", dob)) {
                    System.out.println("Nope! Enter proper date");
                    dob = in.nextLine();
                }
                try {
                    dateOne = dateFormat.parse(dob);
                } catch (ParseException e) {
                    System.out.println("invalid date");
                }
                age = Integer.parseInt(dateFormatOne.format(date)) - Integer.parseInt(dateFormatOne.format(dateOne));
          //  }
            //catch()
        }while(age<=0);
        customer.setAccountHolderDob(dateOne);
        customer.setAccountHolderAge(age);

        System.out.println("Phone Number : ");
        String number = in.nextLine();
        while (!Pattern.matches("[789][0-9]{9}", number)) {
            System.out.println("Nope! Enter your phone number : ");
            number = in.nextLine();
        }
        customer.setAccountHolderNumber(number);

        System.out.println("Your Address ");
        System.out.println("Street : ");
        customer.setAccountHolderStreet(in.nextLine());
        System.out.println("Area : ");
        customer.setAccountHolderArea(in.nextLine());
        System.out.println("City : ");
        customer.setAccountHolderCity(in.nextLine());
        System.out.println("State : ");
        customer.setAccountHolderState(in.nextLine());
        System.out.println("Pin : ");
        String pin = in.nextLine();
        while (!Pattern.matches("[0-9]{6}", pin)) {
            System.out.println("Enter proper postal code");
            pin = in.nextLine();
        }
        customer.setAccountHolderPin(pin);

        System.out.println("Email ID : ");
        String emailId = in.nextLine();
        while (!Pattern.matches("[a-zA-Z0-9]*[@][a-zA-Z0-9]*[.](com|org|net|int|edu|gov|mil)", emailId)) {
            System.out.println("Nope! Enter your email ID : ");
            emailId = in.nextLine();
        }
        customer.setAccountHolderEmailId(emailId);

        System.out.println("Adhaar Number : ");
        String adhaarNumber = in.nextLine();
        while (!Pattern.matches("[0-9]{12}", adhaarNumber)) {
            System.out.println("Nope! Enter your Adhaar Number: ");
            adhaarNumber = in.nextLine();
        }
        customer.setAccountHolderAdhaarNumber(adhaarNumber);
    }

    public void customerInformation(Customer customer){
        System.out.println("Your account details : ");
        System.out.println("Your Name : "+customer.getAccountHolderFirstName()+" "+customer.getAccountHolderMiddleName()+" "+customer.getAccountHolderLastName());
        System.out.println("Your Age : "+customer.getAccountHolderAge());
        System.out.println("Your Date of Birth : "+customer.getAccountHolderDob());
        System.out.println("Your Phone Number : "+customer.getAccountHolderNumber());
        System.out.println("Your Address : "+customer.getAccountHolderStreet()+" "+customer.getAccountHolderArea()+" "+customer.getAccountHolderCity()+" "+customer.getAccountHolderState()+" "+customer.getAccountHolderPin());
        System.out.println("Your Email ID : "+customer.getAccountHolderEmailId());
        System.out.println("Your Adhaar Number : "+customer.getAccountHolderAdhaarNumber());
        System.out.println("\nNote down the following details : ");
        System.out.println("\nYour account type is: " + customer.getAccountType().getType());
        System.out.println("Note down your account number : " + customer.getAccountNumber());
        System.out.println("Note down your account pin : " + customer.getAccountPin());
        System.out.println("Your current account balance is : " + customer.getAccountBalance());
    }

    public String customerNumber() {

            System.out.println("Your Account Number:");
            Scanner inputOne = new Scanner(System.in);
            String number = inputOne.nextLine();
            while (!Pattern.matches("[0-9]{9}", number)) {
                System.out.println("Nope! Enter your account Number : ");
                number = inputOne.nextLine();
            }
            return number;
        }
    public String customerPin(){
            System.out.println("Your Account Pin:");
            Scanner inputOne = new Scanner(System.in);
            String pin = inputOne.nextLine();
            while (!Pattern.matches("[0-9]{4}", pin)) {
                System.out.println("Nope! Enter your account Pin : ");
                pin = inputOne.nextLine();
            }
            return pin;
        }


    }
