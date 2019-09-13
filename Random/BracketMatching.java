import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t>0) {
            Stack<String> st = new Stack<String>();
            String s = sc.nextLine();
            String ans= "NO";
            for (int i =0; i<s.length(); i++) {
                String str = "" + s.charAt(i);
                if(str.equals("(") || str.equals("{") || str.equals("[")){
                   st.push(str);
                }
                if(str.equals(")") || str.equals("]") || str.equals("}")){
                   if(st.isEmpty()){
                       break;

                   }
                   String top = st.peek();
                   if(str.equals(")") && top.equals("(")){
                       st.pop();
                    }else if(str.equals("]") && top.equals("[")){
                        st.pop();
                    }
                    else if(str.equals("}") && top.equals("{")){
                        st.pop();
                    }
                    else{
                        break;
                    }

                }

            }

            if(s.length()>0 && st.isEmpty())
                ans ="YES";
            System.out.println(ans);

            t--;
        }
    }
}

