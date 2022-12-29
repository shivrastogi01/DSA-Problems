import java.util.*;
import java.lang.*;
import java.io.*;

class UnionElement
{
    public static void main (String[] args) 
    {
      System.out.println("Enter the no of element you want to enter in Array 1");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array elements");
	int arr1[]=new int[n];
	for(int i=0;i<n;i++)
	arr1[i]=sc.nextInt();
       
	    System.out.println("Enter the no of element you want to enter in Array 2");
	int m=sc.nextInt();
	System.out.println("Enter array elements");
	int arr2[]=new int[m];
	for(int i=0;i<m;i++)
	arr2[i]=sc.nextInt();
	
	    printUnion(arr1,arr2);
        
    }
    
    static void printUnion(int a[], int b[]){
    
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(i>0 && a[i-1]==a[i]){i++;continue;}
            if(j>0 && b[j-1]==b[j]){j++;continue;}
            if(a[i]<b[j]){System.out.print(a[i]+" ");i++;}
            else if(a[i]>b[j]){System.out.print(b[j]+" ");j++;}
            else{System.out.print(a[i]+" ");i++;j++;}
        }
            while(i<a.length){if(i==0||a[i]!=a[i-1])System.out.print(a[i]+" ");i++;}
            while(j<b.length){if(j==0||b[j]!=b[j-1])System.out.print(b[j]+" ");j++;}
    }
}
