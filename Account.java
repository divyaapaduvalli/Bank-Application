interface Account {
    String type="";
    String getType();
    void withdraw(Customer customer);
    void interest(Customer customer);
    void depositTimePeriod(Customer customer);
    void deposit(Customer customer);
    void deposit(Customer customer,int firstTransaction);
}
