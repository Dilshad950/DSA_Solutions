//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().countZeroes(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int search(int[] arr , int l , int r)
    {
        while(l<=r)
        {
            int mid = (l+r)/2;
            if(arr[mid]==1)
            {
                l = mid+1;
            }
            else
            {
                r = mid-1;
            }
        }
        return r +1 ;
    }
    int countZeroes(int[] arr, int n) {
        // code here
        return n - search(arr,0,n-1);
    }

}
