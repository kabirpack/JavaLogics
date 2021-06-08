import java.util.Scanner;

public class ReverseNumber {
    static int reversDigits(int num)
    {
        int revNum = 0;
        while (num > 0) {
            revNum = revNum * 10 + num % 10;
            num = num / 10;
        }
        return revNum;
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Number to be reversed:");
        int num = sc.nextInt();

        System.out.println("Reverse of no. is "
                + reversDigits(num));
    }
}
