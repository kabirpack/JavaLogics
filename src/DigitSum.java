import java.util.ArrayList;
import java.util.Scanner;

public class DigitSum {

    public static int digitSum(int x){
        int sum = 0;

        while (x != 0)
        {
            sum = sum + x % 10;
            x = x/10;
        }
        return sum;
    }

    public static int digitCount(int x){

        int count = 0;
        while (x != 0) {
            x = x / 10;
            ++count;
        }
        return count;

    }
    public static boolean isTrap(int x, int y){
        if(digitCount(x) == 1 && x != y){
            if(x%y !=0 && y%x != 0) {
                return false;
            }
        }

        if(x == y){
            return true;
        }else if(x%y == 0 || y%x == 0){
            return true;
        }else if(isTrap(digitSum(x),y)){
            return true;
        }
    return false;
    }

    public static void main(String[] arg){
        ArrayList<Integer> trapSequence = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Ener n1");
        int n1 = sc.nextInt();
        System.out.println("Ener n2");
        int n2 = sc.nextInt();
        System.out.println("Ener y");
        int y  = sc.nextInt();

        if(n1 > n2){
            System.out.println("None");
        }else {

            for (int i = n1; i <= n2; i++) {
                if(y < 3){
                    y = 3;
                }
                if(isTrap(i, y)) {
                    trapSequence.add(i);
                    y += 2;
                }else {
                    y -= 1;
                }
            }
            if(trapSequence.size() > 1){
                System.out.println(trapSequence);
            }else{
                System.out.println("None");
            }
        }
    }
}
