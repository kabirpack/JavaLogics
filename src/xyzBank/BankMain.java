package xyzBank;

import java.util.Locale;
import java.util.Scanner;


public class BankMain {
    private String name = "user";
    private String prompt;
    private Bank xyzBank = new Bank("XYZ BANK");
    private ATM xyzATM = new ATM(xyzBank);
    private Account account;
    private CreditCard creditCard;
    private DebitCard debitCard;
    public String cardChoice = "CREDITCARD";
    //BankMain bank ;

    public static String cmdPrompt(String msg){
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        String userChoice = sc.nextLine().toUpperCase(Locale.ROOT);
        return userChoice;
    }
    public void atmInterface(){
        System.out.println("What would you like to do?");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice\n 1.Shop\n2.Withdraw\n3.Deposit\n4.ShowBalance");
        if(cardChoice.equals(null)){
            System.out.println("What card do you use debitcard/creditcard?");
            cardChoice = sc.nextLine();
        }
        String atmChoice = sc.nextLine().toUpperCase(Locale.ROOT);
        switch (atmChoice){
            case "SHOP":{
                System.out.println("Enter Amount:");
                Double amount = sc.nextDouble();
                System.out.println("Enter pin");
                int enteredPin = sc.nextInt();
                xyzATM.swipe(cardChoice.equals("CREDITCARD")?creditCard:debitCard, enteredPin, amount);
                break;
            }
            case "WITHDRAW":{
                System.out.println("Enter Amount:");
                Double amount = sc.nextDouble();
                System.out.println("Enter pin");
                int enteredPin = sc.nextInt();
                xyzATM.withDraw(cardChoice.equals("CREDITCARD")?creditCard:debitCard, enteredPin, amount);
                break;
            }
            case "SHOWBALANCE":{
                System.out.println("Enter pin");
                int enteredPin = sc.nextInt();
                xyzATM.showBalance(cardChoice.equals("CREDITCARD")?creditCard:debitCard, enteredPin);
                break;
            }
            case "DEPOSIT": {
                System.out.println("Enter Amount:");
                Double amount = sc.nextDouble();
                System.out.println("Enter pin");
                int enteredPin = sc.nextInt();
                xyzATM.deposit(cardChoice.equals("CREDITCARD")?creditCard:debitCard, enteredPin, amount);
                break;
            }
        }
        prompt = cmdPrompt("Would you like to do another transaction");
        if(prompt.equals("YES")){
            atmInterface();
        } else{
            System.out.println("Thanks");
        }

    }
    public void bankUserInterface(int step){
        Scanner sc = new Scanner(System.in);
        switch (step){
            case 0:{
                System.out.println("Hi User, Please Enter your Name:");
                name = sc.nextLine();
                step++;
                bankUserInterface(step);
                return;
            }
            case 1:{
                prompt = cmdPrompt("Hi "+name+ " Welcome to XYZ Bank\n Would you like to create an account?\n yes or no").toUpperCase(Locale.ROOT);
                System.out.println(prompt);
                switch (prompt){
                    case "YES":{
                        long accountNumber = xyzBank.generateAccountNumber();
                        account = new Account(name, accountNumber);
                        System.out.println("Account Created Successfully\n" + "Account Name : "+ account.getName()+"\n" + "Account Number: "+ account.getNumber() );
                        step++;
                        bankUserInterface(step);
                        break;
                    }
                    case "NO":{
                        prompt = cmdPrompt("Would you like to Exit? yes or no");
                        if(prompt.equals("YES")){
                            System.out.println("Thanks");
                            System.exit(0);
                        }else{
                            bankUserInterface(step--);
                        }
                    }
                }
                return;
            }
            case 2: {
                prompt = cmdPrompt("Would you like to get card?").toUpperCase(Locale.ROOT);
                if (prompt.equals("YES")) {
                    System.out.println("Two options available\n1.CreditCard\n2.DebitCard\nInfo:Credit card offers unlimited transactions(tax applied)\nDebit card offers limited transactions(No tax applied)");
                    bankUserInterface(++step);
                    return;
                } else {
                    System.out.println("Card is must to process transaction");
                    prompt = cmdPrompt("Are you sure?, yes or no").toUpperCase(Locale.ROOT);
                    if (prompt.equals("NO")) {
                        bankUserInterface(step);
                    } else {
                        System.out.println("Thanks");
                        System.exit(0);
                    }
                }
            }
            case 3: {
                cardChoice = sc.nextLine().toUpperCase(Locale.ENGLISH);
                if(cardChoice.equals("CREDITCARD")){
                    long cardNumber = xyzBank.generateCardNumber();
                    String validFrom = xyzBank.generateValidFrom();
                    String validTo = xyzBank.generateValidTo();
                    int cvv = xyzBank.generateCVV();
                    int pin = xyzBank.generatePin();
                    creditCard = account.createCreditCard(cardNumber,validFrom,validTo,cvv,pin);
                    System.out.println("Credit card created succefully");
                    System.out.println("Your Confidential pin number: "+creditCard.getPin());
                    return;
                }else if(cardChoice.equals("DEBITCARD")){
                    long cardNumber = xyzBank.generateCardNumber();
                    String validFrom = xyzBank.generateValidFrom();
                    String validTo = xyzBank.generateValidTo();
                    int cvv = xyzBank.generateCVV();
                    int pin = xyzBank.generatePin();
                    debitCard = account.createDebitCard(cardNumber,validFrom,validTo,cvv,pin);
                    System.out.println("Debit card created succefully");
                    System.out.println("Your Confidential pin number: "+debitCard.getPin());
                    return;
                }
            }
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BankMain bank = new BankMain();
        bank.prompt = cmdPrompt("new user?").toUpperCase(Locale.ROOT);
        if(bank.prompt.equals("YES")){
            bank.bankUserInterface(0);
            bank.atmInterface();
        }else{
            System.out.println("Hi User, Please Enter your Name:");
            bank.name = sc.nextLine();
            long accountNumber = bank.xyzBank.generateAccountNumber();   // simulation of already existing account
            bank.account = new Account(bank.name, accountNumber);
            System.out.println("What card do you use debitcard/creditcard?");
            bank.bankUserInterface(3);   // simulation of already existing card
            bank.atmInterface();
        }
    }
}
