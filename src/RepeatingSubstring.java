import java.util.ArrayList;
import java.util.Scanner;

public class RepeatingSubstring {
    public static String lcp(String s, String t){
        int n = Math.min(s.length(),t.length());
        for(int i = 0; i < n; i++){
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(0,i);
            }
        }
        return s.substring(0,n);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input =sc.nextLine();
        String str = input.toLowerCase();
        String lrs="";
        ArrayList<String> arr = new ArrayList<String>();
        String arr1[];
        String temp[];
        int n = str.length();
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                String x = lcp(str.substring(i,n),str.substring(j,n));
                if(x.length()>2){
                    arr.add(x);
                }
                if(x.length() > lrs.length()) lrs=x;
            }
        }
        int arrlength = arr.size();
        for(int z=0; z < arrlength; z++){
            for(int i = 0; i < arrlength; i++){
                for(int j = 0; j < arrlength; j++){
                    String temp1 = arr.get(i);
                    String temp2 = arr.get(j);
                    if(temp1.contains(temp2)){
                        if(temp1.length() > temp2.length()){
                            arr.remove(j);
                            arrlength = arrlength-1;
                        }
                    }
                }
            }
        }
        if(arr.size() > 0) {
            for(int i = 0; i < arr.size(); i++){
                System.out.print(arr.get(i)+",");
            }
//            System.out.println("Longest repeating sequence: " + arr);
        }else{
            System.out.println("No substring found");
        }
    }
}  

