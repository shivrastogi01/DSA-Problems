import java.util.Scanner ;
public class UserSum
{
public static void main (String[] args)
	{
	int i,j=0;
	System.out.println("Enter any numbers");
	Scanner input = new Scanner(System.in);
	int userValue = input.nextInt();
	
	for(i=1;i<= userValue; i++)
		{
		j+=i;
		System.out.println(i);
	
	
		}
	System.out.println(j);
	
	}
}