import java.util.Scanner;

public class CurrentAccount implements Account {
    private String type;
    CurrentAccount(){
        this.type="Current Account";
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
            System.out.println("Invalid Input");
        }
    }
    public void interest(Customer customer){
        System.out.println("No interest for this kind of account.");
    }
    public void depositTimePeriod(Customer customer){
        System.out.println("You can deposit anytime.");
    }
    public void deposit(Customer customer){}
    public void deposit(Customer customer,int firstTransaction) {
        Scanner input=new Scanner(System.in);
        System.out.println("How much do you want to deposit?");
        try {
            double deposit = input.nextDouble();
            while (deposit <= 0) {
                System.out.println("Enter proper amount.");
                deposit = input.nextDouble();
            }
            customer.setAccountBalance(customer.getAccountBalance() + deposit);
        }
        catch(Exception e){
            System.out.println("Invalid Input");
        }
    }
}
