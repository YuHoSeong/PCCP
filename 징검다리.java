import java.util.Arrays;

public class 징검다리 {
    private static boolean isValid(int d, int[] rocks, int n){
        int removed = 0;
        int last = 0;
        for(int rock : rocks){
            if(rock - last < d){
                removed++;
                continue;
            }

            last = rock;
        }
        return removed <= n;
    }
    private static int solution(int distance, int[] rocks, int n){
        rocks = Arrays.copyOf(rocks,rocks.length+1);
        rocks[rocks.length-1] = distance;
        Arrays.sort(rocks);
        
        int min = 1;
        int max = distance+1;

        while(max - min > 1){
            int d = (max + min) / 2;
            if(isValid(d,rocks,n)){
                min = d;
            }else{
                max = d;
            }

        }
        return min;
    }
    public static void main(String[] args) {
        int distance = 25;
        int[] rocks = {2,14,11,21,17};
        int n = 2;

        System.out.println(solution(distance, rocks, n));
    }
}
