package codes;
import java.util.*;

public class PrelimLab {

	public static void main(String[] args) {
		MyMath MyMath = new MyMath();
		MyMath.menu();
	}
}

class MyMath {	
	static Scanner sc = new Scanner(System.in);
	static double add (double num1, double num2) {
		double sum = num1 + num2;
		return sum;
	}
	
	static double add (double num1, double num2, double num3) {
		double sum = num1 + num2 + num3;
		return sum;
	}
	
	static double add (double num1, double num2, double num3, double num4) {
		double sum = num1 + num2 + num3 + num4;
		return sum;
	}
	
	void menu () {
		System.out.println("-------------ADD--------------");
		System.out.print("1 - EXIT\n2 - 2 NUMBERS\n3 - 3 NUMBERS\n4 - 4 NUMBERS\nCHOOSE THE NUMBER OF NUMBERS YOU WANT TO ADD: ");
		int choice = sc.nextInt();
		switch (choice) {
			case 1 : 
				System.out.println("THANK YOU FOR USING THE CONSOLE.");
				break;
			case 2:
				System.out.println("-----------2 NUMBERS----------");
				System.out.print("ENTER THE FIRST NUMBER: ");
				double num21 = sc.nextDouble();
				System.out.print("ENTER THE SECOND NUMBER: ");
				double num22 = sc.nextDouble();
				System.out.print("SUM: ");
				System.out.println(add(num21,num22));
				confirm();
				break;
			case 3:
				System.out.println("-----------3 NUMBERS----------");
				System.out.print("ENTER THE FIRST NUMBER: ");
				double num31 = sc.nextDouble();
				System.out.print("ENTER THE SECOND NUMBER: ");
				double num32 = sc.nextDouble();
				System.out.print("ENTER THE THIRD NUMBER: ");
				double num33 = sc.nextDouble();
				System.out.print("SUM: ");
				System.out.println(add(num31,num32,num33));
				confirm();
				break;
			case 4:
				System.out.println("-----------4 NUMBERS----------");
				System.out.print("ENTER THE FIRST NUMBER: ");
				double num41 = sc.nextDouble();
				System.out.print("ENTER THE SECOND NUMBER: ");
				double num42 = sc.nextDouble();
				System.out.print("ENTER THE THIRD NUMBER: ");
				double num43 = sc.nextDouble();
				System.out.print("ENTER THE FOURTH NUMBER: ");
				double num44 = sc.nextDouble();
				System.out.print("SUM: ");
				System.out.println(add(num41,num42,num43,num44));
				confirm();
				break;
			default :
				System.out.println("INVALID INPUT. TRY AGAIN!");
				menu();
		}
	}
	
	void confirm () {
		System.out.println("------------------------------");
		System.out.println("CALCULATION IS DONE!");
		System.out.println("1 - YES\n2 - EXIT");
		System.out.print("DO YOU WANT TO USE THE CONSOLE AGAIN? ");
		int choice = sc.nextInt();
		switch (choice) {
			case 1:
				menu();
				break;
			case 2:
				System.out.println("THANK YOU FOR USING THE CONSOLE.");
				break;
		}
	}
}
