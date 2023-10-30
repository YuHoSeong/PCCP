import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수식최대화 {
    private static final String[][] PRECEDENCES = {
        "+-*".split(""),
        "+*-".split(""),
        "*+-".split(""),
        "*-+".split(""),
        "-+*".split(""),
        "-*+".split("")
    };

    private static long calculate(long left, long right, String op){
        return switch(op){
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> 0;
        };
    }

    private static long calculate(List<String> tokens, String[] precedence){
        for(String op : precedence){
            for(int i=0; i<tokens.size(); i++){
                if(tokens.get(i).equals(op)){
                    long left = Long.parseLong(tokens.get(i-1));
                    long right = Long.parseLong(tokens.get(i+1));
                    long result = calculate(left, right, op);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result));
                    i-=2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    private static long solution(String expression){
        StringTokenizer st = new StringTokenizer(expression, "+*-", true);
        List<String> tokens = new ArrayList<>();
        while(st.hasMoreTokens()){
            tokens.add(st.nextToken());
        }
        long max = 0;
        for(String[] precedence : PRECEDENCES){
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if(value> max){
                max = value;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }
}
