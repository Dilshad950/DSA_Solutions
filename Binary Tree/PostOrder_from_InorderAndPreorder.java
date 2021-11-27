import java.util.*;


class PostOrder
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int  T = sc.nextInt();
		while(T>0)
		{
			int N = sc.nextInt();
			int pre[] = new int[N];
			int in[] = new int[N];
			for(int i=0;i<N;i++)
				in[i]=sc.nextInt();
			for(int i=0;i<N;i++)
				pre[i]=sc.nextInt();
			GfG g = new GfG();
			g.printPostOrder(in,pre,N);
			System.out.println();
		T--;
		}
	}
}// } Driver Code Ends


/*prints the post order traversal of the 
tree */
class GfG
{
    int search(int arr[], int x, int n)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }
	void printPostOrder(int in[], int pre[], int n)
	{
		// Your code here
		int rootIndex = search(in,pre[0],n);
		
		if(rootIndex!=0)
		{
		    printPostOrder(in,Arrays.copyOfRange(pre,1,n),rootIndex);
		}
		
		if(rootIndex!=n-1)
		{
		    printPostOrder(Arrays.copyOfRange(in,rootIndex+1,n),
		    Arrays.copyOfRange(pre,rootIndex+1,n),n-rootIndex-1);
		}
// 		8 7 6 5 4 2 1   10 40 30 20 1
		
		System.out.print(pre[0] + " ");
	}
}