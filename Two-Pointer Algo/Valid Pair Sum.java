//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ;i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array,n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long ValidPair(int a[], int n) 
	{ 
	    // Your code goes here
	    Arrays.sort(a);
	    int i = 0, j = n-1;
	    long ans = 0;
	    while(i!=j)
	    {
	        if(a[i]+a[j]>0)
	        {
	            ans+= j-i;
	            j--;
	        }
	        else
	        {
	            i++;
	        }
	    }
	   return ans;
	}
} 
