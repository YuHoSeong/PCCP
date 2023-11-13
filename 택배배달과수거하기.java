import java.util.*;

class Solution {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> delivery = new Stack<>();
        Stack<Integer> pickup = new Stack<>();
        for(int i=0; i<n; i++){
            delivery.push(deliveries[i]);
            pickup.push(pickups[i]);
        }
        
        while(!delivery.isEmpty() || !pickup.isEmpty()){
            
            while(!delivery.isEmpty() && delivery.peek() == 0){
                delivery.pop();
            }
            while(!pickup.isEmpty() && pickup.peek() == 0){
                pickup.pop();
            }
            
            answer += 2 * Math.max(delivery.size() , pickup.size());
            
            int delivery_target = 0;
            while(!delivery.isEmpty()){
                int delivery_current = delivery.pop();
                
                if(delivery_target + delivery_current <= cap){
                    delivery_target += delivery_current;
                }else{
                    delivery.push(delivery_target + delivery_current - cap);
                    break;
                }
            }
            
            int pickup_target = 0;
            while(!pickup.isEmpty()){
                int pickup_current = pickup.pop();
                
                if(pickup_target + pickup_current <= cap){
                    pickup_target += pickup_current;
                }else{
                    pickup.push(pickup_target + pickup_current - cap);
                    break;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups ={0, 2, 0, 1, 0, 2, 0};
        System.out.println(solution(cap, n , deliveries, pickups));
    }
}
