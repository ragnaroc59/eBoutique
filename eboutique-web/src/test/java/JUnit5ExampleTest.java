import org.junit.Assert;
import org.junit.jupiter.api.Test;

class JUnit5ExampleTest {

    @Test
    void justAnExample() {
        System.out.println("Test");
        Assert.assertEquals("Test","Test");
    }
}