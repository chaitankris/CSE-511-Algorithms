import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char a){
        if(a == '^'){
            return 3;
        }
        else if(a == '*'||a=='/'){
            return 2;
        }
        else if(a=='+'|| a=='-') {
            return 1;
        }
        else return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            String str = br.readLine();
            Stack<Character> s = new Stack<>();
            String result="";
            for (int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(Character.isLetterOrDigit(c)){
                    result+=c;
                }
                else if(c=='('){
                    s.push(c);
                }
                else if(c==')'){
                    while (!s.isEmpty() && s.peek() != '('){
                        result+=s.pop();
                    }
                    if(!s.isEmpty()){
                        s.pop();
                    }
                }
                else{
                    while (!s.isEmpty() && precedence(c)<= precedence(s.peek())){
                        result+=s.pop();
                    }
                    s.push(c);
                }
            }
            while (!s.isEmpty()){
                result+=s.pop();
            }
            System.out.println(result);
        }
    }
}
