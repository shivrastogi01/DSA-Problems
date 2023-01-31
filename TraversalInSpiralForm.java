import java.util.*;
import java.io.*;
import java.lang.*;

class Node  
{ 
  int key; 
  Node left; 
  Node right; 
  Node(int k){
      key=k;
      left=right=null;
  }
}


class TraversalInSpiralForm { 
    
    public static void main(String args[]) 
    { 
        Node root=new Node(1);
    	root.left=new Node(2);
    	root.right=new Node(3);
    	root.left.left=new Node(4);
    	root.left.right=new Node(5);
    	root.right.left=new Node(6);
    	root.right.right=new Node(7);
    	
        printSpiral(root);
    } 
    
    public static void printSpiral(Node root){
        if (root == null) 
            return; 
        Stack<Node> s1 = new Stack<Node>();  
        Stack<Node> s2 = new Stack<Node>();  
   
        s1.add(root); 
  
        while (!s1.isEmpty() || !s2.isEmpty()) { 
            while (!s1.empty()) { 
                Node temp = s1.peek(); 
                s1.pop(); 
                System.out.print(temp.key + " "); 
  
                if (temp.right != null) 
                    s2.add(temp.right); 
  
                if (temp.left != null) 
                    s2.add(temp.left); 
            } 
  
            while (!s2.empty()) { 
                Node temp = s2.peek(); 
                s2.pop(); 
                System.out.print(temp.key + " "); 
  
                if (temp.left != null) 
                    s1.add(temp.left); 
                if (temp.right != null) 
                    s1.add(temp.right); 
            } 
        }
    }   
} 