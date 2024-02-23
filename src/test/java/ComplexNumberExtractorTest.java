import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComplexNumberExtractorTest {

    @Test
    public void newInstanceTest() {
        Object obj = new ComplexNumberExtractor();

        assertTrue(obj instanceof ComplexNumberExtractor);
    }

    @Test
    public void nullExtractNumbersTest() {
        String input = null;
        assertTrue(ComplexNumberExtractor.extractNumbers(input).isEmpty());
    }

    @Test
    public void isEmptyExtractNumbersToIntTest() {
        String input = "";
        assertTrue(ComplexNumberExtractor.extractNumbers(input).isEmpty());
    }

    @Test
    public void nullParseStringToIntTest() {
        String input = null;
        try {
            ComplexNumberExtractor.parseStringToInt(input);
        } catch (Exception e) {
            assertEquals(e.getClass(), java.lang.NullPointerException.class);
            assertEquals(e.getMessage(), "Cannot invoke \"String.replaceAll(String, String)\" because \"input\" is null");
        }
    }

    @Test
    public void isEmptyParseStringToIntTest() {
        String input = "";
        assertEquals(0, ComplexNumberExtractor.parseStringToInt(input));
    }


    @Test
    public void positiveParseStringToIntTest() {
        String input = "test15";
        assertEquals(15, ComplexNumberExtractor.parseStringToInt(input));
    }

    @Test
    public void add2Test() {
        String input = "123-4567";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = new ArrayList<>();
        expecktedList.add(4690);

        assertEquals(number, expecktedList);
    }

    @Test
    public void abcTest() {
        String input = "abc";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = new ArrayList<>();
        expecktedList.add(123);

        assertEquals(number, expecktedList);
    }
    @Test
    public void abcNumberTest() {
        String input = "abc844";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = Arrays.asList(123, 844);

        assertEquals(number, expecktedList);
    }
    @Test
    public void defTest() {
        String input = "def";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = new ArrayList<>();
        expecktedList.add(456);

        assertEquals(number, expecktedList);
    }

    @Test
    public void defNumberTest() {
        String input = "def844";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = Arrays.asList(456, 844);

        assertEquals(number, expecktedList);
    }

    @Test
    public void NumberDEFTest() {
        String input = "844def";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = Arrays.asList(789, 844);

        assertEquals(number, expecktedList);
    }

    @Test
    public void SpecialTest() {
        String input = "special";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = Arrays.asList(999, 789);
        assertEquals(number, expecktedList);
    }


    @Test
    public void OtherWordsTest() {
        String input = "adrakadabra";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = new ArrayList<>();
        expecktedList.add(789);
        assertEquals(number, expecktedList);
    }

    @Test
    public void SpaceNumberTest() {
        String input = "test 125";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = new ArrayList<>();
        expecktedList.add(789);
        assertEquals(number, expecktedList);
    }


    @Test
    public void oneWordUpperTest() {
        String input = "Test 125";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
          List<Integer> expecktedList = Arrays.asList(789, 555);
        assertEquals(number, expecktedList);
    }

    @Test
    public void twoWordsUpperTest() {
        String input = "Test Second";
        List<Integer> number = ComplexNumberExtractor.extractNumbers(input);
        List<Integer> expecktedList = Arrays.asList(789, 789, 555);
        assertEquals(number, expecktedList);
    }
}
