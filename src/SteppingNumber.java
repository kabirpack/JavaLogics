import java.util.Scanner;

public class SteppingNumber {

    public static boolean isStepNum(int n)
    {
        int flag = 0;
        if(Integer.toString(n).trim().length() == 1){
            flag = 1;
            return true;
        }

        if(flag == 0) {
            int lastDigit = n % 10;
            int firstDigit = n;
            while (firstDigit >= 10){
                firstDigit /= 10;
            }
            if(Math.abs(firstDigit-lastDigit) != 1){
                return false;
            }
            int prevDigit = -1;
            while (n > 0) {
                int curDigit = n % 10;
                if (prevDigit != -1) {
                    if (Math.abs(curDigit - prevDigit) != 1)
                        return false;
                }
                n /= 10;
                prevDigit = curDigit;
            }
            return true;
        }
        return false;
    }

    public static void displaySteppingNumbers(int n,int m)
    {
        int count = 0;
        for (int i = n; i <= m; i++) {
            if (isStepNum(i)) {
                System.out.print(i + " ");
                count = count + 1;
            }
        }
        if(count == 0){
            System.out.println("No stepping numbers present in this range");
        }
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Starting range:");
        int n = sc.nextInt();
        System.out.println("Ending range:");
        int m = sc.nextInt();
        displaySteppingNumbers(n,m);
    }
}
