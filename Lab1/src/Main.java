import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the integers separated by a space: ");
        String[] strNums = null;
        if (scanner.hasNextLine()) {
            strNums = scanner.nextLine().split(" ");
        }
        if (strNums != null) {
            for (String strNum : strNums) {
                try {
                    var num = Integer.parseInt(strNum.trim());
                    if (num == 7 || num == 3 || num == 13) {
                        intList.add(num);
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input");
                    break;
                }
            }
            System.out.println("Lucky numbers: " + intList);
        }
    }
}
