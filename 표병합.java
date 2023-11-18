import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 표병합{

    static String[][] map;
    static int[][] merged;
    
    public static String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>(); // 출력값 저장
        map = new String[51][51]; // 표 초기화
        merged = new int[51][51]; // merge확인
        int mergeNumber = 1;

        for(String str : commands){
            String[] strArr = str.split(" ");
            String command = strArr[0];
            switch(command){
                case "UPDATE" :
                    if(strArr.length == 4){
                        int r = Integer.parseInt(strArr[1]);
                        int c = Integer.parseInt(strArr[2]);
                        String value = strArr[3];
                        map[r][c] = value;
                        int curMergeNumber = merged[r][c];
                        if(curMergeNumber == 0) break;
                        for(int i=1; i<=50; i++){
                            for(int j=1; j<=50; j++){
                                if(merged[i][j] == curMergeNumber){
                                    map[i][j] = value;
                                }
                            }
                        }
                    }else{
                        String v1 = strArr[1];
                        String v2 = strArr[2];
                        for(int i=1; i<=50; i++){
                            for(int j=1; j<=50; j++){
                                if(map[i][j] == null) continue;
                                if(map[i][j].equals(v1)){
                                    map[i][j] = v2;
                                }
                            }
                        }
                    }
                    break;
                case "MERGE" :
                    int r1 = Integer.parseInt(strArr[1]);
                    int c1 = Integer.parseInt(strArr[2]);
                    int r2 = Integer.parseInt(strArr[3]);
                    int c2 = Integer.parseInt(strArr[4]);
                    if(merged[r1][c1] == 0 && merged[r2][c2] == 0){
                        merged[r1][c1] = mergeNumber;
                        merged[r2][c2] = mergeNumber++;
                        if(map[r1][c1] == null){
                            map[r1][c1] = map[r2][c2];
                            break;
                        }
                        map[r2][c2] = map[r1][c1];
                        break;
                    }
                    if(merged[r1][c1] == 0 && merged[r2][c2] != 0){
                        int curMergeNumber = merged[r2][c2];
                        merged[r1][c1] = curMergeNumber;
                        String inputValue = map[r1][c1];
                        if(map[r1][c1] == null){
                            inputValue = map[r2][c2];
                        }
                        
                        for(int i=1; i<=50; i++){
                            for(int j=1; j<=50; j++){
                                if(merged[i][j] == curMergeNumber){
                                    map[i][j] = inputValue;
                                }
                            }
                        }
                        break;
                    }
                    if(merged[r1][c1] != 0 && merged[r2][c2] == 0){
                        int curMergeNumber = merged[r1][c1];
                        merged[r2][c2] = curMergeNumber;
                        String inputValue = map[r1][c1];
                        if(map[r1][c1] == null){
                            inputValue = map[r2][c2];
                        }
                        for(int i=1; i<=50; i++){
                            for(int j=1; j<=50; j++){
                                if(merged[i][j] == curMergeNumber){
                                    map[i][j] = inputValue;
                                }
                                
                            }
                        }
                        break;
                    }
                    if(merged[r1][c1] != 0 && merged[r2][c2] != 0){
                        int curMergeNumber = merged[r2][c2];
                        int nextMergeNumber = merged[r1][c1];
                        String inputValue = map[r1][c1];
                        if(map[r1][c1] == null){
                            inputValue = map[r2][c2];
                        }
                        for(int i=1; i<=50; i++){
                            for(int j=1; j<=50; j++){
                                if(merged[i][j] == curMergeNumber){
                                    merged[i][j] = nextMergeNumber;
                                }
                                
                            }
                        }
                        for(int i=1; i<=50; i++){
                            for(int j=1; j<=50; j++){
                                if(merged[i][j] == nextMergeNumber){
                                    map[i][j] = inputValue;
                                }
                                
                            }
                        }
                        break;
                    }
                    break;
                case "UNMERGE" :
                    int r = Integer.parseInt(strArr[1]);
                    int c = Integer.parseInt(strArr[2]);
                    int curMergeNumber = merged[r][c];
                    if(curMergeNumber == 0) break;
                    String curValue = map[r][c];
                    for(int i=1; i<=50; i++){
                        for(int j=1; j<=50; j++){
                            if(merged[i][j] == curMergeNumber){
                                merged[i][j] = 0;
                                map[i][j] = null;
                            }
                        }
                    }
                    map[r][c] = curValue;
                    break;
                case "PRINT" :
                    r = Integer.parseInt(strArr[1]);
                    c = Integer.parseInt(strArr[2]);
                    String value = map[r][c] == null ? "EMPTY" : map[r][c];
                    answer.add(value);
                    break;
            }
        }
        return answer.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] commands = {"PRINT 1 1"};
        // {"UPDATE 1 1 1", 
        // "MERGE 1 1 1 2", 
        // "MERGE 1 2 1 3", 
        // "UPDATE 1 1 2", 
        // "MERGE 1 2 1 3", 
        // "UNMERGE 1 3",  
        // "PRINT 1 1", "PRINT 1 2", "PRINT 1 3", "PRINT 1 4"};
        System.out.println(Arrays.toString(solution(commands)));
    }
}