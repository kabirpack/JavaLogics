import java.util.LinkedHashMap;
import java.util.Map;

public class ColourBaloon {

    public static String temp;

    public static void baloonSort(String arr[]){

        Map<String, Integer> hashmap = new LinkedHashMap<>();

        for (int j = 0; j < arr.length; j++) {
            hashmap.put(arr[j], j);
        }
        Object firstKey = hashmap.keySet().toArray()[0];
        Object secondKey = hashmap.keySet().toArray()[1];
        Object thirdKey = hashmap.keySet().toArray()[2];

        int startPointer = 0;
        int middlePointer = 0;
        int endPointer = arr.length-1;

        while(middlePointer <= endPointer){

            if (arr[middlePointer] == firstKey){
                temp = arr[startPointer];
                arr[startPointer]= arr[middlePointer];
                arr[middlePointer] = temp;

                startPointer++;
                middlePointer++;

            }

            if (arr[middlePointer] == secondKey){
                middlePointer ++;
            }

            if (arr[middlePointer] == thirdKey){
                temp = arr[middlePointer];
                arr[middlePointer]= arr[endPointer];
                arr[endPointer] = temp;

                endPointer--;

            }

        }
        for(int i=0; i <arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args){

        String[] arrBaloon = new String[]{"r", "g", "b", "g", "b", "g", "r"};
        baloonSort(arrBaloon);
    }
}
