import java.util.Scanner.*;

public class Vowel
{
	public static void main(String[] args)
	{
		
		String s = new String("My name is Shiv Rastogi");
		int num=0;
		s=s.toUpperCase();
		String [] arrOfS=s.split(" ");
		for (String a:arrOfS)
		{
		 String n=a;
		for(int i=0;i<n.length();i++)
		{
			
			if(n.charAt(i)=='A'||n.charAt(i)=='E'||n.charAt(i)=='I'||n.charAt(i)=='O'||n.charAt(i)=='U')
			{
				num=num+1;
				
			}
		}
		System.out.println(n + "=" + num);
		num=0;
	    }
	}
	
}
