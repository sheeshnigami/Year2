package codes;
import java.util.*;

public class RobotMove{
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("------------Welcome, Robot-des!------------");
		System.out.println("Press 'Enter' to move forward.");
		System.out.println("Press 'f' to move 10 steps forward.");
		System.out.println("Press 'w' to move north.");
		System.out.println("Press 'a' to move west.");
		System.out.println("Press 's' to move south.");
		System.out.println("Press 'd' to move east.");
		System.out.println("-------------------------------------------");
			Move();
			sc.close();
	}
	
	public static void Move() {
		Robot robot = new Robot();	
		String input = sc.nextLine().trim();
		if (input.isEmpty()) {
			robot.travel();
			Move();
		} else if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
			robot.direction(input);
			Move(input);
		} else if (input.equals("f")) {
			int i = 0;
			while (i < 10) {
				  robot.travel();
				  System.out.println();
				  i++;
			}
			Move();
		} else {
			robot.travel(0);
		}
	}
	
	public static void Move(String letter) {
		Robot robot = new Robot();	
		String input = sc.nextLine().trim();
		if (letter.equals("w")) {
				if (input.isEmpty()) {
				robot.travel();
				Move();
			} else if (input.equals("w") || input.equals("a")|| input.equals("d")) {
				robot.direction(input);
				Move(input);
			} else if (input.equals("s")) {
				System.out.println("The robot can't move from north to south direction.");
				Move(input);
			} else if (input.equals("f")) {
				int i = 0;
				while (i < 10) {
					  robot.travel();
					  System.out.println();
					  i++;
				}
				Move();
			} else {
				robot.travel(0);
			}
		} else if (letter.equals("a")) {
			if (input.isEmpty()) {
				robot.travel();
				Move();
			} else if (input.equals("w") || input.equals("a")|| input.equals("s")) {
				robot.direction(input);
				Move(input);
			} else if (input.equals("d")) {
				System.out.println("The robot can't move from west to east direction.");
				Move(input);
			} else if (input.equals("f")) {
				int i = 0;
				while (i < 10) {
					  robot.travel();
					  System.out.println();
					  i++;
				}
				Move();
			} else {
				robot.travel(0);
			} 
		} else if (letter.equals("s")) {
			if (input.isEmpty()) {
				robot.travel();
				Move();
			} else if (input.equals("d") || input.equals("a")|| input.equals("s")) {
				robot.direction(input);
				Move(input);
			} else if (input.equals("w")) {
				System.out.println("The robot can't move from south to north direction.");
				Move(input);
			} else if (input.equals("f")) {
				int i = 0;
				while (i < 10) {
					  robot.travel();
					  System.out.println();
					  i++;
				}
				Move();
			} else {
				robot.travel(0);
			} 
		} else if (letter.equals("d")) {
			if (input.isEmpty()) {
				robot.travel();
				Move();
			} else if (input.equals("w") || input.equals("d")|| input.equals("s")) {
				robot.direction(input);
				Move(input);
			} else if (input.equals("a")) {
				System.out.println("The robot can't move from east to west direction.");
				Move(input);
			} else if (input.equals("f")) {
				int i = 0;
				while (i < 10) {
					  robot.travel();
					  System.out.println();
					  i++;
				}
				Move();
			} else {
				robot.travel(0);
			} 
		}
	}
}
	
	class Robot {
		public void travel(int in) {
			System.out.print("The robot found an obstacle and stopped moving");
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