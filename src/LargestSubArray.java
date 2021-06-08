import java.util.HashMap;
import java.util.Scanner;

class LargestSubArray {


    public static int findMaxLength(int arr[], int n)
    {
        HashMap<Integer, Integer> mp
                = new HashMap<>();

        int sum = 0;
        int maxLen = 0;
        int endingIndex = -1;

        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                arr[i] = -1;
            } else{
                arr[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (sum == 0) {
                maxLen = i + 1;
                endingIndex = i;
            }

            if (mp.containsKey(sum)) {
                if (maxLen < i - mp.get(sum)) {
                    maxLen = i - mp.get(sum);
                    endingIndex = i;
                }
            }
            else
                mp.put(sum, i);
        }

        for (int i = 0; i < n; i++) {
            if(arr[i] == -1){
                arr[i] = 0;
            } else{
                arr[i] = 1;
            }
        }

        int end = endingIndex - maxLen + 1;
        System.out.println(end + " to " + endingIndex);

        return maxLen;
    }

    public static void main(String[] args)
    {
        LargestSubArray sub = new LargestSubArray();
        Scanner sc=new Scanner(System.in);
        System.out.print("array size:");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("array elements:");
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }

        sub.findMaxLength(arr, n);
    }
}
