//Initial Template for Java

import java.io.*;
import java.util.*;

 // } Driver Code Ends
//User function Template for Java

class Solution{
    static int distance(int X,int Y){
        
        // code here
        int bigger = (X>Y)?X:Y;
        int smaller = (bigger==X)?Y:X;
        int ans = 0;
        
        while(bigger!=smaller)
        {
            
            if(bigger>smaller)
            {
                bigger = (int)Math.floor(bigger/2);
                ans++;
            }
            else if(bigger<smaller)
            {
                ans+= distance(smaller,bigger);
                break;
            }
        }
        return ans;
    }
}

// { Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int X = Integer.parseInt(S[0]);
            int Y = Integer.parseInt(S[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.distance(X,Y));
        }
    }
}  // } Driver Code Ends