import java.util.ArrayList;
import java.util.Collections;
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

    public static ArrayList<String> remove(ArrayList<String> arr){
        int arrlength = arr.size();

        for(int i = 0; i < arrlength; i++){
            for(int j = i+1; j < arrlength; j++){
                String temp1 = arr.get(i);
                temp1 = temp1.trim();
                String temp2 = arr.get(j);
                temp2 = temp2.trim();
                if(temp1.contains(temp2)){
                    if(temp1.length() > temp2.length()){
                        arr.set(j,"");

                    }
                    if(temp1.length() == temp2.length()){
                        arr.set(j,"");
                    }
                }
            }
        }

        return arr;

    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input ="everyday everything everyday";
        String str = input.toLowerCase();
        str = str.trim();
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

        ArrayList<String> removeResult = new ArrayList<String>();
        //first iteration arr=>removeResult
        removeResult = remove(arr);

        //----------------------------------------------

        ArrayList<String> small = new ArrayList<String>();

        //remove space and formating (removeResult)=>small
        for(int z = 0; z < removeResult.size(); z++){
            if(removeResult.get(z).length()>0){
                String temp1 = removeResult.get(z);
                String[] splited = temp1.split("\\s+");
                for(int w=0; w < splited.length ; w++){
                    small.add(splited[w]);
                }
            }
        }

        ArrayList<String> removeResult1 = new ArrayList<String>();
        //second iteration small=>removeResult1
        removeResult1 = remove(small);


        //--------------------------------------------


        //reverse of removeResult1
        Collections.reverse(removeResult1);
        ArrayList<String> afterReverse = new ArrayList<String>();
        //third iteration removeResult=>afterReverse
        afterReverse = remove(removeResult1);

        int count = 0;
        //ANSWER afterReverse
        for(int i=0;i<afterReverse.size();i++){
            if(afterReverse.get(i) != ""){
                System.out.print(afterReverse.get(i)+"");
                count++;
            }
        }
        if(count == 0){
            System.out.println("No repeating substring found");
        }



    }
}