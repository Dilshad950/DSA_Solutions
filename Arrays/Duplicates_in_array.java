import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        // Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        for(int i = 0 ; i<n ; i++)
        {
            if(!mp.containsKey(arr[i]))
            {   count=0;
                count++;
                mp.put(arr[i],count);
                // count++;
            }
            else
            {
                mp.put(arr[i],mp.get(arr[i])+1);
            }
        }
        
    
        for(Map.Entry<Integer,Integer> entry : mp.entrySet())
        {
            if(entry.getValue()>1 )
            {   
                
                ans.add(entry.getKey());
            }
        }
        if(ans.isEmpty())
        {
            ans.add(-1);
        }
         return ans;
    }
}
