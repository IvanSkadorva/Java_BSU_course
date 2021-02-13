import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * @author Ivan Skadorva
     * @since 2021-02-12 until 2021-02-13
     */
    static void reverse(int[] a, int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

        System.out.println("Reversed array is: \n");
        for (int k = 0; k < n; k++) {
            System.out.println(b[k]);
        }
    }
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the integers separated by a space: ");
        String[] strNums = null;
        if (scanner.hasNextLine()) {
            strNums = scanner.nextLine().split(" ");
        }
        if (strNums != null) {
            for (String strNum : strNums) {
                try {
                    var num = Integer.parseInt(strNum.trim());
                    intList.add(num);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    break;
                }
            }
            System.out.println("Reversed array: " + intList);
            int[] nums = convertIntegers(intList);
            reverse(nums, nums.length);

        }
    }
}
