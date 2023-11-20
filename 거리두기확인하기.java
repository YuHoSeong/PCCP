import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 거리두기확인하기 {
    static List<Integer> answer = new ArrayList<>();
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1}; // 상하좌우
    
    private static boolean check(int r, int c, String[] place){
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            if(nr < 0 || nr > 4 || nc < 0 || nc > 4) continue;
            if(visited[nr][nc]) continue;
            if(place[nr].charAt(nc) == 'X') continue;
            if(place[nr].charAt(nc) == 'P') return false;
            
            visited[nr][nc] = true;
            for(int j=0; j<4; j++){
                int nnr = nr + dr[j];
                int nnc = nc + dc[j];
                
                if(nnr < 0 || nnr > 4 || nnc < 0 || nnc > 4) continue;
                if(visited[nnr][nnc]) continue;
                
                if(place[nnr].charAt(nnc) == 'P') return false;
            }
        }
        return true;
    }
    
    private static int go(String[] place){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(place[i].charAt(j) == 'P'){
                    if(!check(i,j,place)) return 0;
                }
            }
        }
        return 1;
    }
    
    public static int[] solution(String[][] places) {
        
        for(String[] p : places){
            answer.add(go(p));
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    public static void main(String[] args) {
        String[][] palces ={{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(palces)));
    }
}
