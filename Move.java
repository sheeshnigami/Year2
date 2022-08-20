package Nani;
import java.util.*;

public class Move {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Robot robot = new Robot();
		String input = "";
		
		while (input.isEmpty()) {
			robot.travel();
			input = sc.nextLine();
		}
		robot.travel(0);
		sc.close();
	}
}
	
	class Robot {
		public void travel(int in) {
			System.exit(in);
		}
		
		public void travel() {
			System.out.print("The robot has moved forward");
		}
	}
