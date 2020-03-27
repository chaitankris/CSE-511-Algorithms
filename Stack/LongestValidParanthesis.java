import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LongestValidParanthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            Stack<Integer> s= new Stack<>();
            String str = br.readLine();
            int max=0;
            s.push(-1);
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '(' ){
                    s.push(i);
                }else{
                    s.pop();
                    if(s.isEmpty()){
                        s.push(i);
                    }
                    else {
                        max = Math.max(max,i-s.peek());
                    }
                }
            }
            System.out.println(max);

        }
    }
}
