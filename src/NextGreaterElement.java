import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NextGreaterElement {

    public static int NGE(List<Integer> arr) {
        int max = arr.get(0);

        for(int i = 1 ; i < arr.size(); i++ ) {
            if(arr.get(i) > arr.get(0)) {
                if(max == arr.get(0)) {  // first max found
                    max = arr.get(i);
                }
                else if ( max - arr.get(0)  > arr.get(i) - arr.get(0) ) { // subsequent max found(comparing maxs)
                    max = arr.get(i);
                }
            }
        }
        return (max == arr.get(0))? -1 : max;
    }

    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> myArr = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < size; i++){
            int num = sc.nextInt();
            myArr.add(num);
        }
        for(int i = 0; i< myArr.size(); i++) {
            result.add(NGE(myArr.subList(i, myArr.size())));
        }
        System.out.println(result);
    }

}