import java.util.ArrayList;
import java.util.List;

public class Bird {
    public String breed;
    public static final String NEW_LINE = System.getProperty("line.separator");
    List<Bird> birds = new ArrayList<Bird>(0);


    public Bird(String breed){
        this.breed = breed;
    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public void layEggs(){
        System.out.println(getRandomNumber(1,10) + " eggs were laid");
    }
    public void fly(){
        System.out.println("Flying is my life! Fly, fly.... Let's go");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bird)) return false;
        Bird bird = (Bird) o;
        return breed.equals(bird.breed);
    }

    @Override
    public int hashCode() {
        return 128 * breed.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(String.format("This is a bird with breed: %-10s ", breed));
        for (Bird bird : birds) {
            sb.append(NEW_LINE).append(bird.toString());
        }
        return sb.toString();
    }

}
