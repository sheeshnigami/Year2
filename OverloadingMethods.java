package codes;
import java.util.*;

public class OverloadingMethods {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Menu();
	}
	
	public static void Menu() {
		System.out.println("----------------CHOOSE FROM THE FOLLOWING----------------");
		System.out.println("1 - Name");
		System.out.println("2 - First Name and Last Name");
		System.out.println("3 - Full Name");
		
		System.out.println("Enter the selected number: ");
		String choice = sc.nextLine().trim();
		
		if (choice.equals("1")) {
			System.out.print("Enter Name: ");
			String x = sc.nextLine();
			
			String Name = Name(x);
			System.out.println();
			System.out.println("Name: " + Name);
			System.out.println();
			Menu();
		} else if (choice.equals("2")) {
			System.out.print("Enter First Name: ");
			String x = sc.nextLine();
			System.out.print("Enter Last Name: ");
			String y = sc.nextLine();
			
			String Name = Name(x,y);
			System.out.println();
			System.out.println("Name: " + Name);
			System.out.println();
			Menu();
		} else if (choice.equals("3")) {
			System.out.print("Enter First Name: ");
			String x = sc.nextLine();
			System.out.print("Enter Middle Name: ");
			String y = sc.nextLine();
			System.out.print("Enter Last Name: ");
			String z = sc.nextLine();
		
			String Name = Name(x,y,z);
			System.out.println();
			System.out.println("Name: " + Name);
			System.out.println();
			Menu();
		} else {
			System.out.println("Try again!");
			Menu();
		}
	}
	
	public static String Name(String Name) {
		
		return Name;
	}
	
	public static String Name(String FirstName, String LastName) {
		String FullName = (FirstName + " " + LastName);
		
		return FullName;
	}
	
	public static String Name(String FirstName, String MiddleName, String LastName) {
		String FullName = (FirstName + " " + MiddleName + " " + LastName);
		
		return FullName;
	}
	
}
