#include<bits/stdc++.h>

using namespace std;

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


int pivot(int arr[], int i, int j){
  return i+(rand()%(j-i+1));
    
}


int FindMedian(int arr[], int i, int j, int r){
	int k= pivot(arr, i,j);
    swap(arr, i,k);
    int m = partition(arr,i,j);
    swap(arr,i,m);

    if(j-m+1 == r) return m;
    else if(r<j-m+1)
    	FindMedian(arr, m+1, j, r);
    else
    	FindMedian(arr, i, m-1, r-(j-m+1));
}


int main(void){

	int arr[]={1,2,3,56,76,23};
    
    cout<<arr[FindMedian(arr,0,5,3)]<<endl;
}