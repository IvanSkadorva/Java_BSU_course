import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private static final int MAX_STRING_LENGTH = 100;

    public static String readFromFile() {
        try {
            File file = new File("breed.txt");
            if (file.length() == 0) {
                System.out.println("File is empty ...");
                throw new RuntimeException("cannot take in an empty String or null value for the constructor");

            }
                Scanner reader = new Scanner(file);
                String breed = reader.nextLine();
            if(breed.length()>MAX_STRING_LENGTH)
                throw new StringTooLongException();
                reader.close();
                return breed;
            } catch(FileNotFoundException | StringTooLongException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return "Empty";
        }

        public static void writeToFile (BroodHen broodHen) throws IOException {
            try {
                PrintWriter out = new PrintWriter("output.txt");
                out.println(broodHen.toString());
                out.close();
            } catch (OutOfMemoryError e) {
                System.out.println("There is not enough memory.");
                e.printStackTrace();
            }
        }

        /**
         * @author Ivan Skadorva.
         * Условие: Создать объект класса Наседка, используя классы Птица, Воробей.
         * Методы: летать, петь, нести яйца, высиживать птенцов.
         */
        public static void main (String[]args) throws IOException {
            // Born a broodHen
            BroodHen someBroodHen = new BroodHen("Sparrow");

            System.out.println("A: Create a brood hen form a file");
            System.out.println("B: Create a brood hen automatically without files");
            System.out.println("Q: Quit");
            String creationChoice = "";
            while (!creationChoice.equals("Q")) {
                System.out.println("Select something: ");
                Scanner scan = new Scanner(System.in);
                creationChoice = scan.nextLine();
                switch (creationChoice) {
                    case "A" -> someBroodHen = new BroodHen(readFromFile());
                    case "B" -> someBroodHen = new BroodHen("Sparrow");
                }
            }


            System.out.println("A: Lay some eggs");
            System.out.println("B: Hatch some eggs");
            System.out.println("C: Let's try to fly");
            System.out.println("D: Let's try to sing");
            System.out.println("E: Print all info about a bird to a file");
            System.out.println("Q: Quit");

            String choice = "";
            while (!choice.equals("Q")) {
                System.out.println("Select something: ");
                Scanner scan = new Scanner(System.in);
                choice = scan.nextLine();
                switch (choice) {
                    case "A" -> someBroodHen.layEggs();
                    case "B" -> someBroodHen.hatchEggs();
                    case "C" -> someBroodHen.fly();
                    case "D" -> someBroodHen.sing();
                    case "E" -> writeToFile(someBroodHen);
                }
            }
            System.out.println("See you soon!");


            // Testing
            // Equal
            BroodHen someBroodHen2 = new BroodHen("Sparrow");
            if (someBroodHen.equals(someBroodHen2)) {
                System.out.println("someBroodHen and someBroodHen are equal");
            }

            //Hash code
            Bird bird = new Bird("Eagle");
            System.out.println("Hash code of an eagle is: " + bird.hashCode());

            //To string
            Bird sparrow = new Sparrow("Sparrow");
            System.out.println("Information about the sparrow: " + sparrow.toString());

        }
    }

class StringTooLongException extends Exception {
    public StringTooLongException()
    {
        super("\nString has too many characters\n\nPlease try again:\n");
    }
}