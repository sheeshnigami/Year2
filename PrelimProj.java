import java.util.*;

public class PrelimProj {
    public static Scanner scanner = new Scanner(System.in);

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

        String choice = scanner.nextLine();
        switch (choice) {
            case "a":
                binaryInputValidation();
                break;
            case "b":
                octalInputValidation();
                break;
            case "c":
                decimalInputValidation();
                break;
            case "d":
                hexadecimalInputValidation();    
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

    public static String decimalToBinary(double decimal) {
        String binary = "";
        // Convert the integral part to binary
        int integral = (int) decimal;
        while (integral > 0) {
            binary = (integral % 2) + binary;
            integral /= 2;
        }
        // Convert the fractional part to binary
        double fractional = decimal - (int) decimal;
        if (fractional > 0) {
            binary += ".";
            while (fractional > 0) {
                double product = fractional * 2;
                if (product >= 1) {
                    binary += "1";
                    fractional = product - 1;
                } else {
                    binary += "0";
                    fractional = product;
                }
            }
        }
        return binary;
    }

    public static String decimalToOctal(double decimal) {
        String octal = "";
        // Convert the integral part to octal
        int integral = (int) decimal;
        while (integral > 0) {
            octal = (integral % 8) + octal;
            integral /= 8;
        }
        // Convert the fractional part to octal
        double fractional = decimal - (int) decimal;
        if (fractional > 0) {
            octal += ".";
            for (int i = 0; i < 5; i++) {
                double product = fractional * 8;
                int digit = (int) product;
                octal += digit;
                fractional = product - digit;
            }
        }
        return octal;
    }

    public static String decimalToHexadecimal(double decimal) {
        String hexadecimal = "";
        // Convert the integral part to hexadecimal
        int integral = (int) decimal;
        while (integral > 0) {
            int remainder = integral % 16;
            char hexDigit = (remainder < 10) ? (char) (remainder + '0') : (char) (remainder - 10 + 'A');
            hexadecimal = hexDigit + hexadecimal;
            integral /= 16;
        }
        // Convert the fractional part to hexadecimal
        double fractional = decimal - (int) decimal;
        if (fractional > 0) {
            hexadecimal += ".";
            for (int i = 0; i < 5; i++) {
                double product = fractional * 16;
                int digit = (int) product;
                char hexDigit = (digit < 10) ? (char) (digit + '0') : (char) (digit - 10 + 'A');
                hexadecimal += hexDigit;
                fractional = product - digit;
            }
        }
        return hexadecimal;
    }

    public static void binaryInputValidation() {
        System.out.print("Enter a binary number: ");
        String input = scanner.nextLine();
        boolean valid = true;

        // Check that the input contains only 0s, 1s, and '.' characters
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '0' && c != '1' && c != '.') {
                valid = false;
                break;
            }
        }

