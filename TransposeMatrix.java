import java.util.*;
import java.io.*;
import java.lang.*;



class TransposeMatrix
{ 
	static int n = 4;

	static void swap(int mat[][], int i, int j)
	{
			int temp = mat[i][j];
			mat[i][j] = mat[j][i];
			mat[j][i] = temp;
	}

	static void transpose(int mat[][])
	{

		for(int i = 0; i < n; i++)
			for(int j = i + 1; j < n; j++)
				swap(mat, i, j);
	}

	public static void main(String args[]) 
    {
        int arr[][] = {{1, 2, 3, 4},
    				   {5, 6, 7, 8},
    				   {9, 10, 11, 12},
    				   {13, 14, 15, 16}};

    	transpose(arr);

    		for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					System.out.print(arr[i][j]+" ");
				}

				System.out.println();
			}	
    } 

}