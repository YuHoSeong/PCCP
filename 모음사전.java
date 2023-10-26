import java.util.ArrayList;
import java.util.List;

public class 모음사전 {
    private static final char[] CHARS = "AEIOU".toCharArray();
    private static void generate(String word, List<String> words ){
        words.add(word);
        if(word.length() == 5) return;

        for(char c : CHARS){
            generate(word + c, words);
        }
    }
    public static int solution(String word){
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(solution(word));
    }
}