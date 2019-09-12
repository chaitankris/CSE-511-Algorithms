#include<bits/stdc++.h>

using namespace std;
int FindRank(int arr[], int i, int j, int r);


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



int FindRank(int arr[], int i, int j, int r){
	int k= pivot(arr, i,j);
    swap(arr, i,k);
    int m = partition(arr,i,j);
    swap(arr,i,m);

    if(j-m+1 == r) return m;
    else if(r<j-m+1)
    	FindRank(arr, m+1, j, r);
    else
    	FindRank(arr, i, m-1, r-(j-m+1));
}


int main(void){

	int arr[]={1,2,3,56,76,23,15};
    
    cout<<arr[FindRank(arr,0,6,4)]<<endl;

 
    
}