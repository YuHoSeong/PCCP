import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 행렬테두리회전하기 {

    static int[] dr = {0,1,0,-1} , dc = {1,0,-1,0}; // 오른, 아래, 왼, 위
    static int[][] map;
    static Queue<Integer> q;
    static List<Integer> result;
    
    private static void goLotation(int[] query){
        // 최소값
        int min = Integer.MAX_VALUE;
        // 처음 좌표의 값 저장
        int value = map[query[0]][query[1]];
        min = Math.min(min, value);
        q.offer(value);
        // 방향
        int d = 0;
        // 좌표 이동
        int cur_r = query[0] + dr[d];
        int cur_c = query[1] + dc[d];
        
        while(true){
            if(cur_r == query[0] && cur_c == query[1]){
                map[cur_r][cur_c] = q.poll();
                result.add(min);
                return;
            }
            value = map[cur_r][cur_c];
            if(min > value){
                min = Math.min(min, value);    
            }
            q.offer(value);
            map[cur_r][cur_c] = q.poll();
            if(cur_r == query[0] && cur_c == query[3]){
                d++;
            }
            if(cur_r == query[2] && cur_c == query[3]){
                d++;
            }
            if(cur_r == query[2] && cur_c == query[1]){
                d++;   
            }
            cur_r = cur_r + dr[d];
            cur_c = cur_c + dc[d];
        }
    }
        
    public static int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows+1][columns+1];
        q = new LinkedList<>();
        result = new ArrayList<>();
        int count = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = count++;
            }
        }
        
        for(int[] query : queries){
            goLotation(query);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries ={{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }
}
