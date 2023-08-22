import java.lang.*;
import java.util.Scanner;

/*
There are 8 types of Java primitive data types namely:
a. Int
b. Float
c. Char
d. Boolean
e. Byte
f. Short
g. long
h. Double.

int is used for storing integer values. Its size is 4 bytes and has a default value of 0.The int data type is a 32-bit signed and a variable of the int data type takes 32 bits of memory. Its valid range is (-2^31 to 2^31– 1)

float is used for storing decimal values. Its default value is 0.0f and has a size of 4 bytes. It has an infinite value range. However its always advised to use float in place of double if there is a memory constraint.

char as the name suggests is useful for storing single value characters. Its default value is ‘\u0000’ with the max value being ‘\uffff’ and has a size of 2 bytes.

Example- char a=’D’;


boolean is a special datatype which can have only two values ‘true’ and ‘false’. It has a default value of ‘false’ and a size of 1 byte. It comes in use for storing flag values.


Byte is an 8 bit signed two’s complement. The range of values are -128 to 127. It is space efficient because it is smaller than integer datatyp

Short datatype is also similar to the integer datatype. However it’s 2 times smaller than the integer datatype. Its minimum range is -32,768 and maximum range is 32,767.

Long datatype primarily stores huge sized numeric data. It is a 64 bit integer and ranges from -2^63 to +(2^63)-1. It has a size of 8 bytes and is useful when you need to store data which is longer than int datatype.

Double is similar to the float datatype. However it has one advantage over float datatype i.e, it has two bit precision over the float datatype which has one bit precision. However it still shouldnt be used for precision sensitive data such as currency. It has a range of -2^31 to (2^31)-1.

    int a = 10;
    short s = 2;
    byte b = 6;
    long l = 125362133223l;
    float f = 65.20298f;
    double d = 876.765d;
    System.out.println("The integer variable is " + a);
    System.out.println("The short variable is " + s);
    System.out.println("The byte variable is " + b);
    System.out.println("The long variable is " + l);
    System.out.println("The float variable is " + f);
    System.out.println("The double variable is " + d);
*/


class DataTypes
{
	public static void main(String args[])
	{
		float x;
		x = 2.3F;
		x = 2.45E-7F;
		System.out.println("x = "+x);

		/*
		long x;
		x = 376474228484848L;
		int i = 1_000_000_000;
		x = i*3L;
		System.out.println("x = "+x);
		*/
		/*
		int x;
		//x = 20;
		//x = 020;
		x = 0x20;
		//x = 0b10101;
		x = 1_000_000_000;
		System.out.println("x = "+x);
		*/

		/*
		//byte(-128 +127), short(-32768 +32767)
		byte x;
		x = 127;
		x = (byte)(x+300);
		System.out.println("x = "+x);
		*/

		/*
		char ch;
		ch = 'a';			//A-Z	65-90		a-z		97-122
		int x = ch;
		System.out.println("ch = "+ch);
		System.out.println("x = "+x);

		x = 99;
		ch = (char)x;
		System.out.println("ch = "+ch);
		*/

		/*
		boolean b;			    //is an inconvertible data type
		b = true;
		//int x = (int)b;		//Error
		System.out.println("b = "+b);
		*/
	}
}
