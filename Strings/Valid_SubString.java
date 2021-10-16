import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        // code here
        char[] arr = S.toCharArray();
        int n = arr.length;
        int ans = 0;
        // Stack<Character> st = new Stack<>();
        int l = 0,r=0;
        for(int i = 0; i<n ; i++)
        {
            if(arr[i]=='(')
            {
                l++;
            }
            else
            {
                r++;
            }
            
            if(l==r)
            {
                ans = Math.max(ans,2*r);
            }
            else if(r>l)
            {
                l=0;
                r=0;
            }
        }
        l = 0; 
        r= 0;
        
        for(int i = n-1; i>=0; i--)
        {
            if(arr[i]=='(')
            {
                l++;
            }
            else
            {
                r++;
            }
            
            if(l==r)
            {
                ans = Math.max(ans,2*l);
            }
            else if(l>r)
            {
                l=0;
                r=0;
            }
        }
      return ans;  
    }
};