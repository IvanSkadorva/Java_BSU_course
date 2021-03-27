@FunctionalInterface
interface Changeable{
    public String change(String someLine, int copies, int maxLength);
}


public class Main {


    public static void main(String[] args) {
        String someLine1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ";
        int copies1 = 4;
        int maxLength1 = 45;
        Changeable changeable = (someLine, copies, maxLength) -> someLine.replaceAll("([^ ]+) ", "$1, ").repeat(copies).substring(0, maxLength);

        System.out.println(changeable.change(someLine1, copies1, maxLength1));
    }
}
