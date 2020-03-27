import com.sun.corba.se.impl.orb.PropertyOnlyDataCollector;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CircularTour {
    static int tour(int petrol[], int distance[])
    {
        int sum=0,deficit=0,start =0;
        for(int i=0; i<petrol.length; i++){
            sum +=  petrol[i]-distance[i];
            if(sum<0){
                start =i+1;
                deficit+=sum;
                sum =0;
            }

        }
        return (sum+deficit)<0? -1:start;

    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while (t-->0){
            int n= sc.nextInt();
            int[] d = new int[n];
            int[] p =new int[n];
            for (int i =0 ; i<n; i++){
                p[i]= sc.nextInt();
                d[i] =sc.nextInt();
            }
            System.out.println(tour(p,d));

        }
    }
}
