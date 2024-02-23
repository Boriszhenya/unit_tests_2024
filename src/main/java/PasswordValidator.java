import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static String validatePassword(String input) {
        Pattern password = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$");

        if (input==null) {
            return (" The input field is null. Please, try again.");
        }

        Matcher matcher = password.matcher(input);

        if (matcher.matches()) {
            return "true";
        } else {
            StringBuilder validationMsg = new StringBuilder("Password should meet following requirements: ");

            if (!input.matches(".*\\d.*")) {
                validationMsg.append(" have at least one digit; ");
            }
            if (!input.matches(".*[a-z].*")) {
                validationMsg.append(" have at least one lowercase letter; ");
            }
            if (!input.matches(".*[A-Z].*")) {
                validationMsg.append(" have at least one uppercase letter; ");
            }
            if (!input.matches("^.{6,20}$")) {
                validationMsg.append(" be longer than 6 and shorter than 20 symbols; ");
            }
            return validationMsg + "Please, try again.";
        }
    }
}

