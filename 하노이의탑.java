import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {
    private static void hanoi(int n, int from, int to, List<int[]> process){
        if(n ==1){
            process.add(new int[] {from, to});
            return;
        }
        int empty = 6 - from - to;
        hanoi(n-1, from, empty, process);
        hanoi(1,from,to,process);
        hanoi(n-1, empty, to, process);
    }
    public static int[][] solution(int n){
        List<int[]> process = new ArrayList<>();
        hanoi(n,1,3,process);
        return process.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(3)));
        List<int[]> process = new ArrayList<>();
        process.toArray();
    }
}
