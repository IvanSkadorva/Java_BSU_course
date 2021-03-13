import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BirdTest {
    private Bird bird;
    @BeforeEach
    public void setUp() throws Exception {
        bird = new Bird("sparrow");
    }
    @Test
    @DisplayName("Test Hash code")
    public void testHashCode() {
        assertNotEquals(0, bird.hashCode());
    }

    @Test
    @DisplayName("Test  toString")
    public void testToString() {
        assertNotEquals(" ", bird.toString());
    }
}
