import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int arr[] = new int[n];
                    ArrayList<Integer> res = new ArrayList<Integer>();
                    for(int i = 0;i<n;i++)
                        {
                            arr[i] = sc.nextInt();
                        }
                    
                    Solution obj = new Solution();
                    
                    res = obj.findPairs(arr, n);
                    if(res.size()!=0)
                        {
                            for(int i = 0;i<res.size();i++)
                               System.out.print(res.get(i) + " ");
                            System.out.println();   
                        }
                    else
                        System.out.println(0);   
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list containing all the pairs having both
    //negative and positive values of a number in the array.
    public static ArrayList<Integer>findPairs(int arr[], int n) 
    { 
    	// code here.
    	LinkedHashMap<Integer,Boolean> map = new LinkedHashMap<>();
    	ArrayList<Integer> ans = new ArrayList<>();
    	for(int a : arr)
    	{
    	    if(map.containsKey(a*(-1)) || map.containsKey(a)) 
    	        map.put(a,true);
    	    
    	    else 
    	        map.put(a,false);
    	}
    	
    	for(Map.Entry<Integer,Boolean> entry : map.entrySet())
    	{
    	    if(entry.getValue())
    	    {
    	        ans.add(Math.abs(entry.getKey())*(-1));
    	        ans.add(Math.abs(entry.getKey()));
    	    }
    	}
    	if(ans.isEmpty())
    	    ans.add(0);
    	return ans;
    }
}