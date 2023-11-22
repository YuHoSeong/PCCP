import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {

    static int answer = 0;
    
    public static void go(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char temp = s.charAt(i);
            if(temp == '[' || temp == '{' || temp == '('){
                stack.add(temp);    
            }else{
                if(stack.isEmpty()) return;
                if(temp == ']' && stack.peek() == '['){
                    stack.pop();
                }else if(temp == '}' && stack.peek() == '{'){
                    stack.pop();
                }else if(temp == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    return;
                }
            }
        }
        if(stack.isEmpty()) answer++;
        return;
    }
    
    public static int solution(String s) {
        StringBuilder st = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            go(st.toString());
            char temp = st.charAt(0);
            st.deleteCharAt(0);
            st.append(temp);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }
}
