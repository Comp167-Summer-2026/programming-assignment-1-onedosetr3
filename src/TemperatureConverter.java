import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        if (unit.toUpperCase().equals("C")) {
            return (temperature * 9 / 5) + 32;
        } else {
            return (temperature - 32) * 5 / 9;
        }
    }

    public static boolean isValidNumber(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }

        text = text.trim();
        int start = 0;
        boolean hasDigit = false;
        boolean hasDecimal = false;

        if (text.charAt(0) == '-') {
            if (text.length() == 1) {
                return false;
            }
            start = 1;
        }

        for (int i = start; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if (ch == '.') {
                if (hasDecimal) {
                    return false;
                }
                hasDecimal = true;
            } else {
                return false;
            }
        }

        return hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Scanner Variable
        boolean running = true; //Running Variable

        //While Loop. MOST IMPORTANT
        while (running) {
            System.out.print("Enter a temperature value or type \"stop\" to quit: "); //Initial Message
            String tempInput = scanner.nextLine(); //Record User input

            if (tempInput.toLowerCase().equals("stop")) { //If User inputs stop.
                running = false;
            } else if (!isValidNumber(tempInput)) { //If not a valid number. The need to try again
                System.out.println("Invalid temperature input. Please enter a numeric value.");
            } else {
                double temperature = Double.parseDouble(tempInput); //If a valid number is inputted then we do this.

                System.out.print("Enter the unit (C or F): "); //Ask user to input number
                String unit = scanner.nextLine();

                if (unit.toUpperCase().equals("C") || unit.toUpperCase().equals("F")) {
                    double convertedTemperature = convertTemperature(temperature, unit);

                    if (unit.toUpperCase().equals("C")) {
                        System.out.printf("%.2f°C is equal to %.2f°F%n", temperature, convertedTemperature);
                    } else {
                        System.out.printf("%.2f°F is equal to %.2f°C%n", temperature, convertedTemperature);
                    }
                } else {
                    System.out.println("Invalid unit. Please enter C or F.");
                }
            }
        }

        scanner.close();
    }
}