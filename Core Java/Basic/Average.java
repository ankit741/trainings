import java.lang.*;
import java.util.Scanner;

class Average
{
	public static void main(String args[])
	{
		int n1,n2,n3;
		double avg;
		Scanner s = new Scanner(System.in);

		System.out.print("Enter three numbers : ");
		n1 = s.nextInt();
		n2 = s.nextInt();
		n3 = s.nextInt();

		avg = (n1+n2+n3)/3.0;		//5,6,8

		//System.out.println("Average = "+avg);
		System.out.printf("Average = %.2f\n",avg);
	}
}
