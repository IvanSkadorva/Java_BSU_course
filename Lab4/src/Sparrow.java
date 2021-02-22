import java.util.ArrayList;
import java.util.List;

public class Sparrow extends Bird {
        public String breed;
        public static final String NEW_LINE = System.getProperty("line.separator");
        List<Sparrow> sparrows = new ArrayList<Sparrow>(0);


        public Sparrow(String breed){
            super(breed);
            this.breed = breed;
        }
        public void sing(){
        System.out.println("""
                I was walking down the street
                When out the corner of my eye
                I saw a pretty little thing approaching me
                She said, I've never seen a man
                Who looks so all alone
                Uh, could you use a little company?""");
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Sparrow)) return false;
            Sparrow sparrow = (Sparrow) o;
            return breed.equals(sparrow.breed);
        }

        @Override
        public int hashCode() {
            return 234 * breed.hashCode();
        }

        @Override
        public String toString() {
            final StringBuilder sb =  new StringBuilder().append(super.toString());
            return sb.toString();
        }

    }
