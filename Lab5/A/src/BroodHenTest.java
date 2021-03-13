import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BroodHenTest {
    private BroodHen broodHen;

    @BeforeEach
    public void setUp() throws Exception {
        broodHen = new BroodHen("chicken");
    }

    @Test
    @DisplayName("Test  Hatched Eggs")
    public void testHatchedEggs() {
        assertEquals("We need more birds! In any case, a good omelet will do!", broodHen.getHatchedEggs());
    }


    @Test
    @DisplayName("Test brood hen's abilities")
    public void testGetResume() {
        assertEquals("A brood hen can hatch eggs", broodHen.getResume());
    }

    @Test
    @DisplayName("Test  toString")
    public void testToString() {
        assertNotEquals(" ", broodHen.toString());
    }

    @Test
    @DisplayName("Test Hash code")
    public void testHashCode() {
        assertNotEquals(0, broodHen.hashCode());
    }
}
