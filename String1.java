public class String1
{
	
	
	public static void main(String[] args)
	{
		String S1="Computer";
		String S2="Computer";
		String S3=new String("Computer");
		System.out.println("Result1: "+(S1==S2));//true
		System.out.println("Result2: "+S1.equals(S3));//true
		System.out.println("Result3: "+(S1==S3));//False
		
	}	
}