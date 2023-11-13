import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 이모티콘할인행사 {
    static List<int[]> answer = new ArrayList<>();
    static int[] discount = {10,20,30,40};

    public static void dfs(int r, int[] discount_current, int[][] users, int[] emoticons){
        int service = 0;
        int salePrice = 0;

        if(r == emoticons.length){
            for(int[] user : users){
                int limitDiscount = user[0];
                int limitPrice = user[1];
                int price = 0;

                for(int i=0; i<emoticons.length; i++){
                    if(discount_current[i] >= limitDiscount){
                        price += emoticons[i] * (100 - discount_current[i]) * 0.01;
                    }
                    if(price >= limitPrice){
                        price = 0;
                        service++;
                        break;
                    }
                }
                salePrice += price;
            }

            answer.add(new int[] {service, salePrice});
            return;
        }

        for(int i=0;i<discount.length; i++){
            int[] discount_current_copy = Arrays.copyOf(discount_current,discount_current.length);
            discount_current_copy[r] = discount[i];
            dfs(r+1, discount_current_copy, users, emoticons);
        }
        return;
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] discount_current = new int[emoticons.length];
        dfs(0,discount_current,users,emoticons);
        Collections.sort(answer, (v1,v2) ->{
            if(v1[0] == v2[0]){
                return v2[1] - v1[1];
            }
            return v2[0] - v1[0];
        });
        return answer.get(0);
    }
    public static void main(String[] args) {
        // int[][] users ={{40,10000},{25,10000}};
        // int[] emoticons ={7000, 9000};
        int[][] users ={{40,2900},{23,10000},{11,5200},{5,5900},{40,3100},{27,9200},{32,6900}};
        int[] emoticons ={1300,1500,1600,4900};
        System.out.println(Arrays.toString(solution(users, emoticons)));
    }
}
