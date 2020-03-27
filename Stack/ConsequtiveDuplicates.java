import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ConsequtiveDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String str = br.readLine();
            Stack<Character> s = new Stack<Character>();
            StringBuilder ans = new StringBuilder();
            ans.append(str.charAt(0));
            s.push(str.charAt(0));
            for(int i=1; i<str.length(); i++){
                if (str.charAt(i) !=  s.peek()){
                    s.pop();
                    s.push(str.charAt(i));
                    ans.append(str.charAt(i));
                }
            }
            System.out.println(ans);
         t--;
        }
    }
}
