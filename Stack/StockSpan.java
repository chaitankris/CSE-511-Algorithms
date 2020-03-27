import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while (t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            Stack<Integer> s = new Stack<>();
            int[] span =new int[n];
            for (int i=0;i<n; i++){
                 while (!s.isEmpty() && arr[s.peek()]<=arr[i]){
                        s.pop();
                 }
                 span[i] = s.isEmpty()? (i+1) :i-s.peek();

                s.push(i);
            }
            for (int i=0; i<n; i++){
                System.out.print(span[i]+" ");
            }
            System.out.println();
        }
    }
}
