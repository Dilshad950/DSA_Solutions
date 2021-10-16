import java.util.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            GfG gfg = new GfG();
            long res = gfg.count2s(n);
            System.out.println(res);
        }
        
    }
}
// } Driver Code Ends


class GfG
{
    public static long count2s(long n)
    {
        // Your code here
        int count = 0;
        if(n<9)
        {
            count = 1;
        }
        
        else if(n>11)
        {
            for(int i = 0 ; i<=n;i++)
            {
                int j = i ;
                
                while(j!=0)
                {
                    int temp = j%10;
                    if(temp==2)
                    {
                        count++;
                    }
                    j/=10;
                }
            }
        }
        return count;
        
    }
    
    public static long count2sinRangeAtDigit(long n, long d)
    {
        //Your code here too
        return 0 ;
    }
}