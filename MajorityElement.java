import  java.util.Scanner;

public class MarojrityElement {

    int findmajor(int[] arr) {
        int maj_index = 0, count = 1;
        int i;
        for (i = 1; i < arr.length; i++)
        {
            if (arr[maj_index] == arr[i])
                count++;
            else
                count--;
            if (count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return arr[maj_index];
    }
    void printMajority(int arr[]){
        int x = findmajor(arr);
        boolean ans = isMajority(arr,arr.length,x);
        if (ans)
            System.out.println(x);
        else
            System.out.println("-1");
    }

     boolean isMajority(int arr[],int size, int cand){
         int i, count = 0;
         for (i = 0; i < size; i++)
         {
             if (arr[i] == cand)
                 count++;
         }
         return count > size / 2;
     }


    public static void main(String[] args) {

        MarojrityElement me = new MarojrityElement();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t>0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            me.printMajority(arr);

            t--;
        }
    }

}
