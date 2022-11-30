import java.util.*;
import java.io.*;
import java.lang.*;
class StockBuyProblem
{ 
    

    static int maxProfit(int price[])
    {
    	int profit = 0;

    	for(int i = 1; i < price.length; i++)
    	{
    		if(price[i] > price[i - 1])
    			profit += price[i] - price[i -1];
    	}
    
    	return profit;
    }


    public static void main(String args[]) 
    { 
      System.out.println("Enter the no of element you want to enter in Array");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("Enter array element");
	int arr[]=new int[n];
	for(int i=0;i<n;i++)
	arr[i]=sc.nextInt();

       System.out.println(maxProfit(arr));

    } 

}