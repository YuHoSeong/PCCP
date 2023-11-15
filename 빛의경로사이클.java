import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 빛의경로사이클 {
    static int R, C;
    static int[] dr = {-1,0,1,0}, dc = {0,-1,0,1}; //아래, 왼, 위, 오른
    static boolean[][][] visited;
    
    private static int light(String[] grid, int r, int c, int d){
        int cnt =0;
        
        while(true){
            if(visited[r][c][d]) break;
            cnt++;
            visited[r][c][d] = true;
            
            if(grid[r].charAt(c) == 'L'){
                d = d == 0 ? 3 : d - 1;
            }else if(grid[r].charAt(c) == 'R'){
                d = d == 3 ? 0 : d + 1;
            }
            
            r = (r + dr[d] + R) % R;
            c = (c + dc[d] + C) % C;
        }
        
        return cnt;
    }
    
    public static int[] solution(String[] grid) {
        List<Integer> answer = new ArrayList<Integer>();
        
        R = grid.length;
        C = grid[0].length();
        
        visited = new boolean[R][C][4];
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                for(int d=0; d<4; d++){
                    if(!visited[i][j][d])
                        answer.add(light(grid,i,j,d));
                }
            }
        }
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
        
        
    }
    public static void main(String[] args) {
        String[] grid = {"R","R"};
        System.out.println(Arrays.toString(solution(grid)));
    }
}
