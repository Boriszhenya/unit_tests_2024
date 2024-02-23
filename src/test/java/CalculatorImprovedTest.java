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

    @Test
    public void testMultiplyOne() {
        //Arrange
        CalculatorImproved test = new CalculatorImproved();
        int[] testData = {1, 1, 1};
        //Act
        int result = test.multiply(testData);
        //Assert
        assertEquals(1, result);
    }

    @Test
    public void testMultiplyZero() {
        //Arrange
        CalculatorImproved test = new CalculatorImproved();
        int[] testData = {1, 0, 4};
        //Act
        int result = test.multiply(testData);
        //Assert
        assertEquals(0, result);
    }


}