import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static Double[] readFromFile() {
        int MAX_NUM_VALUE = 100000;
        int MIN_NUM_VALUE = 100000;
        NumberFormat numberFormat;
        try {
            File file = new File("input.txt");
            Double[] numbers = new Double[3];
            if (file.length() == 0) {
                System.out.println("File is empty ...");
                throw new RuntimeException("cannot take in an empty String or null value for the constructor");
            }
            Scanner reader = new Scanner(file);
            for (int i = 0; i < 3; i++) {
               String[] input = reader.nextLine().split(" ");
                if (input.length > 2) {
                    throw new StringTooLongException();
                }
                if (input.length == 1) {
                    numberFormat = NumberFormat.getInstance();
                } else {
                    numberFormat = NumberFormat.getInstance(Locale.forLanguageTag(input[1]));
                }
                double currentNumber = Double.parseDouble(input[0]);
                if (isNumeric(input[0]) || (currentNumber > MIN_NUM_VALUE && currentNumber < MAX_NUM_VALUE)) {
                    System.out.println(numberFormat.format(currentNumber));
                    String num = numberFormat.format(currentNumber);
                    numbers[i] = numberFormat.parse(num).doubleValue();
                } else {
                    throw new RuntimeException("Invalid type");
                }
            }
            reader.close();
            return numbers;
        } catch (FileNotFoundException | StringTooLongException | OutOfMemoryError | ParseException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new Double[0];
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Double[] numbers = readFromFile();
        Double sum = countSum(numbers);
        Double avg = countAverageValue(numbers);
        System.out.println("sum is:" + sum + ", avg is:" + avg);

    }

    private static Double countAverageValue(Double[] numbers) {
        Double avg = 0.0;
        for (Double number : numbers) {
            avg += number;
        }
        avg /= numbers.length;
        return avg;
    }

    private static Double countSum(Double[] numbers) {
        Double sum = 0.0;
        for (Double number : numbers) {
            sum += number;
        }
        return sum;
    }
}

class StringTooLongException extends Exception {
    public StringTooLongException() {
        super("\nString has too many characters\n\nPlease try again:\n");
    }
}