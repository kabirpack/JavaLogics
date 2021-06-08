import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] solve(int[] arr){
        int[] nge = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        st.push(arr[arr.length - 1]);

        nge[arr.length - 1] = -1;

        for(int i = arr.length-2; i >=0; i--){
            // -a+
            while(st.size() > 0 && arr[i] > st.peek()) {
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = -1;

            }else{
                nge[i] = st.peek();
            }

            st.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("array size:");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("array elements:");
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        NextGreaterElement ng = new NextGreaterElement();
        int[] newArr = ng.solve(arr);
        for(int i=0; i <newArr.length; i++){
            System.out.print(newArr[i] + " ");
        }
    }
}
