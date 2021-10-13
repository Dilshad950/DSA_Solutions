import java.util.*;

class Maxsum_Among_All_Rotations_Array
{
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			
			System.out.println(new GfG().max_sum(arr,n));
			
		t--;
		}
	}
	
}
// } Driver Code Ends


class GfG
{
    int max_sum(int A[], int n)
    {	// Your code here
        int ans = 0;
        int sum = 0;
        int currSum = 0;
        for(int i = 0; i<n; i++)
        {
            sum+=A[i];
            currSum += i*A[i];
        }
        ans = currSum;
        for(int i = 1 ; i<n ;i++)
        {
            int nextSum = currSum -(sum -A[i-1]) + A[i-1]*(n-1);
            
            currSum = nextSum;
            
            ans = Math.max(ans,nextSum);
        }
        return ans;
    }	
}
