import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ConsequtiveDuplicates2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            s.push('$');
            for (int i =0; i<str.length();i++){
                if(s.peek() == str.charAt(i)){
                    s.pop();
                }else {
                    s.push(str.charAt(i));
                }

            }
            if(s.size() == 1){
                System.out.println(s.pop());
            }
            else{
               StringBuilder ans = new StringBuilder();
               while (s.peek()!= '$'){
                   ans.append(s.pop());
               }
                System.out.println(ans.reverse());
            }
        }
    }
}
