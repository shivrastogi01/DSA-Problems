import java.io.*;
import java.util.*;

class SumOfLastFourNumers{
	public static int LargestFour(int [] arr){
		 Arrays.sort(arr);
		int n= arr.length;
		int res=0;
		
		if(n<5){
			for (int i=0;i<n-1;i++){
				res +=arr[i];
			}
			return res;
		}
	
			for(int i=n-1;i>=n-4;i--){
				res +=arr[i];
			}
			return res;
		
		
	}
	
public static void main(String [] args){
	Scanner s= new Scanner(System.in);
	//System.out.println(LargestFour(s.nextLine()));
	int arr[]={4,5,-2,3,1,2,6,6};
	System.out.println(LargestFour(arr));
}

}