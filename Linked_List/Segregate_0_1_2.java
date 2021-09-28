//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
      
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        Node zero = zeroD;
        Node one = oneD;
        Node two = twoD;
        Node temp = head;
        while(temp!=null)
        {
            if(temp.data == 0)
            {
                zero.next = temp;
                zero = zero.next;
              
            }
            if(temp.data == 1)
            {
                one.next = temp;
                one = one.next;
            }
            if(temp.data == 2)
            {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        // two.next = null;
        if(zeroD.next==null)
        {
            one.next = twoD.next;
            two.next = null;
            return oneD.next;
        }
        
        else if(oneD.next ==null)
        {
            zero.next = twoD.next;
            two.next = null;
            return zeroD.next;
        }
        
        else if(twoD.next == null)
        {
            zero.next = oneD.next;
            one.next = null;
            return zeroD.next;
        }
            two.next = null;
           one.next = twoD.next;
           zero.next = oneD.next;
         
           
       return zeroD.next;
        
        // return zeroD.next;
    }
}


