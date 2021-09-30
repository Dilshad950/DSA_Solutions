// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.io.*;

  public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String s) {
        // Write your code here
        String[] parts = s.split("\\.");
        int n = parts.length;
        
        int count = 0;
        for(char c : s.toCharArray())
        {
            if(c=='.')
            {
                count++;
            }
        }
        
        if(count!=3)
        {
            return false;
        }
        
        boolean ans = false;
        for(int i = 0 ; i< n ;i++)
        {   
            int value = 0;
            if(n!=4)
            {
                return false;
            }
            try
            {
                 value = Integer.valueOf(parts[i]);
            }
            catch(NumberFormatException e)
            {
                return false;
            }
            int numDigits = String.valueOf(value).length();
            
            if(numDigits!= parts[i].length())
            {
             return false;   
            }
            if(value>=0 && value<=255)
            {
                ans = true;
            }
            else 
            {
                return false;
            }
        }
        return ans;
    }
}