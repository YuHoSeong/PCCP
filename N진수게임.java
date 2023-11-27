public class N진수게임{
    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        String str = "";
        int start=0;
        while(str.length()/m < t){
            str+=Integer.toString(start++,n);
        }
        for(int i=0; i<str.length();i++){
            if(i%m == p-1)
                answer += str.charAt(i);
            if(answer.length() == t) break;
        }
        return answer.toUpperCase();
    }
    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(solution(n, t, m, p));
    }
}