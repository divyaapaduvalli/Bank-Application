import java.util.*;

public class BankMain{
    public static void main(String[] args) {
        //ArrayList<Customer> customer=new ArrayList<Customer>();
        HashMap<Integer, Integer> buffer = new HashMap<Integer, Integer>();
        int randomNumber, randomPin = 0;
        HashMap<Integer,Customer> customer= new HashMap<Integer,Customer>();
        int number;
        String pin;
        Bank bank=new Bank();

        Scanner input = new Scanner(System.in);
        int firstTransaction=0;
        int choice;

       do {
            System.out.println("\nType\n1. To create account\n2. To carry out a transaction \n3. To close an account\n4. To exit\n");
            try {
                switch (input.nextInt()) {
                    case 1:
                        Random random = new Random();
                        do {
                            randomNumber = random.nextInt(999999999) + 100000000;
                            randomPin = random.nextInt(9999) + 1000;
                        } while (buffer.containsKey(randomNumber) && buffer.containsValue(randomPin));

                        buffer.put(randomNumber, randomPin);

                        System.out.println("Enter the type of account that you want to create?\n1. Savings Account\n2. Current Account\n3. Fixed Account\n4. Recurring Account");
                        Scanner inputTwo = new Scanner(System.in);
                        switch (inputTwo.nextInt()) {
                            case 1:
                                customer.put(randomNumber,new Customer(new SavingsAccount(),randomNumber,randomPin));
                                break;
                            case 2:
                                customer.put(randomNumber,new Customer(new CurrentAccount(),randomNumber,randomPin));
                                break;
                            case 3:
                                customer.put(randomNumber,new Customer(new FixedAccount(),randomNumber,randomPin));
                                customer.get(randomNumber).getAccountType().depositTimePeriod(customer.get(randomNumber));
                                break;
                            case 4:
                                customer.put(randomNumber,new Customer(new RecurringAccount(),randomNumber,randomPin));
                                customer.get(randomNumber).getAccountType().depositTimePeriod(customer.get(randomNumber));
                                break;
                        }
                        firstTransaction=1;
                        bank.createAccount(customer.get(randomNumber));
                        bank.customerInformation(customer.get(randomNumber));
                        customer.get(randomNumber).getAccountType().deposit(customer.get(randomNumber),firstTransaction);
                        System.out.println("Your balance is "+ customer.get(randomNumber).getAccountBalance());
                        break;

                    case 2:
                        if(firstTransaction!=0) {
                            number = Integer.parseInt(bank.customerNumber());
                            while (!customer.containsKey(number)) {
                                System.out.println("Account not found. Enter correct account number");
                                number = Integer.parseInt(bank.customerNumber());
                            }
                            pin = bank.customerPin();
                            while (!(Integer.parseInt(pin) == buffer.get(number))) {
                                System.out.println("Enter correct pin number");
                                pin = bank.customerPin();
                            }
                            System.out.println("Choose one of the following activity :");
                            System.out.println("1. Deposit | 2. Withdrawal | 3. Balance | 4. Exit");
                            choice = input.nextInt();

                            switch (choice) {
                                case 1:
                                    firstTransaction = 2;
                                    customer.get(number).getAccountType().deposit(customer.get(number), firstTransaction);
                                    System.out.println("Your balance " + customer.get(number).getAccountBalance());/*out side the switch*/
                                    break;
                                case 2:
                                    customer.get(number).getAccountType().withdraw(customer.get(number));
                                    System.out.println("Your balance " + customer.get(number).getAccountBalance());
                                    break;
                                case 3:
                                    System.out.println("Your balance " + customer.get(number).getAccountBalance());
                                    break;
                                case 4:
                                    break;
                            }
                        }
                        else{
                            System.out.println("Account not found. Create an account first!");
                        }
                        break;
                    case 3:
                        System.out.println("Do you really want to close the account? yes | no | exit");
                        Scanner choiceOne = new Scanner(System.in);
                        switch (choiceOne.next()) {
                            case "yes":
                                number = Integer.parseInt(bank.customerNumber());
                                while(!customer.containsKey(number) ) {
                                    System.out.println("Account not found. Enter correct account number");
                                    number = Integer.parseInt(bank.customerNumber());
                                }
                                pin = bank.customerPin();
                                while(!(Integer.parseInt(pin)==buffer.get(number)) ){
                                    System.out.println("Enter correct pin number");
                                    pin = bank.customerPin();
                                }
                                customer.remove(number);
                                System.out.println("Account closed successfully");
                                break;
                            case "no":
                                break;
                            default:
                                System.out.println("Enter proper choice");
                        }
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("enter the proper choice");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("enter proper choice");
            }
        }while(true);

    }
}