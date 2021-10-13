import java.util.*;

class Count
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int m = sc.nextInt();
            int n = sc.nextInt();
            
            int arr1[] = new int[m];
            int arr2[] = new int[n];
            
            for(int i = 0; i < m; i++)
              arr1[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              arr2[i] = sc.nextInt();
              
            Solution gfg = new Solution();
            ArrayList<Integer> res = gfg.countEleLessThanOrEqual(arr1, arr2, m, n);
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
        
    }
}// } Driver Code Ends



// Complete the function given below
class Solution
{
    static int search(int[] arr ,int l, int r , int value )
    {
        int mid =0;
        
       while(l<=r)
       {
          mid = (l+r)/2;
          if(arr[mid]<=value)
          {
              l = mid+1;
          }
          else
          {
              r = mid -1;
          }
       }
       return r+1;
    }
    
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[], int m, int n)
    {
        Arrays.sort(arr2);
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = 0 ; i<m ;i++)
        {
           ans.add(search(arr2,0,n-1,arr1[i])); 
        }
        return ans;
       // add your code here
    }
}