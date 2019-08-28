#include<stdio.h>

void Merge(int arr[], int l, int m, int r){
	int i,j,k;
	int n1 = m-l+1;
	int n2 = r-m;
 // constructing  the sub arrays
   int L[n1], R[n2];

   for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
   
 // merging the array
   i =0;
   j =0;
   k =l;
   while(i<n1 && j<n2){
   	if(L[i]<=R[j]){
   		arr[k] = L[i];
   		i++;
   	}
   	else{
   		arr[k]= R[j];
   		j++;
   	}

   	k++;
   }
   
   // if the right sub array is completed first copying the reamaing left sub-array elements
   while(i<n1){
   	arr[k] =L[i];
   	i++;
   	k++;
   }
  // similarly copying right sub-array
   while(j<n2){
   	arr[k] =R[j];
   	j++;
   	k++;
   }

}


void MergeSort(int arr[], int i , int j){
	if(i ==j)
		return ;
        
	if(i<j){
              
		int k =(i+j-1)/2;
		MergeSort(arr, i,k);
		MergeSort(arr,k+1, j);
		Merge(arr, i,k,j);
	}
	
}



void printSortedArray(int arr[],int n){
	for (int i = 0; i < n; ++i)
	{
		/* code */
		printf("%d  ",arr[i] );
	}
        printf("\n");
}
int main(void){
	int n,i;
	scanf("%d", &n);
	int arr[n];
	for(i =0 ; i<n; i++){
		scanf("%d",&arr[i]);
	}
    MergeSort(arr,0, n);
    printSortedArray(arr,n);

}
