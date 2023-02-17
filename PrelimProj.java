import java.util.*;

public class PrelimProj {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
         menu();
    }

    public static void menu() {
        System.out.println("----------Select from the choices----------");
        System.out.println("a - binary to other number systems");
        System.out.println("b - octal to other number systems");
        System.out.println("c - decimal to other number systems");
        System.out.println("d - hexadecimal to other number systems");
        System.out.println("e - exit");

        String choice = input.nextLine();
        switch (choice) {
            case "a":
                
                break;
            case "b":
                
                break;
            case "c":
                
                break;
            case "d":
                    
                break;
            case "e":
                System.out.println("Thank you for using this program!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input! Try again.");
                menu();
                break;
        }
    }

    public static double binaryToDecimal(String binary) {
        String [] parts = binary.split("\\.");
        String integral = parts[0];
        String fractional = parts[1];

        // convert integral part to decimal
        double integralDecimal = 0;
        for (int i = 0; i < integral.length(); i++) {
            int digit = Character.getNumericValue(integral.charAt(i));
            integralDecimal += digit * Math.pow(2, integral.length() - i - 1);
        }
        // convert fractional part to decimal
        double fractionalDecimal = 0;
        for (int i = 0; i < fractional.length(); i++) {
            int digit = Character.getNumericValue(fractional.charAt(i));
            fractionalDecimal += digit * Math.pow(2, -(i + 1));
        }
        // return the sum of the integral and fractional parts
        return integralDecimal + fractionalDecimal;
    }

    public static double octalToDecimal(String octal) {
        String[] parts = octal.split("\\.");
        String integral = parts[0];
        String fractional = parts[1];

        // convert integral part to decimal
        int integralDecimal = 0;
        int power = 0;
        for (int i = integral.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(integral.charAt(i));
            integralDecimal += digit * Math.pow(8, power);
            power++;
        }
        // convert fractional part to decimal
        double fractionalDecimal = 0;
        power = -1;
        for (int i = 0; i < fractional.length(); i++) {
            int digit = Character.getNumericValue(fractional.charAt(i));
            fractionalDecimal += digit * Math.pow(8, power);
            power--;
        }
        // return the sum of the integral and fractional parts
        return integralDecimal + fractionalDecimal;
    }
    
    public static double hexadecimalToDecimal(String hexadecimal) {
        String[] parts = hexadecimal.split("\\.");
        String integral = parts[0];
        String fractional = parts[1];
        // convert integral part to decimal
        int integralDecimal = 0;
        int power = 0;
        for (int i = integral.length() - 1; i >= 0; i--) {
            char digit = integral.charAt(i);
            int digitValue = Character.digit(digit, 16);
            integralDecimal += digitValue * Math.pow(16, power);
            power++;
        }
        // convert fractional part to decimal
        double fractionalDecimal = 0;
        power = -1;
        for (int i = 0; i < fractional.length(); i++) {
            char digit = fractional.charAt(i);
            int digitValue = Character.digit(digit, 16);
            fractionalDecimal += digitValue * Math.pow(16, power);
            power--;
        }
        // return the sum of the integral and fractional parts
        return integralDecimal + fractionalDecimal;
    }

    public static void print() {
        System.out.println("Binary: ");
        System.out.println("Octal: ");
        System.out.println("Decimal: ");
        System.out.println("Hexadecimal: ");
    }
}