// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    static Node reverseList(Node head)
    {
        Stack<Integer> s = new Stack<>();
        Node temp = head;
        
        while(temp!=null)
        {
            s.push(temp.data);
            temp = temp.next;
        }
       Node newHead = new Node(s.peek());
       Node temp2 = newHead;
       s.pop();
       while(!s.isEmpty())
       {
           Node toAdd = new Node(s.peek());
           s.pop();
           temp2.next = toAdd;
           temp2 = temp2.next;
       }
       return newHead;
    }
 
  //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node a, Node b){
        // code here
     Node  A =  reverseList(a);
     Node  B =  reverseList(b);
    Node temp1 = A;
    Node temp2 = B;
    int carry = 0;
    Node prev = new Node(0);
    Node ansHead = prev;
    while(temp1!=null || temp2!=null)
    {   
        int newValue =0;
        if(temp1!=null && temp2!=null)
        {
            newValue = temp1.data + temp2.data + carry;
             temp1 = temp1.next;
             temp2 = temp2.next;
        }
        else if(temp1==null)
        {
            newValue = temp2.data + carry; 
            temp2 = temp2.next;
        }
        else if(temp2==null)
        {
            newValue = temp1.data +  carry;
            temp1 = temp1.next;
        }
        carry = newValue/10;
        newValue %=10;
       Node toAdd = new Node(newValue);
     
        prev.next = toAdd;
        prev = toAdd;
     
       
    }
    if(carry!=0)
    {
        Node carryNode = new Node(carry);
        Node temp = ansHead.next;
        while(temp.next!=null)
        {
            temp = temp.next;
        }
        temp.next = carryNode;
    }
    return reverseList(ansHead.next);
}
}