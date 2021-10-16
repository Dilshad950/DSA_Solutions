//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    int search(int []arr,int l , int r)
    {
        if(l==r)
        {
            return arr[l];
        }
        if(r==l+1 && arr[l]>=arr[r])
        {
            return arr[l];
        }
        if(r==l+1 && arr[l]<arr[r])
        {
            return arr[r];
        }
        
        int mid = (l+r)/2;
           
        if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
        {
           return arr[mid];
        }
        if (arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1])
        {
            return search(arr,mid+1,r);
        }
        else
        {
            return search(arr,l,mid-1);
        }
            
    }
    
    int findMaximum(int[] arr, int n) {
        // code here
        return search(arr,0,n-1);
    }
}