package Shinigami;
import java.util.*;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------Welcome, Robot-des!---------");
		System.out.println("Press 'Enter' to move forward.");
		System.out.println("Press 'w' to move north.");
		System.out.println("Press 'a' to move west.");
		System.out.println("Press 's' to move south.");
		System.out.println("Press 'd' to move east.");
		System.out.println("-------------------------------------");
		String input = sc.nextLine().trim();
		Move(input);
		sc.close();
	}
	
	public static void Move(String input) {
		Robot robot = new Robot();
		
		if (input.isEmpty()) {
			robot.travel();
			Move(input);
		} else if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
			robot.direction(input);
			Move(input);
		} else {
		robot.travel(0);
		}
	}
}
	
	class Robot {
		public void travel(int in) {
			System.out.print("The robot has stopped moving");
			System.exit(in);
		}
		
		public void travel() {
			System.out.print("The robot has moved forward");
		}
		
		public String direction (String in) {
			switch(in) {
			  case "w":
				  System.out.print("The robot has moved in the north direction");
				  return in;
			  case "a":
				  System.out.print("The robot has moved in the west direction");
				  return in;
			  case "s":
				  System.out.print("The robot has moved in the south direction");
				  return in;
			  case "d":
				  System.out.print("The robot has moved in the east direction");
				  return in;
			}
			return in;
		}
	}