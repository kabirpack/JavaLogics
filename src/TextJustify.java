import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextJustify {

    public static List<String> fullJustify(String[] words, int maxWidth){

        List<String> result = new ArrayList<>();

        int i = 0;
        int n=words.length;

        while(i<n){
            int j = i+1;
            int lineLength = words[i].length();
            while(j < n && (lineLength + words[j].length() + (j-i-1) < maxWidth)){

                lineLength += words[j].length();
                ++j;
            }

            int diff = maxWidth - lineLength;
            int numberOfWords = j - i;
            if (numberOfWords == 1 || j>=n) {
                result.add(leftJustify(words, diff, i, j));
            }else{
                result.add(middleJustify(words, diff, i, j));
            }
            i = j;
        }
        return result;
    }


    public static String leftJustify(String[] words, int diff, int i, int j){
        int spacesOnRight = Math.abs(diff-(j - i - 1));
        StringBuilder result = new StringBuilder(words[i]);
        for (int k=i+1; k<j-1; ++k){
            result.append((" "+words[k]));
        }

        result.append(" ".repeat(spacesOnRight));

        return result.toString();
    }

    public static String middleJustify(String[] words, int diff, int i, int j ){

        int spaceNeeded = j-i-1;
        int spaces = diff/spaceNeeded;
        int extraSpaces = diff% spaceNeeded;

        StringBuilder result = new StringBuilder(words[i]);
        for (int k= i+1; k<j; ++k){
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            result.append(" ".repeat(spacesToApply) + words[k]);
        }

        return result.toString();
    }

    public static void main(String[] args){

        String[] arr = new String[]{"what", "is", "an", "example", "of", "text", "justification"};
        Scanner sc= new Scanner(System.in);
        System.out.println("max limit");
        int L = sc.nextInt();

        for (int i=0;i < fullJustify(arr,L).size();i++){
            System.out.println(fullJustify(arr,L).get(i));
        }

    }

}
