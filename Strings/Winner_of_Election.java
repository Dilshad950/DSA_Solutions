import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        TreeMap<String,Integer> mp = new TreeMap<>();
        ArrayList<String> list = new ArrayList<>();
        String[] ans = new String[2];
        for(int i = 0 ; i<n;i++)
        {
            if(!mp.containsKey(arr[i]))
            {
                mp.put(arr[i],1);
            }
            else
            {
                mp.put(arr[i],mp.get(arr[i])+1);
            }
        }
        int max = 1;
        String temp = " ";
        int i = 0;
        for(Map.Entry<String,Integer> entry : mp.entrySet())
        {
            if(i==0)
            {
                temp = entry.getKey();
                i++;
            }
            if(entry.getValue()>max)
            {
                list.add(entry.getKey());
                max = entry.getValue();
            }
        }
        
        if(list.isEmpty())
        {
            ans[0] = temp;
            ans[1] = "1";
            return ans;
        }
        
        ans[0] = list.get(list.size()-1);
        ans[1] = String.valueOf(mp.get(list.get(list.size()-1)));
        return ans;
    }
}

