import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void testFunctionality(RationalFraction frc, RationalFraction frc1) {
        System.out.println("\n\n\n\nYour first fraction " + frc);
        System.out.println("Your second fraction: " + frc1);
        RationalFraction add1 = frc.add(frc1);
        System.out.println("\nAdding     \t" + frc + " + " + frc1 + " = " + add1);
        RationalFraction sub1 = frc.sub(frc1);
        System.out.println("\nSubtracting\t" + frc + " - " + frc1 + " = " + sub1);
        RationalFraction mul1 = frc.mul(frc1);
        System.out.println("\nMultiplying\t" + frc + " * " + frc1 + " = " + mul1);
        RationalFraction dv1 = frc.div(frc1);
        System.out.println("\nDividing   \t" + frc + " / " + frc1 + " = " + dv1);
        System.out.println("\n\nComparing those two fraction");
        boolean less1 = frc.lessThan(frc1);
        System.out.println("\nif " + frc + " is less than    " + frc1 + " = " + less1);
        boolean eq1 = frc.equals(frc1);
        System.out.println("\nif " + frc + " is equal to     " + frc1 + " = " + eq1 + "\n");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            System.out.print("""
                    Please enter two fractions as following format: 3/4\s
                    or Q to finish program\s

                    Enter first fraction:\s""");
            String str = in.nextLine();
            if (str.equals("Q")) {
                cont = false;
                System.out.println("\nGood bay ");
                in.close();
            } else {
                RationalFraction frc = new RationalFraction(str);
                System.out.println();
                System.out.print("Please enter second fraction: ");
                String str1 = in.nextLine();
                RationalFraction frc1 = new RationalFraction(str1);
                testFunctionality(frc, frc1);
            }
        }
        RationalFraction[] fractionsArray = {new RationalFraction(3, 4), new RationalFraction(2, 5), new RationalFraction(7, 33), new RationalFraction(2, 23)};
        System.out.println("Initial array of fractions: " + Arrays.toString(fractionsArray));
        RationalFraction[] affectedArray = addNextNumberToEvenFraction(fractionsArray);
        System.out.println("Affected array of fractions: " + Arrays.toString(affectedArray));
    }

    private static RationalFraction[] addNextNumberToEvenFraction(RationalFraction[] fractionsArray) {
        for (int i =0; i < fractionsArray.length; i++) {
            if (i % 2 == 1) {
                RationalFraction addedValue = fractionsArray[i].addNextNumber();;
                fractionsArray[i] = addedValue;
            }
        }
        return fractionsArray;
    }
}
