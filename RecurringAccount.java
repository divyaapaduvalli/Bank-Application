import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.regex.Pattern;

public class RecurringAccount implements Account{
    private String type;
    private int depositPeriod;

    private Date depositDate;

    RecurringAccount(){
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
            this.depositDate = new Date();
            Scanner input = new Scanner(System.in);
            System.out.println("\nhow much you want to deposit");
            try {
                double deposit = input.nextDouble();
                while (deposit <= 0) {
                    System.out.println("Enter proper amount.");
                    deposit = input.nextDouble();
                }
                customer.setAccountBalance(customer.getAccountBalance() + deposit);
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
            Date currentDate = new Date();
            Scanner input = new Scanner(System.in);
            if (simpleDateFormat.format(currentDate).equals(simpleDateFormat.format(this.depositDate))) {
                System.out.println("Deposit the amount after a month");
            } else {
                System.out.println("How much you want to deposit?");
                try {
                    customer.setAccountBalance(customer.getAccountBalance() + input.nextDouble());
                } catch (Exception e) {
                    System.out.println("invalid input");
                }
            }
        }
    }
}
