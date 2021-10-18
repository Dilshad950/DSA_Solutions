import java.util.*;
public class MSP
{	
    public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while (t-- != 0)
		{
			int n=sc.nextInt();
			ArrayList<String> s = new ArrayList<String>(n);
			for (int i=0;i<n;i++)
			    s.add(sc.next());
			String tt;
			tt=sc.next();
			GfG g=new GfG();
			ArrayList<String> res =g.findMatchedWords(s, tt);
			Collections.sort(res);
			for (int i = 0;i < res.size();i++)
			    System.out.print(res.get(i)+" ");
			System.out.println();

		}
	}
}// } Driver Code Ends


/*Complete the provided function*/

class GfG
{
/* The function returns an array of strings 
present in the dictionary which matches
the string pattern.
You are required to complete this method */
public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
	{
	    //add code here.
	    ArrayList<String> ans = new ArrayList<>();
	   
	    
	    for(String s : dict)
	    {
	        HashMap<Character,Character> mp = new HashMap<>();
	        if(s.length()!=pattern.length())
	        {
	            continue;
	        }
	        
	        for(int j = 0;j<s.length();j++)
	        {
	            if(!mp.containsKey(s.charAt(j)))
	            {
	                mp.put(s.charAt(j),pattern.charAt(j));
	            }
	        }
	        
	        int hash1[] = new int[256];
	        int hash2[] = new int[256];
	        
	        int i = 0;
	        for(i = 0; i<s.length();i++)
	        {
	            if(hash1[s.charAt(i)] == hash2[pattern.charAt(i)] && pattern.charAt(i)==mp.get(s.charAt(i)))
	            {
	                hash1[s.charAt(i)]++;
	                hash2[pattern.charAt(i)]++;
	            }
	            else
	            {
	                break;
	            }
	        }
	        if(i==s.length())
	        {
	            ans.add(s);
	        }
	    }
	    return ans;
	}
}