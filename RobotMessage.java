package Nani;
import java.util.*;

public class RobotMessage {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Menu();
	}
	
	public static void Menu() {
		System.out.println("---------------ROBOT---------------");
		System.out.println("Choose an action for the robot: ");
		System.out.println("1 - Forward");
		System.out.println("2 - Stop");
		String choice = sc.nextLine().trim();
		
		if (choice.equals("1")) {
			int x = 1; 
			Travel(x++);
			Menu();
			//Travel();
		} else if (choice.equals("2")) {
			Stop();
		} else {
			System.out.println("Invalid input!");
			Menu();
		}
	}
	
	public static void Travel(int n) {
		System.out.println("The robot is moving forward.");
	}
	
	public static void Travel() {
		for (int x = 0; x <= x++; x++) {
		System.out.println("The robot is moving forward.");
		}
	}
	
	public static void Stop() {
		System.out.println("The robot stopped moving.");
	}

}
