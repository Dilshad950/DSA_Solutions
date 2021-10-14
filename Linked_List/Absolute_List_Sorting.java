import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
		
public class Absolute_List_Sort
{
    Node head;  
	
	/* Function to print linked list */
    void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) 
	{

		if (head == null) 
			head = node;
		else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;

		   temp.next = node;
		}
    }
	  
    /* Drier program to test above functions */
    public static void main(String args[])
    {
       
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			Absolute_List_Sort llist = new Absolute_List_Sort();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
          
            GfG gfgobj = new GfG(); 
    		llist.head = gfgobj.sortList(llist.head);
    		llist.printList(llist.head);
		
			t--;
		}
	}
}// } Driver Code Ends


/* The structure of the node of the Linked List is
class Node
{
   int data;
   Node next;
   Node(int d) {data = d; next = null; }
 }
*/

class GfG
{
    Node reverseList(Node head)
    {
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        if(st.isEmpty())
        {
            return head;
        }
        Node ans = new Node(st.peek());
        st.pop();
        Node tail = ans;
        while(!st.isEmpty()){
            tail.next = new Node(st.pop());
            tail = tail.next;

        }
        return ans;
        // code here
    }
	Node sortList(Node head) 
	{
		// Your code here
		Node temp = head;
		Node ans = new Node(0);
		Node head1 = ans;
		Node ans1 = new Node(0);
		Node head2 = ans1;
		while(temp!=null)
		{
		    if(temp.data<0)
		    {
		        Node add = new Node(temp.data);
		        ans.next = add;
		        ans = ans.next;
		    }
		    else
		    {
		        Node add = new Node(temp.data);
		        ans1.next = add;
		        ans1 = ans1.next;
		    }
		    temp = temp.next;
		}
		if(head1.next==null)
		{
		    return head;
		}
		Node neg = reverseList(head1.next);
		Node temp1 = neg;
		
		while(temp1.next!=null)
		{
		    temp1 = temp1.next;
		}
		temp1.next = head2.next;
		
		return neg;
	}
}