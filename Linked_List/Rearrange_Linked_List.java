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
            new Solution().rearrangeEvenOdd(head);
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

    Node(int d) {
        data = d;
        next = null;
    }
}
This is method only submission.
You only need to complete the below method.
*/
class Solution
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns nothing
    void rearrangeEvenOdd(Node head)
    {
          //  The task is to complete this method
          Node temp = head;
          int n = 0;
          while(temp!=null)
          {
             temp = temp.next;
             n++;
          }
          int m2 = n/2;
          int m1 = n - m2;
          int[] arr1 = new int [m1];
          int[] arr2 = new int [m2];
          
          Node temp1 = head;
          int i = 1;
          int count1 =0,count2 = 0;
          while(temp1!=null)
          {
              if(i%2!=0)
              {
                  arr1[count1++] = temp1.data;
                  
              }
              else
              {
                  arr2[count2++] = temp1.data;
              }
              temp1 = temp1.next;
              i++;
          }
          
          Node temp2 = head;
          head.data = arr1[0];
     
          temp2 = temp2.next;
          int j =1;
          while(j<m1)
          {
              
              temp2.data = arr1[j++];
              temp2 = temp2.next;
          
          }
          j= 0;
          while(j<m2)
          {
              temp2.data = arr2[j++];
              temp2 = temp2.next;
         
          }
     }
}
