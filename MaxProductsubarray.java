import java.util.Scanner;

public class MaxProductsubarray {



    static int maxProductSubarray(int[] arr){
        int max =arr[0],temp;
        int min = arr[0];
        int  maxproduct = arr[0];

        for(int i =1; i<arr.length; i++){
            if(arr[i]<0){
                 temp = max;
                 max = min;
                 min= temp;
            }
            max = Math.max(arr[i], max*arr[i]);
            min = Math.min(arr[i], min*arr[i]);

            maxproduct = Math.max(max,maxproduct);
        }

        return  maxproduct;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t  = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i =0; i<n; i++)
                arr[i] = sc.nextInt();

            System.out.println(maxProductSubarray(arr));

            t--;
        }
    }
}
