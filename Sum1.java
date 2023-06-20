class Operation
{
	public void Add(int a,int b)
	{
		int p,q,c;
	    c=a+b;
		System.out.println(c);
	}
	
	public void Add(float l,float n)
	{
		float m;
	    m=l+n;
		System.out.println(m);
	}
}
public class Sum1
{
	public static void main(String [] args)
	{
		Operation obj= new Operation();
		obj.Add(2,5);
		obj.Add(2.2132342,2.53);
		
	}
}