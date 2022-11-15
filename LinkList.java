package codes;
import java.util.*;

public class LinkList {
	static Scanner sc = new Scanner(System.in);
	static LinkedList <String> elements = new LinkedList<String>();

	public static void main(String[] args) {
		System.out.print("Enter the number of elements: ");
		String sizeString = sc.nextLine();
		 
		
		System.out.println("----------------------------------------");
		int size = Integer.parseInt(sizeString);
		for (int x  = 0; x < size; x++) {
			System.out.print("Enter element " + x + ": ");
			String input = sc.nextLine();
			elements.add(input);
		}
		print(size);
	}
	
	public static void print(int size) {
		System.out.println("----------------------------------------");
		for (int x = 0; x < size; x++) {
			System.out.print("Element " + x + ": ");
			System.out.println(elements.get(x));
		}
		menu(size);
	}
		
	public static void menu(int size) {
		System.out.println("----------------------------------------");
		System.out.println("1 - Delete\n2 - Insert\n3 - Exit");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			delete(size);
			break;
		case 2:
			insert(size);
			break;
		case 3:
			System.out.println("Arigathanks!");
			break;
		default:
			System.out.println("Invalid input. Try again.");
			menu(size);
		}
	}
	
	public static void delete(int size) {
		System.out.println("----------------------------------------");
		System.out.print("Enter the index of the element you want to remove: ");
		int x = sc.nextInt();
		elements.remove(x);
		print(size-1);
	}
	
	public static void insert(int size) {
		System.out.println("----------------------------------------");
		System.out.print("Enter the index of the element you want to insert to: ");
		int x = sc.nextInt();
		String z = sc.nextLine();
		System.out.print("Enter the new element : ");
		String y = sc.nextLine();
		elements.add(x,y);
		print(size+1);
	}

}
