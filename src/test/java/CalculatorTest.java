import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    
    @Test
    public void testAddition() {
        var calculator = new Calculator();
        int result = calculator.add(2, 3);
        assertEquals(7, result); // This will fail
    }
    
    @Test
    public void testSubtraction() {
        var calculator = new Calculator();
        int result = calculator.subtract(5, 3);
        assertEquals(2, result);
    }
}
