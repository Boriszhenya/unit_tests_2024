import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberExtractor {
    // Эта функция извлекает числа из входной строки и "кладёт"
    // в результирующий массив на основе следующих правил:
    // Вся входная строка разбивается по пробелам, затем каждая часть обрабатывается:
    // Числа в формате «###-####» или «##-###-####» извлекаются и складываются.
    // Если во входных данных присутствует слово «special» в любом регистре,
    // то в выходной массив добавляется число 999, столько же раз.
    // Если часть ввода начинается с «abc» и содержит число,
    // в массив добавляется число 123 и число после «abc»;
    // если часть начинается с «def», в массив добавляется число 456
    // и число после «def»; в противном случае в массив добавляется 789
    // и число после любой комбинации букв. Если число после букв равно 0
    // оно будет удалено из выходного массива.
    // Если часть ввода содержит только число, оно игнорируется.
    // Если входные данные содержат заглавные буквы, в конец выходного массива
    // один раз добавляется число 555.
    public static List<Integer> extractNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();

        if (input == null || input.isEmpty()) {
            return numbers;
        }

        List<String> inputStrings = Arrays.stream(input.split(" ")).toList();

        inputStrings.forEach(inputPart -> {
            Pattern pattern = Pattern.compile("\\b(?:\\d{2}-)?(\\d{3})-(\\d{4})\\b");
            Matcher matcher = pattern.matcher(inputPart);

            while (matcher.find()) {
                String group1 = matcher.group(1);
                String group2 = matcher.group(2);

                if (group1 != null && !group1.isEmpty() && group2 != null && !group2.isEmpty()) {
                    int number = Integer.parseInt(group1) + Integer.parseInt(group2);
                    numbers.add(number);
                }
            }

            if (inputPart.toLowerCase().contains("special")) {
                numbers.add(999);
            }

            if (inputPart.matches(".*[a-z].*")) {
                if (inputPart.startsWith("abc")) {
                    numbers.add(123);
                } else if (inputPart.startsWith("def")) {
                    numbers.add(456);
                } else {
                    numbers.add(789);
                }
                numbers.add(parseStringToInt(inputPart));
            }
        });

        if (input.matches(".*[A-Z].*")) {
            numbers.add(555);
        }

        numbers.removeIf(i -> i==0);

        return numbers;
    }

    public static int parseStringToInt(String input) {
        String numericString = input.replaceAll("[^0-9]", "");
        if(numericString.isEmpty() || numericString.isBlank())
            return 0;
        return Integer.parseInt(numericString);
    }


}
