import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedPranthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            Stack<Character> s= new Stack<>();
            String str = br.readLine();
            int flag =0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                    s.push(str.charAt(i));
                }
                else if(str.charAt(i) == '}' || str.charAt(i) == ')' || str.charAt(i) == ']'){
                    if (!s.isEmpty() && (s.peek()== '(' && str.charAt(i) == ')'||s.peek()== '[' && str.charAt(i) == ']' || s.peek()== '{' && str.charAt(i) == '}')) {
                        s.pop();
                    }else {
                        flag=1;

                    }
                }
            }
            if(s.isEmpty() && flag == 0){
                System.out.println("balanced");
            }else {
                System.out.println("not balanced");
            }


        }
    }
}
