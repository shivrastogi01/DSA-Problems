import java.util.*;
 public class String_intoCharArray
 {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any string");
		String str=sc.nextLine();
		for(int i=0;i<str.length();i++)
		System.out.print(str.charAt(i)+",");
	}
 }