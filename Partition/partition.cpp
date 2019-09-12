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
	    while(arr[r] > arr[i] &&  l<=r)
		  r--;
		if(l<r){
			swap(arr,l,r);
			l++;
			r--;
		}
    }

    return l-1;
}


int main(){
	int arr[] = {7,8,1,3,10,12,15};
	int x = partition(arr,0,6);
    swap(arr,0,x);

	for (int i = 0; i < 7; ++i)
	{   
		cout<<arr[i]<<" ";
		
	}
}