import java.util.Arrays;

public class CalculatorImproved {
    public Integer multiply(int[] input){
        if(Arrays.stream(input).anyMatch(i -> i == 0))
            return 0;
        int result = 1;
        if(!Arrays.stream(input).allMatch(i -> i == 1)) {
            for (int value : input) {
                result *= value;
            }
        }
        return result;
    }
}