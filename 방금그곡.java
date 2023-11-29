import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 방금그곡 {
    final static String[] targetReplace = {"C#", "D#", "F#", "G#", "A#"};
    final static String[] toReplace = {"c","d","f","g","a"};
    static List<Music> answer = new ArrayList<>();
    
    // 재생된 악보 구하기
    public static String getPlaySheet(int playTime, String musicSheet){
        int len = musicSheet.length();
        char[] playSheet = new char[playTime];
        for(int i=0; i<playTime; i++){
            playSheet[i] = musicSheet.charAt(i%len);
        }
        return new String(playSheet);
    }
    
    // 재생 시간 구하기
    public static int getPlayTime(String start, String end){
        int endHours = Integer.parseInt(end.split(":")[0]);
        int endMinutes = Integer.parseInt(end.split(":")[1]);
        int startHours = Integer.parseInt(start.split(":")[0]);
        int startMinutes = Integer.parseInt(start.split(":")[1]);
        return (endHours-startHours)*60 + (endMinutes - startMinutes);
    }
    
    public static void getTargetMusic(String m, String title, int playTime, String playSheet){
        int index = playSheet.indexOf(m);
        if(index != -1){
            answer.add(new Music(title,playTime));
        }
    }
    
    public static String solution(String m, String[] musicinfos) {
        for(String musicinfo : musicinfos){
            String[] infos = musicinfo.split(",");
            for(int i=0; i<5; i++){
                m = m.replace(targetReplace[i], toReplace[i]);
                infos[3] = infos[3].replace(targetReplace[i], toReplace[i]);
            }
            int playTime = getPlayTime(infos[0], infos[1]);
            String playSheet = getPlaySheet(playTime, infos[3]);
            getTargetMusic(m,infos[2],playTime,playSheet);
        }
        
        Collections.sort(answer, (m1,m2)->{
            return m2.getPlayTime() - m1.getPlayTime();
        });
        
        return answer.size() == 0 ? "(None)" : answer.get(0).getTitle();
    }
    
    static class Music{
        String title;
        int playTime;
        
        public Music(String title, int playTime){
            this.title = title;
            this.playTime = playTime;
        }
        
        public String getTitle(){
            return title;
        }
        public int getPlayTime(){
            return playTime;
        }
    }
    public static void main(String[] args) {
        String m ="ABCDEFG";
        String[] musicinfos ={"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m, musicinfos));
    }
}
