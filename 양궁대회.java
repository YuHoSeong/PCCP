import java.util.Arrays;

public class 양궁대회 {
    static int[] lion = new int[11];
    static int[] answer = {-1};
    static int ryan;
    static int apeach;
    static int max = Integer.MIN_VALUE;

    public static boolean isRyanWin(int[] info){
        ryan = 0;
        apeach = 0;
        for(int i=0; i<11; i++){
            if(info[i] == 0 && lion[i] == 0) continue;
            if(info[i] < lion[i]){
                ryan += 10 - i;
            }else{
                apeach += 10 - i;
            }
        }
        if(ryan > apeach) return true;
        return false;
    }

    public static void game(int shot, int n, int[] info){
        if(shot == n+1){
            if(isRyanWin(info)){
                if(max <= ryan - apeach){
                    max = ryan - apeach;
                    answer = lion.clone();
                }
            }
            return;
        }

        for(int i=0; i<11; i++){
            if(lion[i] > info[i]) return;
            lion[i] += 1;
            game(shot+1, n, info);
            lion[i] -= 1;
        }
    }

    public static int[] solution(int n, int[] info){
        game(1,n,info);
        return answer;

    }
    public static void main(String[] args) {
        int n = 3;
        int[] info = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.toString(solution(n, info)));
    }
}
