package InterviewQuestions_HashMapProblems;
import java.util.HashMap;

public class Counting {

    public static void main(String[] args) {

        int[] arr = {10, 11, 3, 4, 3, 4, 10, 11};

        System.out.println(evenOccurrences(arr));

        HashMap<Integer, Integer> map = countsOfNum(arr);

        for(HashMap.Entry kv: map.entrySet()){
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        map2.put(1, 1000);
        map2.put(2, 2000);

        for(HashMap.Entry kv: map2.entrySet()){
            System.out.println(kv.getKey() + ":" + kv.getValue());
        }

    }

    public static boolean evenOccurrences(int[] arr){
        HashMap<Integer, Integer> kv = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            Integer count = kv.get(arr[i]);
            int newCount = count == null ? 1 : count + 1;
            kv.put(arr[i], newCount);  // this is where the elements are counted and "documented"
        }

        // loop to see if they're divisible by 2
        for(int num: kv.values()){
            if(num % 2 != 0){
                return false;
            }
        }

        return true;

    }

    public static HashMap<Integer, Integer> countsOfNum(int[] array){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            Integer count = map.get(array[i]);
            int newCount = count == null ? 1 : count + 1;
            map.put(array[i], newCount);
        }
        return map;
    }

}
