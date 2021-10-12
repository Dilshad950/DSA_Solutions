import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}

// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
          char[] arr = str.toCharArray();
          int count = 0;
          int n = arr.length;
          StringBuilder str1 = new StringBuilder();
          if(n==1)
          {
             str1.append(Character.toString(arr[0]));
            str1.append(Integer.toString(1));
            return str1.toString();
          }
          for(int i = 0 ; i<arr.length-1;i++)
          {
              if(arr[i]==arr[i+1])
              {
                  count++;
              }
              
              
              else if(arr[i]!=arr[i+1] )
              {
                  str1.append(Character.toString(arr[i]));
                  count++;
                  str1.append(Integer.toString(count));
                  count =0;
              }
              if(arr[i]==arr[i+1] && i==arr.length-2)
              {
                  str1.append(Character.toString(arr[i]));
                  count++;
                  str1.append(Integer.toString(count));
                  count =0;
              }
          }
          if(n>1 && arr[n-2]!=arr[n-1])
          {
            str1.append(Character.toString(arr[n-1]));
            str1.append(Integer.toString(1));
          }
          return str1.toString();
	}
	
 }