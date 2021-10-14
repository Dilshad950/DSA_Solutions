import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}// } Driver Code Ends




class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character> st = new Stack<>();
        char[] arr = x.toCharArray();
        int n = arr.length;
        for(int i = 0 ; i<n ;i++)
        {
            if(arr[i]=='{' || arr[i] =='(' || arr[i] == '[')
            {
                st.push(arr[i]);
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }
                else if((arr[i]=='}' && st.peek()=='{') || (arr[i]==')' && st.peek()=='(') 
                || (arr[i]==']' && st.peek()=='['))
                {
                    st.pop();
                }
                
                else
                {
                    return false;
                }
            }
        }
        if(st.isEmpty())
        {
            return true;
        }
        return false;
    }
}
