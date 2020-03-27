import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MaxRectangularArea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            long[] arr = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();
            Stack<Integer> s = new Stack<>();
            long max=0,cur=0,top;
            int i;
            for(i=0;i<n;){
                if(s.isEmpty() || arr[s.peek()]<=arr[i]){
                    s.push(i++);
                }
                else {

                        top = s.pop();
                        if(s.isEmpty()){
                            cur = arr[(int) top]*i;
                        }
                        else {
                            cur=  arr[(int) top]*(i-s.peek()-1);
                        }
                        if(cur>max) max =cur;
                }
            }

            while (!s.isEmpty()){
                top = s.pop();
                if(s.isEmpty()){
                    cur = arr[(int) top]*i;
                }
                else {
                    cur=  arr[(int) top]*(i-s.peek()-1);
                }
                if(cur>max) max =cur;
            }
            System.out.println(max);
        }
    }
}
