public class 네트워크 {

    static int n = 3;
    static int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
    static boolean[] visited = new boolean[n];

    public static void countNetwork(int networkNumber){
        visited[networkNumber] = true;
        for(int i=0; i<n; i++){
            if(computers[networkNumber][i] == 1 && visited[i] == false)
                countNetwork(i);
        }
    }
    public static void main(String[] args) {
        int answer = 0;
        for(int i=0; i<n; i++){
            if(visited[i] == false){
                countNetwork(i);
                answer++;
            }
        }
        
        System.out.println(answer);
    }
}
