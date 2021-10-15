/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}
// } Driver Code Ends


/*
Structure of node class is:

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/
class Solution {
    
    Node reverseList(Node head)
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
    
    Node sortedMerge(Node headA, Node headB)
    {
         
        Node dummyNode = new Node(0);
         
        Node tail = dummyNode;
        while(true)
        {
             
            if(headA == null)
            {
                tail.next = headB;
                break;
            }
            if(headB == null)
            {
                tail.next = headA;
                break;
            }
           
            if(headA.data <= headB.data)
            {
                tail.next = headA;
                headA = headA.next;
            }
            else
            {
                tail.next = headB;
                headB = headB.next;
            }
             
            tail = tail.next;
        }
        return dummyNode.next;
    }
        
   public Node sort(Node head)
   {
        //your code here, return the head of the sorted list
        Node temp1 = head;
        Node temp2 = new Node(0);
        Node head2 = temp2;
        
        Node temp3 = new Node(0);
        Node head3 = temp3;
        
        Node temp = head ;
        if(temp.next==null)
        {
            return head;
        }

        int i = 1;
        while(temp1!=null)
        {
          if(i%2!=0)
          {
              Node add = new Node(temp1.data);
              temp2.next = add;
              temp2 = temp2.next;
          }
          else
          {
              Node add = new Node(temp1.data);
              temp3.next = add;
              temp3 = temp3.next;
          }
          i++;
          temp1 = temp1.next;
        }
  
        Node reverseHead = null;
        
        if(head3.next!=null)
        {
            reverseHead = reverseList(head3.next);
        }
      Node ans = sortedMerge(head2.next,reverseHead);
        
        return ans;
   }
   
}