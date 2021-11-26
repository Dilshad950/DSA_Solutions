//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);
            
            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int A[],int N){
        // code here
        
        if(N==1)
        {
            return N;
        }

        
        int [] temp = new int[N];
        int count = 0;
    
        for(int i = 0 ;i<N-1 ; i++)
        {
            while(i<N-1 && A[i]== A[i+1])
            {
                i++;
            }
            temp[count] = A[i];
            count++;
        }
        if(temp[count-1] != A[N-1])
        {
            temp[count] = A[N-1];
            count++;
        }
        
        for(int i= 0 ; i<count ; i++)
        {
            int swap = temp[i];
            temp[i] = A[i];
            A[i] = swap;
        }
        return count;
    }
}