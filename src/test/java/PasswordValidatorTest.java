import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PasswordValidatorTest {
    StringBuilder validationMsg = new StringBuilder("Password should meet following requirements: ");
    String validationMsgEnd = "Please, try again.";
    String messageErrorSmall = " be longer than 6 and shorter than 20 symbols; ";
    String messageErrorUppercaseLetter = " have at least one uppercase letter; ";
    String messageErrorLowercaseLetter = " have at least one lowercase letter; ";
    String messageErrorDigit = " have at least one digit; ";


    @Test
    public void testAllPositive() {
        String passwordPositive = "Boris.1254";
        assertEquals(
                "true",
                PasswordValidator.validatePassword(passwordPositive)
        );
    }

    @Test
    public void testNegativeSmall() {
        String password = "Bo.54";

        assertEquals(
                validationMsg.append(messageErrorSmall).append(validationMsgEnd).toString(),
                PasswordValidator.validatePassword(password)
        );
    }

    @Test
    public void testNegativeDigitBig() {
        String password = "Boris_Test_.1255458454";

        assertEquals(
                validationMsg.append(messageErrorSmall).append(validationMsgEnd).toString(),
                PasswordValidator.validatePassword(password)
        );
    }

    @Test
    public void NegativeNullTest() {
        try {
            PasswordValidator.validatePassword(null);
        } catch (Exception e) {
            assertEquals(e.getClass(), java.lang.NullPointerException.class);
            assertEquals(e.getMessage(), "Cannot invoke \"java.lang.CharSequence.length()\" because \"this.text\" is null");
        }
    }

    @Test
    public void testNegativeNull() {

        assertEquals(
                " The input field is null. Please, try again.",
                PasswordValidator.validatePassword(null)
        );
    }



@Test
public void testNegativeUppercaseLetter() {
    String password = "boris.54";

    assertEquals(
            validationMsg
                    .append(messageErrorUppercaseLetter)
                    .append(validationMsgEnd)
                    .toString(),
            PasswordValidator.validatePassword(password)
    );
}

@Test
public void testNegativeLowercaseLetter() {
    String password = "BORISZ54";

    assertEquals(
            validationMsg
                    .append(messageErrorLowercaseLetter)
                    .append(validationMsgEnd)
                    .toString(),
            PasswordValidator.validatePassword(password)
    );
}

@Test
public void testNegativeDigit() {
    String password = "BorisTest";

    assertEquals(
            validationMsg
                    .append(messageErrorDigit)
                    .append(validationMsgEnd)
                    .toString(),
            PasswordValidator.validatePassword(password)
    );
}

@Test
public void testAllNegative() {
    String password = "";

    assertEquals(
            validationMsg
                    .append(messageErrorDigit)
                    .append(messageErrorLowercaseLetter)
                    .append(messageErrorUppercaseLetter)
                    .append(messageErrorSmall)
                    .append(validationMsgEnd)
                    .toString(),
            PasswordValidator.validatePassword(password)
    );
}

@Test
public void testNewInstance() {
    Object obj = new PasswordValidator();

    assertTrue( obj instanceof PasswordValidator);
}


}
