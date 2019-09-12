/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Maxsubarray_Sum{
    
    static int Maxsubarray(int[] a){
        int cur_max=a[0], so_far =a[0];
        for(int i=1; i<a.length ; i++){
            cur_max = Math.max(a[i], cur_max+a[i]);
            so_far = Math.max(so_far, cur_max);
        }
        
        return so_far;
    }
	public static void main (String[] args) {
	       Scanner sc =  new Scanner(System.in);
	       int t = sc.nextInt();
	       while(t>0){
	           int n = sc.nextInt();
	           int[] arr =  new int[n];
	           for(int i =0; i<n; i++){
	               arr[i]= sc.nextInt();
	           }
	           System.out.println(Maxsubarray(arr));
	           t--;
	       }
	}
}