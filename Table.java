import java.util.Scanner;
public class Table
{
	public static void main(String[] args)
	{
	int i,j=0;
	System.out.println("Which table you Want to print ");
	Scanner input = new Scanner(System.in);
	int value = input.nextInt();
	System.out.println("How many times you want to print");
	//Scanner input = new Scanner(System.in);
	int times =input.nextInt();
	for(i=1;i<= times;i++)
		{
		System.out.println(value+" X " +i +" = " +i*value);
		}
		j+=i*value;
		System.out.println(" The sum is " +j);
	
	}
}