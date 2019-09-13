import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main (String[] args)
    {
        Scanner sc  = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0; i<n; i++)
                arr[i] = sc.nextInt();
            int[] q = new int[n];
            Stack<Integer> s = new Stack<Integer>();
            for (int i = n-1; i>=0;i--){
                while(!s.empty() && s.peek()<= arr[i]){
                    s.pop();
                }

                if(s.empty()){
                    q[i] =-1;
                }else{
                    q[i] = s.peek();
                }

                s.push(arr[i]);
            }
           for(int i=0; i<n; i++)
            System.out.print(q[i]+" ");
           System.out.println();
            t--;
        }
    }
}

