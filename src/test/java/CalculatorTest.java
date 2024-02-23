import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    public void setUo(){
        calculator = new Calculator();
    }


    @Test
    public void testAdd() {
        //Arrange
        //Calculator calculator = new Calculator();
        //Act
        int result = calculator.add(3, 4);
        //Assert
        assertEquals(7, result);
    }

    @Test
    public void testAddNegative() {
        //Calculator calculator = new Calculator();
        int result = calculator.add(-3, -4);
        assertEquals(-7, result);
    }

    @Test
    public void testSubtract() {
      //  Calculator calculator = new Calculator();
        int result = calculator.subtract(4, 2);
        assertEquals(2, result);
    }

    @Test
    public void testMultiply() {
      //  Calculator calculator = new Calculator();
        int result = calculator.multiply(3, 4);
        assertEquals(12, result);
    }

    @Test
    public void testDivision() {
     //   Calculator calculator = new Calculator();
        int result = calculator.divide(12, 3);
        assertEquals(4, result);
    }
}
