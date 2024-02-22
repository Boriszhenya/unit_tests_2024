import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorImprovedTest {
    @Test
    public void testMultiply() {
        //Arrange
        CalculatorImproved test = new CalculatorImproved();
        int[] testData = {1, 2, 3};
        //Act
        int result = test.multiply(testData);
        //Assert
        assertEquals(6, result);
    }
}