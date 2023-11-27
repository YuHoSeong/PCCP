import java.util.*;
public class 괄호변환 {

    public static boolean isCorrect(String p){
        if(p=="") return true;
        Stack<Character> stack = new Stack<>();
        char[] charArr = p.toCharArray();
        for(int i =0; i<charArr.length; i++){
            if(charArr[i] == '('){
                stack.add(charArr[i]);
            }else{
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty() ? true : false;
    }
    
    public static String[] separation(String s){
        int open = 0, close = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                open++;   
            }else{
                close++;
            }
            if(open == close){
                return new String[]{s.substring(0,i+1), s.substring(i+1)};
            }
        }
        return new String[]{s, ""};
    }
    
    public static String trans(String s){
        String temp = s.substring(1,s.length()-1);
        char[] charArr = temp.toCharArray();
        for(int i=0; i<charArr.length; i++){
            charArr[i] = (charArr[i] == ')') ? '(' : ')';
        }
        String r = new String(charArr);
        return r;
    }
    
    public static String main(String s){
        if(isCorrect(s)){
            return s;
        }
        
        String[] temp = separation(s);
        
        String u = temp[0];
        String v = temp[1];
        
        if(isCorrect(u)){
            return u+main(v);
        }else{
            return "("+main(v)+")" + trans(u);
        }
        
    }
    
    public static String solution(String p) {
        return main(p);
    }

    public static void main(String[] args) {
        String p ="(()())()";
        System.out.println(solution(p));
    }
}
