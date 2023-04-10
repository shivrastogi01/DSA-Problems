import java.util.*;
import java.io.*;
import java.lang.*;

class Node{
        int data;
        Node next;
        Node(int x){
            data=x;
            next=null;
        }
    }
  
class SwapNodesLinkedlist { 
    
    public static void main(String args[]) 
    { 
        Node head=new Node(1);
    	head.next=new Node(2);
    	head.next.next=new Node(3);
    	head.next.next.next=new Node(4);
    	head.next.next.next.next=new Node(5);
    	printlist(head);
    	head=pairwiseSwap(head);
    	printlist(head);
    	
    } 
    
    static Node pairwiseSwap(Node head){
        if(head==null||head.next==null)
            return head;
        Node curr=head.next.next;
        Node prev=head;
        head=head.next;
        head.next=prev;
        while(curr!=null&&curr.next!=null){
            prev.next=curr.next;
            prev=curr;
            Node next=curr.next.next;
            curr.next.next=curr;
            curr=next;
        }
        prev.next=curr;
        return head;
    }
    
    public static void printlist(Node head){
        Node curr=head;
        while(curr!=null){
        System.out.print(curr.data+" ");
        curr=curr.next;
    }System.out.println();
    }
} 