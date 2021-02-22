import java.util.ArrayList;
import java.util.List;

public class BroodHen extends Sparrow {
    public static final String NEW_LINE = System.getProperty("line.separator");
    List<BroodHen> broodHens = new ArrayList<BroodHen>(0);


    public BroodHen(String breed){
        super(breed);
        this.breed = breed;
    }
    public void hatchEggs(){
        System.out.println("We need more birds! In any case, a good omelet will do!");
    }
    public void getResume(){
        System.out.println("A brood hen can: \n");

    }
    public List<BroodHen> getBroodHens() {
        return broodHens;
    }

    public int getTotalBroodHensQuantity() {
        return broodHens.size();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BroodHen)) return false;
        BroodHen broodHen = (BroodHen) o;
        return breed.equals(broodHen.breed);
    }

    @Override
    public int hashCode() {
        return 999 * breed.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder().append(super.toString());
        return sb.toString();
    }
}
