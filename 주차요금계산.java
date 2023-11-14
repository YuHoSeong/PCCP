import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class 주차요금계산 {

    static List<String> list = new ArrayList<>();
    static int[] answer;

    public static int getMinute(String time){
        String[] times = time.split(":");
        int hour = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return (hour * 60) + minute;

        
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String,String> map = new HashMap<>();
        Map<String,Integer> answer = new TreeMap<>((v1,v2)->{
            return Integer.parseInt(v1) - Integer.parseInt(v2);
        });
        
        for(String r : records){
            String[] record = r.split(" ");
            String time = record[0];
            String carNumber = record[1];
            String state = record[2];
            
            if(state.equals("IN")){
                map.put(carNumber, time);
                continue;
            }
            
            int start = getMinute(map.get(carNumber));
            int end = getMinute(time);
            
            int parking = end-start;
            
            answer.put(carNumber, answer.getOrDefault(carNumber,0) + parking);
            map.remove(carNumber);
            
        }
        
        if(!map.isEmpty()){
            for(String key : map.keySet()){
                int start = getMinute(map.get(key));
                int end = getMinute("23:59");
                int parking = end-start;
                
                answer.put(key, answer.getOrDefault(key,0)+parking);
            }
        }
        
        int standardTime = fees[0];
        int standardPrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];
        List<Integer> result = new ArrayList<>();        
        
        for(String key : answer.keySet()){
            int parking = answer.get(key);
            if(parking <= standardTime) {
                result.add(standardPrice);
                continue;
            }
            double plusTime = (parking-standardTime)/(double)unitTime;
            int plusPrice = ((int)Math.ceil(plusTime)*unitPrice);
            int price =standardPrice + plusPrice;
            result.add(price);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
