import java.util.Scanner;

class QuickSelect {

    public static int pivot(int[] arr, int startIndex,
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


    public static int kthElement(int[] arr, int l,
                                 int r, int k)
    {
        if (k > 0 && k <= r - l + 1) {
            int pos = pivot(arr, l, r);
            if (pos - l == k - 1)
                return arr[pos];
            if (pos - l > k - 1)
                return kthElement(arr, l, pos - 1, k);
            return kthElement(arr, pos + 1, r, k - pos + l - 1);
        }
        return 1;
    }

    public static int removeDuplicates(int a[], int n)
    {
        if (n == 0 || n == 1) {
            return n;
        }

        int j = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }

        a[j++] = a[n - 1];

        return j;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("array size:");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.println("array elements:");
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        int j = removeDuplicates(arr, n);

        // printing array elements
        for (int i = 0; i < j; i++)
            System.out.print(arr[i] + " ");
        System.out.println("k position");
        int k = sc.nextInt();
        System.out.println("K'th smallest element is " + kthElement(arr, 0, arr.length - 1, k));
        System.out.println("K'th Largest element is " + kthElement(arr, 0, arr.length - 1, arr.length-k+1));

    }
}

