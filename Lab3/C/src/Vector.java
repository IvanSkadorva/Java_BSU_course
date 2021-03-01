import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.*;

public class Vector {
    double x;
    double y;
    double z;

    Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Vector() {
        System.out.println("Input x, y, z separated by space: ");
        Scanner scanner = new Scanner(System.in);
        List<Double> doubleList = new ArrayList<>();
        String[] strNums = null;
        if (scanner.hasNextLine()) {
            strNums = scanner.nextLine().split(" ");
        }
        if (strNums != null) {
            for (String strNum : strNums) {
                try {
                    var num = Double.parseDouble(strNum.trim());
                    doubleList.add(num);
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    break;
                }
            }
            double[] nums = convertDoubles(doubleList);
            this.x = nums[0];
            this.y = nums[1];
            this.z = nums[2];
        }
    }

    public static double[] convertDoubles(List<Double> doubles) {
        double[] result = new double[doubles.size()];
        for (int i = 0; i < doubles.size(); i++) {
            result[i] = doubles.get(i);
        }
        return result;
    }

    double angleBetweenVectors(Vector v2) {
        return toDegrees(atan2(this.z, this.y) - atan2(v2.z, v2.y));
    }

    int getIndex(double number) {
        if (this.x == number) return 0;
        if (this.y == number) return 1;
        if (this.z == number) return 2;
        return 0;
    }


    double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }


    Vector scale(double a) {
        return new Vector(x * a, y * a, z * a);
    }

    Vector norm() {
        double b = 1 / length();
        return new Vector(x * b, y * b, z * b);
    }

    Vector add(Vector v2) {
        return new Vector(this.x + v2.x, this.y + v2.y, this.z + v2.z);
    }

    Vector sub(Vector v2) {
        return new Vector(this.x - v2.x, this.y - v2.y, this.z - v2.z);
    }

    Vector crossProduct(Vector v2) {
        return new Vector(this.x * v2.y - this.y * v2.x, this.x * v2.z - this.z * v2.x, this.y * v2.z - this.z * v2.y);
    }

    double scalarProduct(Vector v2) {
        return this.x * v2.x + this.y * v2.y + this.z * v2.z;
    }

    Vector increment() {
        return new Vector(this.x + 1, this.y + 1, this.z + 1);
    }

    Vector decrement() {
        return new Vector(this.x - 1, this.y - 1, this.z - 1);
    }


    @Override
    public String toString() {
        return "( " + x + ", " + y + ", " + z + " )";
    }

}
