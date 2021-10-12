import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}
// } Driver Code Ends




class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        String[] arr = S.split("\\.");
        Stack<String> st = new Stack<>();
        for(String s:arr)
        {
            st.push(s);
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty())
        {   
            String s = st.peek();
            str.append(s);
            str.append(".");
            st.pop();
        }
        // str.append("1");
        // str.append(st.peek());
        
        return str.substring(0,str.toString().length()-1);
    }
}