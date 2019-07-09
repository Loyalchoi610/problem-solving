package mathematical_problem.number_notation_game;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.solution(16,16,2,1));
    }
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        char [] seq = new char[m*t];
        int num=0;
        int index=0;
        while(index < m*t){
            String digits="";
            int start =num;
            while(start > 0){
                int r = start%n;
                if(r < 10){
                    digits += (char)(r + '0');
                } else{
                    digits += (char)(r - 10 + 'A');
                }
                start /=n;
            }
            if(num==0){
                seq[index++] = '0';
            }else{
                digits = new StringBuilder(digits).reverse().toString();
                for(int i=0; i<digits.length(); i++){
                    if(index == m*t) break;
                    seq[index++] = digits.charAt(i);
                }
            }
            num++;
        }
        int i=p-1;
        while(i < seq.length){
            answer += seq[i];
            i += m;
        }
        return answer;
    }
}
