import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    static Node reverseList(Node head)
    {
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while(temp!=null){
            st.push(temp.data);
            temp = temp.next;
        }
        Node ans = new Node(st.pop());
        Node tail = ans;
        while(!st.isEmpty()){
            tail.next = new Node(st.pop());
            tail = tail.next;
        
        }
        return ans;
        // code here
    }
    public static void rearrange(Node odd)
    {
        // add your code here
        Node temp = odd;
        Node temp1 = new Node(0);
        Node head1 = temp1;
        while(temp!=null && temp.next!=null)
        {
            Node next = temp.next.next;
            Node add = new Node(temp.next.data);
            temp1.next = add;
            temp1 = temp1.next;
            
            temp.next = next;
            temp = temp.next;
        }
        Node reversedHead = null;
        if(head1.next!=null)
        {
          reversedHead = reverseList(head1.next);  
        } 
        
        Node temp2 = odd;
        while(temp2.next!=null)
        {
            temp2 = temp2.next;
        }
        temp2.next = reversedHead;
    }
}
