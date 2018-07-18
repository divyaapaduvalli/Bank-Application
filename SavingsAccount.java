import java.util.Scanner;

public class SavingsAccount implements Account{
    private String type;
    SavingsAccount(){
        this.type="Savings Account";
    }
    public String getType(){return type;}
    public void withdraw(Customer customer) {
        Scanner input=new Scanner(System.in);
        System.out.println("How much do you want to withdraw?");
        try {
            double withdraw = input.nextDouble();
            while (withdraw <= 0) {
                System.out.println("Enter proper amount.");
                withdraw = input.nextDouble();
            }
            customer.setAccountBalance(customer.getAccountBalance() - withdraw);
        }
        catch(Exception e){
            System.out.println("invalid input");
        }
    }
    public void interest(Customer customer){
        customer.setAccountBalance(customer.getAccountBalance() + (customer.getAccountBalance() * (6 / 100)));
    }
    public void depositTimePeriod(Customer customer){
        System.out.println("You can deposit anytime.");
    }
    public void deposit(Customer customer){}
    public void deposit(Customer customer,int firstTransaction) {
        Scanner input= new Scanner(System.in);
        System.out.println("\nhow much you want to deposit");
        try {
            double deposit = input.nextDouble();
            while (deposit <= 0) {
                System.out.println("Enter proper amount.");
                deposit = input.nextDouble();
            }
            customer.setAccountBalance(customer.getAccountBalance() + deposit);
        }
        catch(Exception e){
            System.out.println("Invalid input");
        }
    }
}
