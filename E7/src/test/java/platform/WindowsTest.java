package platform;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

class WindowsTest {
    @Test
    void testName() throws Exception {
        // only run on Windows
        Assumptions.assumeTrue(System.getProperty("os.name").contains("Windows"));
        assertTrue(true);
    }
}