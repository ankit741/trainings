import java.lang.*;
import java.util.Scanner;
//import java.*;			-- imports Nothing

class AddNumbers
{
	public static void main(String args[])
	{
		int n1,n2,sum;
		Scanner s = new Scanner(System.in);

		/*
		System.out.print("Enter first number : ");
		n1 = s.nextInt();

		System.out.print("Enter second number : ");
		n2 = s.nextInt();
		*/

		System.out.print("Enter two numbers : ");
		n1 = s.nextInt();
		n2 = s.nextInt();

		sum = n1+n2;

		System.out.println("Sum = "+sum);
	}
}
