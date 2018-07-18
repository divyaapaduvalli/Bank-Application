import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bank{
    public static HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();

    public void createAccount(Customer customer) {
        int randomNumber, randomPin=0;

        System.out.println("\nEnter the following details : ");
        Scanner in = new Scanner(System.in);

        System.out.println("First Name : ");
        String firstName=in.nextLine();
        while(!Pattern.matches("[a-zA-Z][a-zA-Z]*",firstName)) {
            System.out.println("Nope! Enter your First Name : ");
            firstName=in.nextLine();
        }
        customer.setAccountHolderFirstName(firstName);

        System.out.println("Middle Name (if you dont have a middle name then type \"NA\") : ");
        String middleName=in.nextLine();
        while(!Pattern.matches("[a-zA-Z][a-zA-Z]*",middleName) && !Pattern.matches("[nN][aA]",middleName)) {
            System.out.println("Nope! Enter your Middle Name : ");
            middleName=in.nextLine();
        }
        customer.setAccountHolderMiddleName(middleName);

        System.out.println("Last Name (if you dont have a last name \"NA\" : ");
        String lastName=in.nextLine();
        while(!Pattern.matches("[a-zA-Z][a-zA-Z]*",lastName) && !Pattern.matches("[nN][aA]",lastName)) {
            System.out.println("Nope! Enter your Last Name : ");
            lastName=in.nextLine();
        }
        customer.setAccountHolderLastName(lastName);

        System.out.println("Your age : ");
        String age=in.nextLine();
        while(!Pattern.matches("([0-9]|[0-9][0-9])",age) && !Pattern.matches("[nN][aA]",age)) {
            System.out.println("Nope! Enter your age : ");
            age=in.nextLine();
        }
        customer.setAccountHolderAge(age);

        System.out.println("Your DOB in dd/MM/yyyy format: ");
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        String dob=in.nextLine();
        while(!Pattern.matches( "^([1-9]|0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$",dob)) {
           System.out.println("Nope! Enter proper date");
           dob=in.nextLine();
        }
        try {
            customer.setAccountHolderDob(dateFormat.parse(dob));
        } catch (ParseException e) {
            System.out.println("invalid date");
        }

        System.out.println("Phone Number : ");
        String number=in.nextLine();
        while(!Pattern.matches("[789][0-9]{9}",number)) {
            System.out.println("Nope! Enter your phone number : ");
            number=in.nextLine();
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
        String pin=in.nextLine();
        while(!Pattern.matches("[0-9]{6}",pin)){
            System.out.println("Enter proper postal code");
            pin=in.nextLine();
        }
        customer.setAccountHolderPin(pin);

        System.out.println("Email ID : ");
        String emailId=in.nextLine();
        while(!Pattern.matches("[a-zA-Z0-9]*[@][a-zA-Z0-9]*[.](com|org|net|int|edu|gov|mil)",emailId)) {
            System.out.println("Nope! Enter your email ID : ");
            emailId=in.nextLine();
        }
        customer.setAccountHolderEmailId(emailId);

        System.out.println("Adhaar Number : ");
        String adhaarNumber=in.nextLine();
        while(!Pattern.matches("[0-9]{12}",adhaarNumber)) {
            System.out.println("Nope! Enter your Adhaar Number: ");
            adhaarNumber=in.nextLine();
        }
        customer.setAccountHolderAdhaarNumber(adhaarNumber);

        Random random = new Random();
        do {
            randomNumber = random.nextInt(1000000000) + 1;
            randomPin = random.nextInt(10000) + 1;
        } while (buffer.containsKey(randomNumber) && buffer.containsValue(randomPin));

        buffer.put(randomNumber, randomPin);

        customer.setAccountNumber(randomNumber);
        customer.setAccountPin(randomPin);

    }

    public void customerInformation(Customer customer){
        System.out.println("Your account details : ");
        System.out.println("Your account name is : " + customer.getAccountHolderFirstName()+" "+customer.getAccountHolderMiddleName()+" "+customer.getAccountHolderLastName());
        System.out.println("Your age is: " + customer.getAccountHolderAge());
        System.out.println("Your date of birth is: " + DateFormat.getDateInstance().format(customer.getAccountHolderDob()));
        System.out.println("Your phone number is: " + customer.getAccountHolderNumber());
        System.out.println("Your address is: " + customer.getAccountHolderStreet()+" "+customer.getAccountHolderArea()+" "+customer.getAccountHolderCity()+" "+customer.getAccountHolderState()+" "+customer.getAccountHolderPin());
        System.out.println("Your email id is: " + customer.getAccountHolderEmailId());
        System.out.println("Your adhaar number is: " + customer.getAccountHolderAdhaarNumber());
        System.out.println("Your account type is: " + customer.getAccountType().getType());
        System.out.println("Your account number is : " + customer.getAccountNumber());
        System.out.println("Your account pin is: " + customer.getAccountPin());
        System.out.println("Your current account balance is : " + customer.getAccountBalance());
    }

    public String customerName() {
        System.out.println("Enter the following details");
        System.out.println("Your Account Name:");
        Scanner inputFour = new Scanner(System.in);
        String name = inputFour.nextLine();
        while (!Pattern.matches("[a-zA-Z][a-zA-Z]*", name)) {
            System.out.println("Nope! Enter your Name : ");
            name = inputFour.nextLine();
        }
        return name;
    }
        public String customerPin() {

            System.out.println("Your Account Pin:");
            Scanner inputOne = new Scanner(System.in);
            String pin = inputOne.nextLine();
            while (!Pattern.matches("([0-9]|[0-9]{2}|[0-9]{3}|[0-9]{4})", pin)) {
                System.out.println("Nope! Enter your Pin : ");
                pin = inputOne.nextLine();
            }
            return pin;
        }

    public void closeAccount(){

    }

    public void balance(Customer customer) {
        System.out.println("Your current balance : " + customer.getAccountBalance());
    }

    public boolean verify(Customer customer,int accountPin) {
        if (accountPin == customer.getAccountPin()) {
            return true;
        } else {
            return false;
        }
    }
}
