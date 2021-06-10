package xyzBank;

public class BankMain {

    public static void main(String[] args){

        Bank xyz = new Bank("XYZ", "Mayiladuthurai", "IFSCXYZ");

        Account myAccount = new Account("arun kumar","0224970","03/05/97","9894513548","055478678",1000.00, xyz);

        DebitCard myCard = new DebitCard(787898989,"06/21", "06/26",377,3597,myAccount);
        myAccount.deposit(100.00);
        myCard.swipe(3597,25.00);
        myCard.showBalance(3597);
        myCard.withDraw(3597, 70.00);
        myCard.showBalance(3597);
    }
}
