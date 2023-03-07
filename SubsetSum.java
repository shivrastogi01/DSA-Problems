/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import static java.lang.System.out;

class SubsetSum {

	static int countSubsets(int arr[], int n, int sum)
	{
		if(n==0)
			return sum==0? 1 : 0;

		return countSubsets(arr, n-1, sum) + countSubsets(arr, n-1, sum - arr[n-1]);
	}

	public static void main (String[] args) {
		
		int n = 3, arr[]= {10, 20, 15}, sum = 25;

		System.out.println(countSubsets(arr, n, sum));

	}
}