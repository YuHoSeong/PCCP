public class 문자열내림차순으로배치하기 {
    private String solution(String s){
        return s.chars()
            .boxed()
            .sorted((v1,v2)->v2-v1)
            .collect(StringBuilder::new,
                    StringBuilder::appendCodePoint,
                    StringBuilder::append)
            .toString();
    }
    public static void main(String[] args) {
        문자열내림차순으로배치하기 sol = new 문자열내림차순으로배치하기();
        String s = "Zbcdefg";
        System.out.println(sol.solution(s));
    }
}
