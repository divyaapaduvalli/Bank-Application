package userDefined;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.time.temporal.ChronoUnit.DAYS;

public class Customer {

    private String accountHolderFirstName;
    private String accountHolderMiddleName;
    private String accountHolderLastName;
    private int accountHolderAge;
    private Date accountHolderDob;
    private String accountHolderNumber;
    private String accountHolderStreet;
    private String accountHolderArea;
    private String accountHolderCity;
    private String accountHolderState;
    private String accountHolderPin;
    private String accountHolderEmailId;
    private String accountHolderAdhaarNumber;
    private Account accountType;
    private int accountNumber;
    private double accountBalance;
    private int accountPin;

    Customer(Account accountType, int accountNumber, int accountPin) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountPin = accountPin;
    }

    public void setAccountHolderFirstName(String accountHolderFirstName) {
        this.accountHolderFirstName = accountHolderFirstName;
    }

    public void setAccountHolderMiddleName(String accountHolderMiddleName) {
        if (accountHolderMiddleName.equalsIgnoreCase("na")) {
            this.accountHolderMiddleName = "";
        } else {
            this.accountHolderMiddleName = accountHolderMiddleName;
        }
    }

    public void setAccountHolderLastName(String accountHolderLastName) {
        if (accountHolderLastName.equalsIgnoreCase("na")) {
            this.accountHolderLastName = "";
        } else {
            this.accountHolderLastName = accountHolderLastName;
        }
    }

    public void setAccountHolderNumber(String accountHolderNumber) {
        this.accountHolderNumber = accountHolderNumber;
    }

    public void setAccountHolderStreet(String accountHolderStreet) {
        this.accountHolderStreet = accountHolderStreet;
    }

    public void setAccountHolderArea(String accountHolderArea) {
        this.accountHolderArea = accountHolderArea;
    }

    public void setAccountHolderCity(String accountHolderCity) {
        this.accountHolderCity = accountHolderCity;
    }

    public void setAccountHolderState(String accountHolderState) {
        this.accountHolderState = accountHolderState;
    }

    public void setAccountHolderPin(String accountHolderPin) {
        this.accountHolderPin = accountHolderPin;
    }


    public void setAccountHolderEmailId(String accountHolderEmailId) {
        this.accountHolderEmailId = accountHolderEmailId;
    }

    public void setAccountHolderAge(int accountHolderAge) {
        this.accountHolderAge = accountHolderAge;
    }

    public void setAccountHolderDob(Date accountHolderDob) {
        this.accountHolderDob = accountHolderDob;
    }

    public void setAccountHolderAdhaarNumber(String accountHolderAdhaarNumber) {
        this.accountHolderAdhaarNumber = accountHolderAdhaarNumber;
    }

    public void setAccountType(Account accountType) {
        this.accountType = accountType;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountPin(int accountPin) {
        this.accountPin = accountPin;
    }

    public String getAccountHolderFirstName() {
        return this.accountHolderFirstName;
    }

    public String getAccountHolderMiddleName() {
        return this.accountHolderMiddleName;
    }

    public String getAccountHolderLastName() {
        return this.accountHolderLastName;
    }

    public int getAccountHolderAge() {
        return this.accountHolderAge;
    }

    public Date getAccountHolderDob() {
        return this.accountHolderDob;
    }

    public String getAccountHolderNumber() {
        return this.accountHolderNumber;
    }

    public String getAccountHolderStreet() {
        return this.accountHolderStreet;
    }

    public String getAccountHolderArea() {
        return this.accountHolderArea;
    }

    public String getAccountHolderCity() {
        return this.accountHolderCity;
    }

    public String getAccountHolderState() {
        return this.accountHolderState;
    }

    public String getAccountHolderPin() {
        return this.accountHolderPin;
    }

    public String getAccountHolderEmailId() {
        return this.accountHolderEmailId;
    }

    public String getAccountHolderAdhaarNumber() {
        return this.accountHolderAdhaarNumber;
    }

    public Account getAccountType() {
        return this.accountType;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public int getAccountPin() {
        return this.accountPin;
    }

}