import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            Solution g = new Solution();
            head = g.deleteMid(head);
            printList(head); 
            t--;
        }
    } 
} 
   
// } Driver Code Ends


/*
class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution {
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        Node temp = head;
        Node temp1 = head;
        int d =0;
        int n = 0;
        while(temp!=null)
        {
            temp = temp.next ;
            n++;
        }
        if(n%2!=0)
        {
            d = (n-1)/2;
        }
        else if(n%2==0)
        {
            d = n/2;
        }
        while(d>1)
        {
            temp1 = temp1.next;
            d--;
        }
        Node next = temp1.next.next;
        temp1.next = next;
    
     return head;
    }
}