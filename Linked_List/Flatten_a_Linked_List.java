import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    void merge(int[] arr, int l , int m, int r)
    {
        int n1 = m-l+1;
        int n2 = r-m;
        
        int [] a1 = new int[n1];
        int [] a2 = new int[n2];
        
        for(int i = 0 ; i<n1 ;++i)
        {
            a1[i] = arr[l+i];
        }
        
        for(int j = 0 ; j<n2 ;++j)
        {
            a2[j] = arr[m+1+j];
        }
        
        int i = 0 , j = 0, k = l;
        
         while (i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                arr[k] = a1[i];
                i++;
            }
            else {
                arr[k] = a2[j];
                j++;
            }
            k++;
        }
  
        while (i < n1) {
            arr[k] = a1[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = a2[j];
            j++;
            k++;
        }
    }
    void sort(int[] arr , int l , int r)
    {
        if(l<r)
        {
            int m = l+(r-l)/2;
            
            sort(arr,l,m);
            sort(arr,m+1 ,r);
            
            merge(arr, l,m,r);
        }
    }
    Node flatten(Node root)
    {
	// Your code here
	   Node temp = root;
	   int n = 0, m= 0;
	   int arr[] = new int[1001];
	   int i = 0;
	   while(temp!=null)
	   {
	       Node temp1 = temp;
	       while(temp1!=null)
	       {
	           arr[i] = temp1.data;
	           temp1 = temp1.bottom;
	           i++;
	           m++;
	       }
	       temp = temp.next;
	       n++;
	   }
	   
	    sort(arr,0,n+m-1);
	    Node head = new Node(arr[0]);
	    Node temp2 = head;
	    
	    for(int j = 1; j<n+m;j++ )
	    {
	        Node toAdd = new Node(arr[j]);
	        
	        temp2.bottom = toAdd;
	        temp2 = temp2.bottom;
	    }
	    while(head.data == 0)
	    {
	        head = head.bottom;
	    }
	  return head; 
    }
}