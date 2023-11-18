import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 미로탈출명령어 {
    
    static int N,M,X,Y,R,C,K;
    static int[] dr = {1,0,0,-1} , dc = {0,-1,1,0}; // 하좌우상
    static char[] d = {'d','l','r','u'};
    static String answer;
    static StringBuilder sb = new StringBuilder();
    
    private static void dfs(int n, int m, int r1, int c1, int r2, int c2, int k){
        if(answer != null) return;
        
        if(distance(r1, c1, r2, c2) + sb.length() > k) return;

        if(sb.length() == k){
            if(distance(r1, c1, r2, c2) == 0){
                answer = sb.toString();
            }
            return; 
        }

        for(int i=0; i<4; i++){
            int nr = r1 + dr[i];
            int nc = c1 + dc[i];
            if(nr<1 || nr>n || nc<1 || nc>m) continue;
            sb.append(d[i]);
            dfs(n,m,nr,nc,r2,c2,k);
            sb.delete(sb.length()-1, sb.length());

        }
        

    }

    private static int distance(int r1, int c1, int r2, int c2){
        return Math.abs(r2-r1) + Math.abs(c2-c1);
    }
    
    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        if(distance(x,y,r,c) > k || distance(x,y,r,c) - k % 2 == 1) return "impossible";

        dfs(n, m, x, y, r, c, k);
        
        return answer != null ? answer : "impossible";
    }

    public static void main(String[] args) {
        int n=3, m=4, x=2, y=3, r=3,c=1,k=5;
        System.out.println(solution(n, m, x, y, r, c, k));
    }
}
