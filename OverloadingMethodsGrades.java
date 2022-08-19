package codes;
import java.util.*;

public class OverloadingMethodsGrades {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Grades Computation: ");
		System.out.print("Quiz: ");
		double Quiz = sc.nextDouble();
		System.out.print("Project: ");
		double Project = sc.nextDouble();
		System.out.print("Final Exam: ");
		double FinalExam = sc.nextDouble();
		
		System.out.println();
		
		Double Grades = Grades(Quiz, Project, FinalExam);
		System.out.println("Average: " + Grades);
		
		String Letter = Grades(Grades);
		System.out.println("Grade: " + Letter);
	}
	
	public static double Grades(double Quiz, double Project, double FinalExam) {
		double Average = (Quiz + Project + FinalExam) / 3;
		
		return Average;
	}
	
	public static String Grades(double Average) {
		if (Average >= 100) {
			String x = "Over?";
			return x;
		} else if (Average >= 95) {
			String x = "A+";
			return x;
		} else if (Average >= 90) {
			String x = "A";
			return x;
		} else if (Average >= 85) {
			String x = "B";
			return x;
		} else if (Average >= 80) {
			String x = "C";
			return x;
		} else if (Average >= 75) {
			String x = "D";
			return x;
		} else if (Average >= 70) {
			String x = "E";
			return x;
		} else {
			String x = "Failed!";
			return x;
		}
		
	}

}
