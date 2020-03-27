import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            String str = br.readLine();
            int x,a,b,c;
            Stack<Integer> s = new Stack<>();
            for (int i=0; i<str.length(); i++){
                if(str.charAt(i) == '*'|| str.charAt(i) == '-'||str.charAt(i) == '+'||str.charAt(i) == '/'){
                    if(str.charAt(i)=='+'){
                       a= s.pop();
                       b=s.pop();
                       c= b+a;
                       s.push(c);
                    }
                    else if(str.charAt(i)=='-'){
                        a= s.pop();
                        b=s.pop();
                        c= b-a;
                        s.push(c);
                    }
                    else if(str.charAt(i)=='/'){
                        a= s.pop();
                        b=s.pop();
                        c= b/a;
                        s.push(c);
                    }
                    else if(str.charAt(i)=='*'){
                        a= s.pop();
                        b=s.pop();
                        c= b*a;
                        s.push(c);
                    }
                }
                else{
                  x = Integer.parseInt(String.valueOf(str.charAt(i)));
                  s.push(x);
                }
            }
            System.out.println(s.pop());
        }
    }
}
