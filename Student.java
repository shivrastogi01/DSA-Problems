    class Student
	{
		String name;
		int roll_no;
		
		Student(String name,int roll_no)
		{
			this.name=name;
			this.roll_no=roll_no;
			
		}
		public static void main(String[] args)
		{
			Student s1=new Student("Shiv",10);
			Student s2=new Student("Shivam",13);
			System.out.println(s1.name+"  "+s1.roll_no);
			System.out.println(s2.name+"  "+s2.roll_no);
		}
	
	}