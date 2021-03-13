import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int MAX_STRING_LENGTH = 100;

    public static InsuranceObligation[] readFromFile(InsuranceObligation[] derivative) {
        try {
            File file = new File("derivative.txt");
            if (file.length() == 0) {
                System.out.println("File is empty ...");
                throw new RuntimeException("cannot take in an empty String or null value for the constructor");
            }
            Scanner reader = new Scanner(file);
            for (int i = 0; i < derivative.length; i++) {
                String[] input = reader.nextLine().split(" ");
                if (input.length > 3) {
                    throw new StringTooLongException();
                }
                derivative[i] = new InsuranceObligation(Double.parseDouble(input[0]), Integer.parseInt(input[1]), input[2]);
            }
            reader.close();
        } catch (FileNotFoundException | StringTooLongException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return derivative;
    }

    public static void writeToFile(InsuranceObligation[] derivative) throws IOException {
        try {
            PrintWriter out = new PrintWriter("output.txt");
            for (InsuranceObligation obligation : derivative) {
                out.println(obligation.toString());

            }
            out.close();
        } catch (OutOfMemoryError e) {
            System.out.println("There is not enough memory.");
            e.printStackTrace();
        }
    }

    public static InsuranceObligation[] createDerivative(InsuranceObligation[] derivative) {
        for (int i = 0; i < derivative.length; i++) {
            derivative[i] = new InsuranceObligation();
        }
        return derivative;
    }


    /**
     * @author Ivan Skadorva.
     * Страхование. Определить иерархию страховых обязательств. Собрать из обязательств дериватив.
     * Подсчитать стоимость. Провести сортировку обязательств в деривативе на основе уменьшения степени риска.
     * Найти обязательство в деривативе, соответствующее заданному диапазону параметров.
     */
    public static void main(String[] args) throws IOException {
        HealthInsuranceObligation health = new HealthInsuranceObligation(23, 4);
        CommonInsuranceObligation common = new CommonInsuranceObligation(54, 8);

        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of obligations: ");
        int number = in.nextInt();
        InsuranceObligation[] derivative = new InsuranceObligation[number];
        System.out.println("A: Create a derivative form a file");
        System.out.println("B: Create a derivative manually");
        System.out.println("Q: Quit");
        String creationChoice = "";
        while (!creationChoice.equals("Q")) {
            System.out.println("Select something: ");
            Scanner scan = new Scanner(System.in);
            creationChoice = scan.nextLine();
            switch (creationChoice) {
                case "A" -> derivative = readFromFile(derivative);
                case "B" -> derivative = createDerivative(derivative);
            }
        }
        System.out.println("A: Count cost of a derivative");
        System.out.println("B: Sort a derivative by risk degree ");
        System.out.println("C: Find a derivative by risk degree ");
        System.out.println("D: Find a derivative by cost ");
        System.out.println("E: Find a derivative by insurance subject ");
        System.out.println("F: Get information about health insurance ");
        System.out.println("G: Get information common health insurance ");
        System.out.println("H: Print all info about a derivative to a file");

        System.out.println("Q: Quit");

        String choice = "";
        while (!choice.equals("Q")) {
            System.out.println("Select something: ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();
            switch (choice) {
                case "A" -> System.out.println("Cost is: " + countCost(derivative));
                case "B" -> System.out.println("Sorted derivative is: " + Arrays.toString(sortByRisk(derivative)));
                case "C" -> findByRiskDegree(derivative);
                case "D" -> findByCost(derivative);
                case "E" -> findByInsuranceSubject(derivative);
                case "F" -> health.getInformationAboutObligation();
                case "G" -> common.getInformationAboutObligation();
                case "H" -> writeToFile(derivative);


            }
        }
        System.out.println("See you soon!");

    }

    static double countCost(InsuranceObligation[] obligations) {
        double cost = 0.0;
        for (InsuranceObligation obligation : obligations) {
            cost += obligation.cost;
        }
        return cost;
    }

    static InsuranceObligation[] sortByRisk(InsuranceObligation[] obligations) {
        int max = obligations[0].riskDegree;
        for (int i = 1; i < obligations.length; i++) {
            if (obligations[i].riskDegree > max) {
                max = obligations[i].riskDegree;
                InsuranceObligation tmp = obligations[i - 1];
                obligations[i - 1] = obligations[i];
                obligations[i] = tmp;
            }
        }
        return obligations;
    }

    static void findByRiskDegree(InsuranceObligation[] obligations) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter risk degree: ");
        int riskDegree = in.nextInt();
        List<InsuranceObligation> result = new ArrayList<>();
        for (int i = 1; i < obligations.length; i++) {
            if (obligations[i].riskDegree == riskDegree) {
                result.add(obligations[i]);

            }
        }
        if (!result.isEmpty()) {
            System.out.println("Found insurance obligations are: " + Arrays.toString(result.toArray()));
        } else System.out.println("There is no such obligation");
    }

    static void findByCost(InsuranceObligation[] obligations) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter cost: ");
        int cost = in.nextInt();
        List<InsuranceObligation> result = new ArrayList<>();
        for (int i = 1; i < obligations.length; i++) {
            if (obligations[i].cost == cost) {
                result.add(obligations[i]);
            }
        }
        if (!result.isEmpty()) {
            System.out.println("Found insurance obligations are: " + Arrays.toString(result.toArray()));
        } else System.out.println("There is no such obligation");
    }

    static void findByInsuranceSubject(InsuranceObligation[] obligations) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an insurance subject: ");
        String insuranceSubject = in.nextLine();
        List<InsuranceObligation> result = new ArrayList<>();
        for (int i = 1; i < obligations.length; i++) {
            if (obligations[i].insuranceSubject.equals(insuranceSubject)) {
                result.add(obligations[i]);
            }
        }
        if (!result.isEmpty()) {
            System.out.println("Found insurance obligations are: " + Arrays.toString(result.toArray()));
        } else System.out.println("There is no such obligation");
    }
}

class StringTooLongException extends Exception {
    public StringTooLongException() {
        super("\nString has too many characters\n\nPlease try again:\n");
    }
}