        // Check that the input has only one '.' character
        int countDot = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            valid = false;
        }

        if (valid) {
            // Split the input into its integer and fractional parts
            String[] parts = input.split("\\.");
            String integerPart = parts[0];
            String fractionalPart = parts.length > 1 ? parts[1] : "";

            // Check that the integer part contains only 0s and 1s
            for (int i = 0; i < integerPart.length(); i++) {
                char c = integerPart.charAt(i);
                if (c != '0' && c != '1') {
                    valid = false;
                    break;
                }
            }

            // Check that the fractional part contains only 0s and 1s
            for (int i = 0; i < fractionalPart.length(); i++) {
                char c = fractionalPart.charAt(i);
                if (c != '0' && c != '1') {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            double decimal = binaryToDecimal(input);
            String octal = decimalToOctal(decimal);
            String hexadecimal = decimalToHexadecimal(decimal);
            print(input, octal, decimal + "", hexadecimal);
        } else {
            System.out.println("Invalid binary number. Please enter a binary number that contains only 0s, 1s, and decimal digits that are 0 or 1.");
            binaryInputValidation();
        }
    }

    public static void octalInputValidation() {
        System.out.print("Enter an octal number: ");
        String input = scanner.nextLine();
        boolean valid = true;

        // Check that the input contains only 0 to 7 digits and '.' characters
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '.' && (c < '0' || c > '7')) {
                valid = false;
                break;
            }
        }

        // Check that the input has only one '.' character
        int countDot = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            valid = false;
        }

        if (valid) {
            // Split the input into its integer and fractional parts
            String[] parts = input.split("\\.");
            String integerPart = parts[0];
            String fractionalPart = parts.length > 1 ? parts[1] : "";

            // Check that the integer part contains only 0 to 7 digits
            for (int i = 0; i < integerPart.length(); i++) {
                char c = integerPart.charAt(i);
                if (c < '0' || c > '7') {
                    valid = false;
                    break;
                }
            }

            // Check that the fractional part contains only 0 to 7 digits
            for (int i = 0; i < fractionalPart.length(); i++) {
                char c = fractionalPart.charAt(i);
                if (c < '0' || c > '7') {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            double decimal = octalToDecimal(input);
            String binary = decimalToBinary(decimal);
            String hexadecimal = decimalToHexadecimal(decimal);
            print(binary, input, decimal + "", hexadecimal);
        } else {
            System.out.println("Invalid octal number. Please enter an octal number that contains only digits 0 to 7, and a decimal point followed by digits 0 to 7 for the fractional part.");
            octalInputValidation();
        }
    }

    public static void decimalInputValidation() {
        System.out.print("Enter a decimal number: ");
        String input = scanner.nextLine();
        boolean valid = true;

        // Check that the input contains only digits and '.' characters
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '.' && (c < '0' || c > '9')) {
                valid = false;
                break;
            }
        }

        // Check that the input has only one '.' character
        int countDot = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            valid = false;
        }

        if (valid) {
            // Split the input into its integer and fractional parts
            String[] parts = input.split("\\.");
            String integerPart = parts[0];
            String fractionalPart = parts.length > 1 ? parts[1] : "";

            // Check that the integer part contains only digits
            for (int i = 0; i < integerPart.length(); i++) {
                char c = integerPart.charAt(i);
                if (c < '0' || c > '9') {
                    valid = false;
                    break;
                }
            }

            // Check that the fractional part contains only digits
            for (int i = 0; i < fractionalPart.length(); i++) {
                char c = fractionalPart.charAt(i);
                if (c < '0' || c > '9') {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            double decimal = Double.parseDouble(input);
            String binary = decimalToBinary(decimal);
            String octal = decimalToOctal(decimal);
            String hexadecimal = decimalToHexadecimal(decimal);
            print(binary, octal, decimal + "", hexadecimal);
        } else {
            System.out.println("Invalid decimal number. Please enter a decimal number that contains only digits 0 to 9, and a decimal point followed by digits 0 to 9 for the fractional part.");
            decimalInputValidation();
        }
    }

    public static void hexadecimalInputValidation() {
        System.out.print("Enter a hexadecimal number: ");
        String input = scanner.nextLine();
        boolean valid = true;

        // Check that the input contains only hex characters and '.' characters
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '.' && !((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                valid = false;
                break;
            }
        }

        // Check that the input has only one '.' character
        int countDot = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '.') {
                countDot++;
            }
        }
        if (countDot > 1) {
            valid = false;
        }

        if (valid) {
            // Split the input into its integer and fractional parts
            String[] parts = input.split("\\.");
            String integerPart = parts[0];
            String fractionalPart = parts.length > 1 ? parts[1] : "";

            // Check that the integer part contains only hex characters
            for (int i = 0; i < integerPart.length(); i++) {
                char c = integerPart.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                    valid = false;
                    break;
                }
            }

            // Check that the fractional part contains only hex characters
            for (int i = 0; i < fractionalPart.length(); i++) {
                char c = fractionalPart.charAt(i);
                if (!((c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f'))) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            double decimal = hexadecimalToDecimal(input);
            String binary = decimalToBinary(decimal);
            String octal = decimalToOctal(decimal);
            print(binary, octal, decimal + "", input);
        } else {
            System.out.println("Invalid hexadecimal number. Please enter a hexadecimal number that contains only digits 0 to 9 and letters A to F, and a decimal point followed by digits 0 to 9 and letters A to F for the fractional part.");
            hexadecimalInputValidation();
        }
    }
    
    public static void print(String binary, String octal, String decimal, String hexadecimal) {
        System.out.println("Binary: " + binary);
        System.out.println("Octal: " +  octal);
        System.out.println("Decimal: " + decimal);
        System.out.println("Hexadecimal: " + hexadecimal);
    }
}
