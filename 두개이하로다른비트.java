import java.util.Arrays;

public class 두개이하로다른비트 {

    public static long go(long number){
        String binary = Long.toString(number,2);
        String temp;
        
        if(!binary.contains("0")){
            temp = binary.substring(0, 1)+"0"+binary.substring(1, binary.length());
            return Long.parseLong(temp,2);
        }
        
        int zeroIndex = binary.lastIndexOf('0');
        
        if(zeroIndex == binary.length()-1){
            temp = binary.substring(0,zeroIndex)+"1";
            return Long.parseLong(temp,2);
                
        }
        temp = binary.substring(0,zeroIndex)+"10"+binary.substring(zeroIndex+2,binary.length());
        return Long.parseLong(temp,2);
    }
    
    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            answer[i] = go(numbers[i]);
        }
        
        return answer;
    }
    public static void main(String[] args) {
        long[] numbers = {2,7};
        System.out.println(Arrays.toString(solution(numbers)));
    }
}
