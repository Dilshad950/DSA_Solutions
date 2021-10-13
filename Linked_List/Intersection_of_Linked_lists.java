//

import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        head = tail = new Node(val);
        
        size--;
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Solution obj = new Solution();
            
            Node result = obj.findIntersection(head1, head2);
            
            printList(result);
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* structure of list Node:

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

*/

class Solution
{
    public static Node findIntersection(Node head1, Node head2)
    {
        // add your code here
        // return the head of intersection list
        LinkedHashMap<Integer,Integer> set = new LinkedHashMap<>();
        Node temp1 = head1 ;
        Node temp2 = head2;
        Node ans = new Node(0);
        Node head = ans;
        // Node ans = null;
        // prev.next = ans;
        // int count = 0;
        while(temp1!=null)
        {   
            set.put(temp1.data,1);
            temp1 = temp1.next;
        }
        
        while(temp2!=null)
        {
            if(!set.containsKey(temp2.data))
            {
                set.put(temp2.data,1);
            }
            else
            {
                set.put(temp2.data,set.get(temp2.data)+1);
            }
            temp2 = temp2.next;
        }
        // for (Map.Entry<String,String> entry : gfg.entrySet())
        for(Map.Entry<Integer,Integer> entry : set.entrySet())
        {
            if(entry.getValue()>1)
            {
                Node add = new Node(entry.getKey());
                ans.next = add;
                ans = ans.next;
            }
        }
        return head.next;
    }
}