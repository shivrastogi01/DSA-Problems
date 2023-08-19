import java.util.*;

public class Vote{
	public void eligibleForVote(int a){
		if(a>=18)
		System.out.println("The person is eligible for vote");
		else
		System.out.println("The person is not eligible for vote");
	}
	
	
	public static void main(String [] ars){
		System.out.println("enter the age");
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		Vote v= new Vote();
		v.eligibleForVote(a);
	}
}