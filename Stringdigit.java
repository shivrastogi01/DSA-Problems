import java.util.*;

public class Stringdigit
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		int count=0;
		int temp=0;
		
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='1'||str.charAt(i)=='2'||str.charAt(i)=='3'||str.charAt(i)=='4'||str.charAt(i)=='5'||str.charAt(i)=='6'||str.charAt(i)=='7'||str.charAt(i)=='8'||str.charAt(i)=='9'||str.charAt(i)=='0')
			count++;
			else
			temp++;
		}
		if(temp!=0)
		System.out.println("false");
		else
		System.out.println("true");
	}
}