import java.io.*;

public class Serializer {
    public static void serializeToFile(InsuranceObligation[] derivative) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("derivativeSerialized1.out"));
        for (InsuranceObligation insuranceObligation : derivative) {
            objectOutputStream.writeObject(insuranceObligation);
        }
        objectOutputStream.close();
    }

    public static InsuranceObligation[] getSerializedFromFile(int length) throws IOException, ClassNotFoundException {
        InsuranceObligation[] derivative = new InsuranceObligation[length];
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("derivativeSerialized1.out"));
        for (int i = 1; i < derivative.length; i++) {
            derivative[i] = (InsuranceObligation) objectInputStream.readObject();
            System.out.println(derivative[i]);
            System.out.println("FINISHED");

        }
        objectInputStream.close();
        return derivative;
    }

}
