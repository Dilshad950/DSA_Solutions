import java.lang.*;

class Node
{
	int data;
	Node left, right;
	Node(int d)
	{
		data = d;
		left = right = null;
	}
}

class Roof_To_Leaf_Paths_Having_Equal_Length
{
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
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
	public static void main(String args[]) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t>0)
		{
		    String s = br.readLine();
	    	Node root = buildTree(s);
			GfG g = new GfG();
			g.countPaths(root);
			System.out.println();
		    t--;
		}
	}
}// } Driver Code Ends


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */


class GfG
{
    HashMap<Integer,Integer> map = new HashMap<>();
    boolean isLeaf(Node root)
    {
        if(root==null) return false;
        if(root.left==null && root.right==null) return true;

        return false;
    }

    void helper(Node root,int count , int length)
    {
        if(root==null) return;

        length++;
        if(isLeaf(root))
        {
            count++;
            if(map.containsKey(length))
            {
                map.put(length,map.get(length)+1);
            }
            else
                map.put(length,count);
            length=0;
            return;
        }


        helper(root.left,0,length);
        helper(root.right,0,length);
    }
    HashMap<Integer,Integer> Paths(Node root){
        // Code here
       
        helper(root,0,0);

        return map;
    }
    void countPaths(Node root)
    {
	    // Your code here	
	    HashMap<Integer,Integer> mp = new HashMap<>();
	    mp = Paths(root);
	    for(Map.Entry<Integer,Integer> entry : mp.entrySet())
	    {
	        System.out.print(entry.getKey() + " ");
	        System.out.print(entry.getValue() + " ");
	        System.out.print("$");
	    }
    }
}
