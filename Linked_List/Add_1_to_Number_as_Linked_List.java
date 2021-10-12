import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

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
    public static Node addOne(Node head) 
    { 
        //code here.
        Node temp = head;
        Node reversedList = reverseList(head);
        
        int carry = 0;
        Node temp1 = reversedList;
        reversedList.data = reversedList.data +1;
        int value = reversedList.data;
        reversedList.data %=10;
        carry = value/10;
        temp1 = temp1.next;
        while(carry!=0 && temp1!=null)
        {
             temp1.data = (temp1.data +1);
             carry = temp1.data/10;
             temp1.data %=10;
             temp1 = temp1.next ;
        }
        Node temp2 = reversedList;
        if(carry!=0)
        {
            while(temp2.next!=null)
            {
                temp2 = temp2.next;
            }
            Node add = new Node(1);
            temp2.next = add;
        }
       
     return reverseList(reversedList);   
    }
}
