package xyzBank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;
    private final int basicTaxPercent = 2;
    private final int premiumTaxPercent = 4;
    private final double minimumBalance = 100.00;
    private final int denomination = 5;
    private final int cashBackPercent = 1;
    private ATM atm;
    private LocalDate fromDateObj;
    private LocalDate toDateObj;
    private final DateTimeFormatter cardDateFormat = DateTimeFormatter.ofPattern("MM-yyyy");
    private ArrayList<Account> bankAccounts = new ArrayList<Account>();

    public Bank(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        this.bankAccounts.add(account);       // add account to the bank
    }

    public ATM buildATM(){
        this.atm = new ATM(this);
        return atm;
    }
    public long generateCardNumber(){
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }
    public long generateAccountNumber(){
        return (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
    }
    public String generateValidFrom() {
        fromDateObj = LocalDate.now();
        return fromDateObj.format(cardDateFormat);
    }

    public String generateValidTo() {
        toDateObj = this.fromDateObj.plusYears(10);
        return toDateObj.format(cardDateFormat);
    }

    public int generateCVV() {
        return 100 + new Random().nextInt(900);
    }

    public int generatePin() {
        return 1000 + new Random().nextInt(9000);
    }

    public int getBasicTaxPercent() {
        return basicTaxPercent;
    }

    public int getPremiumTaxPercent() {
        return premiumTaxPercent;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public int getDenomination() {
        return denomination;
    }

    public int getCashBackPercent() {
        return cashBackPercent;
    }
}
