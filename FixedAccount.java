package userDefined;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.time.temporal.ChronoUnit.DAYS;

public class FixedAccount implements Account{
    private String type;
    private int depositPeriod;

    private LocalDate depositDate;

    public FixedAccount(){
        this.type="Recurring Account";
    }
    public String getType(){return type;}

    public void withdraw(Customer customer){System.out.println("You cannot withdraw!");}
    public void interest(Customer customer){
        customer.setAccountBalance(customer.getAccountBalance() + (customer.getAccountBalance() * (6 / 100)));
    }
    public void depositTimePeriod(Customer customer){
        Scanner input=new Scanner(System.in);
        System.out.println("Choose the deposit period between 1 to 10 years");
        String depositPeriod=input.next();
        while(!Pattern.matches("[1-9]|[1][0]",depositPeriod)){
            System.out.println("Invalid deposit period");
            depositPeriod=input.next();
        }
        this.depositPeriod=Integer.parseInt(depositPeriod);
    }
    public void deposit(Customer customer){}
    public void deposit(Customer customer,int firstTransaction) {
        if (firstTransaction == 1) {
            this.depositDate = LocalDate.now();
            Scanner input = new Scanner(System.in);
            System.out.println("\nhow much you want to deposit");
            try {
                double deposit = input.nextDouble();
                while (deposit <= 0  || deposit>100000) {
                    System.out.println("Enter proper amount.");
                    deposit = input.nextDouble();
                }
                customer.setAccountBalance(customer.getAccountBalance() + deposit);
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } else {
            System.out.println("Cannot deposit!");
            }
        }
    }
