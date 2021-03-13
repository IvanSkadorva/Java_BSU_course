import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SparrowTest {
    private Sparrow sparrow;

    @BeforeEach
    public void setUp() throws Exception {
        sparrow = new Sparrow("sparrow");
    }

    @Test
    @DisplayName("Test the song")
    public void testSong() {
        assertEquals("Chick-Shirk", sparrow.getSong());
    }


    @Test
    @DisplayName("Test Hash code")
    public void testHashCode() {
        assertNotEquals(0, sparrow.hashCode());
    }
    @Test
    @DisplayName("Test  toString")
    public void testToString() {
        assertNotEquals(" ", sparrow.toString());
    }
}
