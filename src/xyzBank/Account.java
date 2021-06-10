package xyzBank;

public class Account {
    private String name;
    private String number;
    private String dob;
    private String phoneNumber;
    private String aadharNumber;
    private final double minimumBalance = 100.00;
    private double balance;
    private Bank bank;

    public Account(String name, String number, String dob, String phoneNumber, String aadharNumber, double balance, Bank bank) {
        this.name = name;
        this.number = number;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.aadharNumber = aadharNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void debit(double amount){
        this.balance -= amount;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void cashBack(double amount){
        this.balance += amount;
    }

    public String getNumber() {
        return number;
    }

    public String getDob() {
        return dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }
}
