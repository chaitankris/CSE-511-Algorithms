#include<stdio.h>
#include<iostream>

using namespace std ;

void swap(int arr[],int x, int y) 
{ 
    int temp = arr[x]; 
    arr[x] = arr[y]; 
    arr[y] = temp; 
} 


int partition(int arr[], int i, int j){
	int l=i; 
	int r=j;
    while(l<=r){ 

	    while(arr[l] <= arr[i] && l<=r)
		  l++;
	    while(arr[r] >= arr[i] &&  l<=r)
		  r--;
		if(l<r){
			swap(arr,l,r);
			l++;
			r--;
		}
    }

    return l-1;
}


int  pivot(int arr[], int i, int j){
	return i;
}

void quicksort(int arr[], int i,int j){
	if(i>j)
		return;
	
	   int p,k;
       p =  pivot(arr, i,j);
       swap(arr,i,p);
       k= partition(arr, i, j);
       swap(arr,i,k);
       quicksort(arr, i, k-1);
       quicksort(arr,k+1,j);
 

}

void printArray(int arr[], int n){
	int  i;
	for( i=0; i<n; i++)
		cout<<arr[i]<<" ";
	cout<<endl;
}



int main(void){
	int n,i;
	cin>>n;
	int arr[n];
	for(i=0; i<n; i++){
		cin>>arr[i];
	}
	quicksort(arr,0,n-1);
	printArray(arr, n);
}
	
