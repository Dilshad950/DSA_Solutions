//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    String list[] = new String[n];
                    for(int i = 0;i<n;i++)
                        list[i] = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.countWords(list, n));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int countWords(String list[], int n)
    {
        // code here
        HashMap<String,Integer> mp = new HashMap<>();
        int ans = 0;
        for(String s : list)
        {
            // boolean check = false;
            if(mp.containsKey(s))
            {
                mp.put(s,mp.get(s)+1);
                
            }
            else
            {
                mp.put(s,1);
            }
        }
        for(Map.Entry<String,Integer> map : mp.entrySet())
        {
            if(map.getValue()==2)
            {
                ans++;
            }
        }
        return ans;
    }
}