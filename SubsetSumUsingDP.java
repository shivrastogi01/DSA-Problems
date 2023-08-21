/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import static java.lang.System.out;

class SubsetSumUsingDP {

	static int countSubsets(int arr[], int n, int sum)
	{
		int dp[][]= new int[n+1][sum+1];

		for(int i=0; i<=n; i++) dp[i][0] = 1;
		for(int j=1; j<=sum; j++) dp[0][j] = 0;


		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=sum; j++)
			{
				if(j < arr[i-1])
					dp[i][j] = dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j] + dp[i][j - arr[i-1]];
			}	
		}

		return dp[n][sum];
	}

	public static void main (String[] args) {
		
		int n = 3, arr[]= {2, 5, 3}, sum = 5;

		System.out.println(countSubsets(arr, n, sum));

	}
}