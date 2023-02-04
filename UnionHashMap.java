import java.util.*;

class UnionHashMap{
	public static void main(String[] args){
		System.out.println("Enter how many elements you want to enter in a array 1");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println("Enter the array elementsts");
		int arr1[]= new int[n];
		for(int i=0;i<n;i++)
		arr1[i]=sc.nextInt();
		
		System.out.println("Enter how many elements you want to enter in a array 2");
		int m=sc.nextInt();
		System.out.println("Enter the array elementsts");
		int arr2[]= new int[m];
		for(int i=0;i<m;i++)
		arr2[i]=sc.nextInt();
		
		System.out.println(unionSize(arr1,arr2));
		
	}
	static int unionSize(int arr1[],int arr2[]){
		Set<Integer> hs=new HashSet<Integer>();
		for(int i=0;i<arr1.length;i++)
		hs.add(arr1[i]);
		for(int i=0;i<arr2.length;i++)
		hs.add(arr2[i]);
		
		return hs.size();
	}
}