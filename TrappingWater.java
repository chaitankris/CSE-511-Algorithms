import java.util.Scanner;


class TrappingWater{


	public static void main(String[] args) {
	     int arr[] = new int[4];
	     Scanner sc = new Scanner(System.in);
	     for (int i =0; i<5;i++ ) {
	     		arr[i] = sc.nextInt();
	     	}	

        int leftmax=0, rightmax=0, sum =0;
        int i = 0,j= n-1;
        while(i<=j){
        	if(arr[i]<arr[j]){
        		if(arr[i]>leftmax)
        			leftmax = arr[i];
        		else{
                  sum = sum+ leftmax - arr[i];
                  i++;
        		}
        	}
        	else{
        		if(arr[j]>rightmax){
        			rightmax = arr[j];
        		}
        		else{
        			sum = sum + rightmax- arr[j];
        			j--;
        		}
        	}
        }

        System.out.println(" the amount of TrappingWater is : "+ sum);
	}
}
