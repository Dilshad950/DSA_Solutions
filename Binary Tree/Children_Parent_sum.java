//Initial Template for Java




//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}


class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
			    Tree g=new Tree();
                System.out.println(g.isSumProperty(root));
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        int ans = 1;
        // if(root==null)
        // {
        //     return 1;
        // }
        // int children = 0;
        // if(root.left!=null && root.right!=null)
        // {
        //     children = root.left.data + root.right.data;
        // }
        // else if(root.left==null && root.right!=null)
        // {
        //     children = root.right.data;
        // }
        // else if(root.left!=null && root.right==null)
        // {
        //     children = root.left.data;
        // }
        // if(root.data == children)
        // {
        //     ans = 1;
        //     ans = isSumProperty(root.left);
        //     ans = isSumProperty(root.right);
            
        // }
        // return ans;
        if(root==null)
        {
            return 1;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i = 0 ; i<n ;i++)
            {
                Node temp = q.poll();
                int children = 0;
                
                if(temp.left==null && temp.right==null)
                {
                    continue;
                }
                if(temp.left!=null && temp.right!=null)
                {
                    children = temp.left.data + temp.right.data;
                }
                else if(temp.left==null && temp.right!=null)
                {
                    children = temp.right.data;
                }
                else if(temp.left!=null && temp.right==null)
                {
                    children = temp.left.data;
                }
                if(temp.data == children)
                {
                    ans = 1;
                }
                else
                {
                    ans = 0;
                    break;
                }
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
                
            }
        }
        return ans;
    }
}