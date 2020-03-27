import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            Stack<Integer> s= new Stack<>();
            String str = br.readLine();
            int count = 0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == '(' ){
                    count++;
                    s.push(count);
                    System.out.print(count+" ");

                }
                else if(str.charAt(i) == ')' ){
                    System.out.print(s.pop()+" ");
                    }
                }
            System.out.println();

        }
    }
}
