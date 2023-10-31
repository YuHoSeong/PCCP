import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {
    private static int[] solution(int[] numbers){
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i< numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        return set.stream().mapToInt(Integer::intValue).toArray();
    }
    public static void main(String[] args) {
        int[] numbers ={2,1,3,4,1};
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
