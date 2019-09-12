#include<iostream>
using namespace std;
int main()
 {
	int t;
	cin>>t;
	while(t--){
	    int n,s,i,j,k,max=-2147483648;
	    cin>>n;
	    int arr[n];
	    for(int i=0; i<n;i++){
	        cin>>arr[i];
	    }
	    

	    for(i=0; i<n;i++){
	        for( j = i; j<n; j++){
	           s=0;
	           for(k=i; k<=j ;k=k+1){
	             	s+=arr[k];
	             	
	             
	         }
	         if(s>max)
	                   max= s;
	          
	     }
	     }
	    cout<<max<<endl;
	 
	}
	return 0;
}