import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Vector vector = new Vector(5.0, 6.0, 8.0);
        double l = vector.length();
        Vector v3 = vector.scale(2.0);
        Vector v4 = vector.add(vector.norm());
        Vector v5 = vector.crossProduct(new Vector(7, 9.55, 6.88));
        System.out.println(l);
        System.out.println(v3);
        System.out.println(v4);
        System.out.println(v5);
        Scanner in = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            System.out.print("""
                    Please enter number of vectors for an array\s
                    or press Q to finish program\s
                    """);
            String str = in.nextLine();
            if (str.equals("Q")) {
                cont = false;
                System.out.println("\nGood bay ");
                in.close();
            } else {
               int length =  Integer.parseInt(str);
                Vector[] vectors = new Vector[length];
                for (int i = 0; i < length; i++){
                   Vector vec = new Vector();
                   vectors[i] = vec;
               }
                testFunctionality(vectors);
            }
        }
    }

    private static void testFunctionality(Vector[] vectors) {
        for(int i=0; i<vectors.length; i+=2) {
            System.out.println("Length of vector " + i +" : " + vectors[i].length());
            System.out.println("Length of vector " + (i+1) +" : " + vectors[i+1].length());
            System.out.println(" Scalar product of vector [" + i +"] and [" +(i+1) + "] : " + vectors[i].scalarProduct(vectors[i+1]));
            System.out.println(" An angle between vector [" + i +"] and [" +(i+1) + "] : " + vectors[i].angleBetweenVectors(vectors[i+1]));


        }
    }
}
