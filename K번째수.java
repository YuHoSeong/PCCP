import java.util.*;

public class K번째수 {
    private static int getNumber(int[] array, int[] command){
        int beginIndex = command[0];
        int endIndex = command[1];
        int[] newArray = Arrays.copyOfRange(array, beginIndex-1, endIndex);
        // int[] newArray = new int[endIndex-beginIndex+1];
        // for(int i=0; i<endIndex-beginIndex+1; i++){
        //     newArray[i] = array[beginIndex-1+i];
        // }
        Arrays.sort(newArray);
        return newArray[command[2]-1];
    }
    private static int[] getNumbers(int[] array, int[][] commands){
        int[] result = new int[commands.length];
        // 커맨드 순회
        for(int i=0; i<commands.length; i++){
            result[i] = getNumber(array.clone(), commands[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(Arrays.toString(getNumbers(array, commands)));
    }
}
