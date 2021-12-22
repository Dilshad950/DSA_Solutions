/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head)
    {
        //write code here and return the head of changed linked list
        Node temp = head;
        
        Node vD = new Node('*');
        Node vowel = vD;
        
        Node cD = new Node('*');
        Node cons = cD;
        
        while(temp!=null)
        {
            char data = temp.data;
            if(data=='a' || data=='e' || data=='i' || data=='o' || data=='u' )
            {
                Node toAdd = new Node(data);
                vowel.next = toAdd;
                vowel = vowel.next;
            }
            else
            {
                Node toAdd = new Node(data);
                cons.next = toAdd;
                cons = cons.next;
            }
            temp = temp.next;
        }
        
        if(vD.next==null)
        {
            return head;
        }
        
        Node trav = vD.next;
        
        while(trav.next!=null)
        {
            trav = trav.next;
        }
        trav.next = cD.next;
        return vD.next;
    }
}