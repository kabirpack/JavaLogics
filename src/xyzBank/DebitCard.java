package xyzBank;

public class DebitCard {

    private long number;
    private String validFrom;
    private String validTo;
    private int cvv;
    private int pinNumber;
    private Account account;

    public DebitCard(long number, String validFrom, String validTo, int cvv, int pinNumber, Account account) {
        this.number = number;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.cvv = cvv;
        this.pinNumber = pinNumber;
        this.account = account;
    }

    public void showBalance(int pin){
        if(this.pinNumber != pin){
            System.out.println("please enter correct pin number");
        }else{
            System.out.println(account.getBalance());
        }

    }

    public void swipe(int pin, double amount){
        double tax = amount<=100.00 ? ((amount/100)*2) :((amount/100)*4) ;
        if(this.pinNumber != pin){
            System.out.println("please enter correct pin number");
        }else if(amount % 5 !=0){
            System.out.println("please correct the amount of value.It Should be multiple of USD 5");
        }else if(((account.getBalance()+ tax ) < amount) || account.getBalance() < 100.00){
            System.out.println("Insufficient funds, Current balane is " + account.getBalance());
        }else{
            account.debit(amount + tax );
            account.cashBack((amount/100)*1);
            System.out.println("The transaction of USD" + amount + " complete with tax USD" + tax + " and the current balance is USD" + account.getBalance());
            System.out.println("Yay! you got cashback of USD " + (amount/100)*1);
        }

    }

    public void withDraw(int pin, double amount){
        double tax = amount<=100.00 ? ((amount/100)*2) :((amount/100)*4) ;
        if(this.pinNumber != pin){
            System.out.println("please enter correct pin number");
        }else if(amount % 5 !=0){
            System.out.println("please correct the amount of value.It Should be multiple of USD 5");
        }else if(((account.getBalance()+ tax) < amount) || account.getBalance() < 100.00){
            System.out.println("Insufficient funds, Current balane is USD" + account.getBalance());
        }else{
            account.debit(amount + tax );
            System.out.println("The withdrawal of USD" + amount + " complete with tax USD" + tax + " and the current balance is USD" + account.getBalance());
        }

    }


}
