import java.util.Scanner;

public class Main {

    /**
     * @author Ivan Skadorva.
     * Условие: Создать объект класса Наседка, используя классы Птица, Воробей.
     * Методы: летать, петь, нести яйца, высиживать птенцов.
     */
    public static void main(String[] args) {
        // Born a broodHen
        System.out.println("A brood hen has created");
        BroodHen someBroodHen = new BroodHen("Sparrow");
        // Print current state of a brood hen
        System.out.println(someBroodHen.toString());

        System.out.println("A: Lay some eggs");
        System.out.println("B: Hatch some eggs");
        System.out.println("C: Let's try to fly");
        System.out.println("D: Let's try to sing");
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
            }
        }
        System.out.println("See you soon!");


        // Testing
        // Equal
        BroodHen someBroodHen2 = new BroodHen("Sparrow");
        if (someBroodHen.equals(someBroodHen2)){
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
