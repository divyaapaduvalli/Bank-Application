import java.util.*;

public class BankMain{
    public static void main(String[] args) {
        ArrayList<Customer> customer=new ArrayList<Customer>();
        Bank bank=new Bank();

        Scanner input = new Scanner(System.in);
        int firstTransaction=0;
        int choice;
        int count = -1;
        boolean temp=true;

       do {
            System.out.println("\nType\n1. To create account\n2. To carry out a transaction \n3. To close an account\n4. To exit\n");
            try {
                switch (input.nextInt()) {
                    case 1:
                        System.out.println("Enter the type of account that you want to create?\n1. Savings Account\n2. Current Account\n3. Fixed Account\n4. Recurring Account");
                        Scanner inputTwo = new Scanner(System.in);
                        switch (inputTwo.nextInt()) {
                            case 1:
                                customer.add(new Customer(new SavingsAccount()));
                                count++;
                                break;
                            case 2:
                                customer.add(new Customer(new CurrentAccount()));
                                count++;
                                break;
                            case 3:
                                customer.add(new Customer(new FixedAccount()));
                                count++;
                                customer.get(count).getAccountType().depositTimePeriod(customer.get(count));
                                break;
                            case 4:
                                customer.add(new Customer(new RecurringAccount()));
                                count++;
                                customer.get(count).getAccountType().depositTimePeriod(customer.get(count));
                                break;
                        }
                        firstTransaction=1;
                        bank.createAccount(customer.get(count));
                        bank.customerInformation(customer.get(count));
                        customer.get(count).getAccountType().deposit(customer.get(count),firstTransaction);
                        System.out.println("Your balance is "+ customer.get(count).getAccountBalance());

                        break;

                    case 2:
                        System.out.println("Choose one of the following activity :");
                        System.out.println("1. Deposit | 2. Withdrawal | 3. Balance");
                        choice = input.nextInt();
                        String name=bank.customerName();
                        String pin=bank.customerPin();
                        for (int i = 0; i < customer.size(); i++) {
                            if (customer.get(i).getAccountPin() == Integer.parseInt(pin)) {

                                count = i;
                            }
                        }
                        if(count==-1){
                            System.out.println("Account not found.");
                            break;
                        }
                        switch (choice) {
                            case 1:
                                firstTransaction=2;
                                customer.get(count).getAccountType().deposit(customer.get(count),firstTransaction);
                                System.out.println("Your balance " + customer.get(count).getAccountBalance());
                                break;
                            case 2:
                                customer.get(count).getAccountType().withdraw(customer.get(count));
                                System.out.println("Your balance " + customer.get(count).getAccountBalance());
                                break;
                            case 3:
                                System.out.println("Your balance " + customer.get(count).getAccountBalance());
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("Do you really want to close the account? yes | no");
                        Scanner choiceOne = new Scanner(System.in);
                        switch (choiceOne.next()) {
                            case "yes":
                                name=bank.customerName();
                                do{
                                    pin= bank.customerPin();
                                    for (int i = 0; i < customer.size(); i++) {
                                        if (customer.get(i).getAccountPin() == Integer.parseInt(pin)) {
                                        temp=false;
                                        count =i;
                                        }
                                    }
                                    if(!temp) {
                                        customer.remove(count);
                                        System.out.println("Account closed successfully");
                                        break;
                                    }
                                }while(temp);
                            case "no":
                                break;
                            default:
                                System.out.println("Enter proper choice");
                        }
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("enter the proper choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("enter proper choice");
            }
        }while(true);
    }
}