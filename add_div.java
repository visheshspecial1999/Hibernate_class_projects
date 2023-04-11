// ASS9 Qu3 WAJP to desine a method which perform addition devision with two variables and print the output.
		import java.util.Scanner;
		class Add_Div
{
		public static void main(String [] args)
	{
		Scanner sr=new Scanner(System.in);
		System.out.print("enter the first number : ");
		double d1=sr.nextDouble();
		System.out.print("enter the second number : ");
		double d2=sr.nextDouble();
		double d5=add(d1,d2);
		double d6=div(d1,d2);
		System.out.println("The addition is : "+d5);
		System.out.print("The devision is : "+d6);
	}
		public static double add(double x,double y)
	{
		double d3=x+y;
		return d3;
	}
		public static double div(double x,double y)
	{
		double d4=x/y;
		return d4;
	}
}