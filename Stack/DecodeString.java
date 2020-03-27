import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0){
            String str = br.readLine().trim();
            Stack<String> result = new Stack<>();
            Stack<Integer> count =new Stack<>();
            int i=0,num=0;
            String res="";
            while (i<str.length()){
                if(Character.isDigit(str.charAt(i))){
                    while (Character.isDigit(str.charAt(i))){
                        num= num*10+(str.charAt(i)-'0');
                        i++;
                    }
                    count.push(num);
                    num=0;
                }
                else if(str.charAt(i)=='['){
                     result.push(res);
                     res ="";
                     i++;
                }
                else if(str.charAt(i)==']'){
                      StringBuilder b = new StringBuilder(result.pop());
                      int n =count.pop();
                      for (int j=0; j<n; j++){
                          b.append(res);
                      }
                      res =b.toString();
                      i++;
                }
                else {
                    res+=str.charAt(i);
                    i++;
                }
            }
            System.out.println(res);
        }
    }
}
