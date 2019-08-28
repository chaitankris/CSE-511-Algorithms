import java.util.Scanner;


class TrappingWater{


	public static void main(String[] args) {
	     int arr[] = new int[4];
	     Scanner sc = new Scanner(System.in);
	     for (int i =0; i<4;i++ ) {
	     		arr[i] = sc.nextInt();
	     	}	

	    int left = arr[0];
        int nextmax,sum =0;;
        
        for (int i=1;i<4 ;i++ ) {
            if(left>arr[i]){
            	sum = sum+(left - arr[i]);
            }        	
            else{
            	left = arr[i];
            }
        }

        System.out.println(" the amount of TrappingWater is : "+ sum);
	}
}