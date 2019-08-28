#include<bits/stdc++.h>
using namespace std;


// Rank(x) =  1+ number of elements greater than x
int Rank(int arr[],int x , int n){
	int count =0;
	for(int i =0; i<n; i++)
		if(arr[i]>arr[x])
			count = count+1;
	return (count+1);
}
int main(int argc, char const *argv[])
{   int n;
	cin>>n;
	int arr[n];
	for(int i=0; i<n; i++){
		cin>>arr[i];
	}

	cout<<Rank(arr, 3,n)<<endl;
	
	return 0;
}