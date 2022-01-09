//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    
    // Return the size of the largest sub-tree which is also a BST
    static int prev = Integer.MIN_VALUE;
    static int nodes = 0;
    static boolean helper(Node root)
    {
        
        if(root==null) return true;
        
        if(!helper(root.left)) return false;
        
        if(root.data<=prev) return false;
        
        prev = root.data;
        nodes++;
    
       return helper(root.right);
    }
    // static boolean isBST(Node root)
    // {
    //     // code here.
    //     return helper(root);
             
    // }
    
    
    static int largestBst(Node root)
    {
        // Write your code here
        if(root==null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int ans = Integer.MIN_VALUE;

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i<size; i++)
            {
                nodes = 0;
                Node temp = q.poll();
                prev = Integer.MIN_VALUE;
                if(helper(temp))
                {
                    ans = Math.max(ans,nodes);
                }
                
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
        }
    
        return (ans==Integer.MIN_VALUE)?1:ans;
       
        
    }
    
}