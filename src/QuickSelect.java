// Java code for kth smallest element in an array

import java.util.Scanner;

class QuickSelect {

    public static int pivotMin(Integer[] arr, int startIndex,
                               int endIndex)
    {
        int x = arr[endIndex], i = startIndex;
        for (int j = startIndex; j <= endIndex - 1; j++) {
            if (arr[j] <= x) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[endIndex];
        arr[endIndex] = temp;

        return i;
    }

    public static int pivotMax(Integer[] arr, int startIndex,
                               int endIndex)
    {
        int x = arr[endIndex], i = startIndex;
        for (int j = startIndex; j <= endIndex - 1; j++) {
            if (arr[j] >= x) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[endIndex];
        arr[endIndex] = temp;

        return i;
    }

    public static int kthSmallest(Integer[] arr, int l,
                                  int r, int k)
    {
        if (k > 0 && k <= r - l + 1) {
            int pos = pivotMin(arr, l, r);
            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return 1;
    }

    public static int kthLargest(Integer[] arr, int l,
                                  int r, int k)
    {
        if (k > 0 && k <= r - l + 1) {
            int pos = pivotMax(arr, l, r);
            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)
                return kthLargest(arr, l, pos - 1, k);
            return kthLargest(arr, pos + 1, r, k - pos + l - 1);
        }
        return 1;
    }


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("array size:");
        int n=sc.nextInt();
        Integer[] arr = new Integer[n];
        System.out.println("array elements:");
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("k position");
        int k = sc.nextInt();
        System.out.println("K'th smallest element is " + kthSmallest(arr, 0, arr.length - 1, k));
        System.out.println("K'th Largest element is " + kthLargest(arr, 0, arr.length - 1, k));

    }
}

