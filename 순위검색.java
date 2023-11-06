import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class 순위검색 {

    private static void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action){
        if(index == tokens.length - 1){
            action.accept(prefix);
            return;
        }

        forEachKey(index+1, prefix + tokens[index], tokens, action);
        forEachKey(index+1, prefix + "-", tokens, action);
    }

    private static Map<String, List<Integer>> buildScoresMap(String[] info){
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for(String s : info){
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length-1]);
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for(List<Integer> list : scoresMap.values()){
            Collections.sort(list);
        }
        return scoresMap;
    }

    private static int binarySearch(int score, List<Integer>scores){
        int start = 0;
        int end = scores.size() - 1;
        while(end>start){
            int mid = (start + end) / 2;
            if(scores.get(mid) >= score){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        if(scores.get(start) < score){
            return scores.size();
        }
        return start;
    }

    private static int count(String query, Map<String,List<Integer>> scoresMap){
        String[] tokens = query.split(" (and )?");

        String key = String.join("",Arrays.copyOf(tokens, tokens.length - 1));

        if(!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);

        int score = Integer.parseInt(tokens[tokens.length-1]);

        return scores.size() - binarySearch(score, scoresMap.get(key));
    }

    private static int[] solution(String[] info, String[] query){
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        int[] answer = new int[query.length];
        for(int i=0; i<answer.length; i++){
            answer[i] = count(query[i],scoresMap);
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));
    }
}
