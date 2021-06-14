package xyzBank;

public class ATM<C>{
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void showBalance(C card, int pin) {
        if(card instanceof  DebitCard){
            if(((DebitCard) card).getPin() == pin){
                System.out.println("ACCOUNT NAME :" + ((DebitCard)card).getName());
                System.out.println("ACCOUNT NUMBER :" + ((DebitCard)card).getNumber());
                System.out.println("YOUR ACCOUNT BALANCE FOR YOUR ACCOUNT IS: USD " + ((DebitCard)card).getBalance() );
            }else{
                System.out.println("Enter Correct pin");
            }
        }
        if(card instanceof  CreditCard){
                if(((CreditCard) card).getPin() == pin){
                    System.out.println("ACCOUNT NAME :" + ((CreditCard)card).getName());
                    System.out.println("ACCOUNT NUMBER :" + ((CreditCard)card).getNumber());
                    System.out.println("YOUR ACCOUNT BALANCE FOR YOUR ACCOUNT IS: USD " + ((CreditCard)card).getBalance() );
                }else{
                    System.out.println("Enter Correct pin");
                }
            }
    }

    public void swipe(C card, int pin, double amount){
        if(card instanceof  CreditCard){
            if(((CreditCard) card).getPin() == pin){
                double tax = amount<=bank.getMinimumBalance() ? ((amount/100)* bank.getBasicTaxPercent()) :((amount/100) * bank.getPremiumTaxPercent());
                if(amount % bank.getDenomination() !=0){
                    System.out.println("please correct the amount of value.It Should be multiple of USD " +bank.getDenomination());
                }else if(((((CreditCard) card).getBalance()+ tax ) < amount) || ((CreditCard) card).getBalance() < bank.getMinimumBalance()){
                    System.out.println("Insufficient funds, Current balance is " + ((CreditCard) card).getBalance());
                }else{
                    ((CreditCard) card).debit(amount + tax );
                    ((CreditCard) card).cashBack((amount/ bank.getMinimumBalance())* bank.getCashBackPercent());
                    System.out.println("The transaction of USD" + amount + " complete with tax USD" + tax + " and the current balance is USD" + ((CreditCard) card).getBalance());
                    System.out.println("Yay! you got cashback of USD " + (amount/100)* bank.getCashBackPercent());
                }
            }else{
                System.out.println("Enter Correct pin");
            }
        }
        if(card instanceof  DebitCard){
            if(((DebitCard) card).getPin() == pin){
                if(amount % bank.getDenomination() !=0){
                    System.out.println("please correct the amount of value.It Should be multiple of USD " +bank.getDenomination());
                }else if(((((DebitCard) card).getBalance()) < amount) || ((DebitCard) card).getBalance() < bank.getMinimumBalance()){
                    System.out.println("Insufficient funds, Current balance is " + ((DebitCard) card).getBalance());
                }else{
                    ((DebitCard) card).debit(amount);
                    System.out.println("The transaction of USD" + amount + "and the current balance is USD" + ((DebitCard) card).getBalance());
                }

            }else{
                System.out.println("Enter Correct pin");
            }
        }
    }

    public void withDraw(C card, int pin, double amount){
        if(card instanceof  CreditCard){
            if(((CreditCard) card).getPin() == pin){
                double tax = amount<=bank.getMinimumBalance() ? ((amount/100)* bank.getBasicTaxPercent()) :((amount/100) * bank.getPremiumTaxPercent());
                if(amount % bank.getDenomination() !=0){
                    System.out.println("please correct the amount of value.It Should be multiple of USD 5");
                }else if(((((CreditCard) card).getBalance()+ tax ) < amount) || ((CreditCard) card).getBalance() < bank.getMinimumBalance()){
                    System.out.println("Insufficient funds, Current balance is " + ((CreditCard) card).getBalance());
                }else{
                    ((CreditCard) card).debit(amount + tax );
                    System.out.println("The transaction of USD" + amount + " complete with tax USD" + tax + " and the current balance is USD" + ((CreditCard) card).getBalance());
                }
            }else{
                System.out.println("Enter Correct pin");
            }
        }
        if(card instanceof  DebitCard){
            if(((DebitCard) card).getPin() == pin){
                if(amount % bank.getDenomination() !=0){
                    System.out.println("please correct the amount of value.It Should be multiple of USD " +bank.getDenomination());
                }else if(((((DebitCard) card).getBalance()) < amount) || ((DebitCard) card).getBalance() < bank.getMinimumBalance()){
                    System.out.println("Insufficient funds, Current balance is " + ((DebitCard) card).getBalance());
                }else{
                    ((DebitCard) card).debit(amount);
                    System.out.println("The transaction of USD" + amount + "and the current balance is USD" + ((DebitCard) card).getBalance());
                }
            }else{
                System.out.println("Enter Correct pin");
            }
        }

    }

    public void deposit(C card, int pin, double amount){
        if(card instanceof  CreditCard){
            if(((CreditCard) card).getPin() == pin){
                ((CreditCard) card).deposit(amount);
                System.out.println("Amount deposited successfully, current baance " + ((CreditCard) card).getBalance());
            }else{
                System.out.println("Enter Correct pin");
            }
        }
        if(card instanceof  DebitCard){
            if(((DebitCard) card).getPin() == pin){
                ((DebitCard) card).deposit(amount);
                System.out.println("Amount deposited successfully, current baance " + ((DebitCard) card).getBalance());
            }else{
                System.out.println("Enter Correct pin");
            }
        }
    }
}
