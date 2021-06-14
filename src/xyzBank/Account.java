package xyzBank;

public class Account {
    private String name;
    private long number;
    private double balance;
    private DebitCard debitcard;
    private CreditCard creditCard;

    public Account(String name, long number) {
        this.name = name;
        this.number = number;
        this.balance = 100.00;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
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
    public CreditCard createCreditCard(long cardNumber, String validFrom, String validTo, int cvv, int pin) {
        this.creditCard = new CreditCard(this,cardNumber,validFrom,validTo,cvv,pin);
        return creditCard;
    }

    public DebitCard  createDebitCard(long cardNumber, String validFrom, String validTo, int cvv, int pin) {
        this.debitcard = new DebitCard(this,cardNumber,validFrom,validTo,cvv,pin);
        return debitcard;
    }
}
