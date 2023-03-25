package assertions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class AssertionsHandler{



    public static void assertTextContains(String subString, String string) {
        assertThat(string, containsString(subString));
    }

    public static void assertTextEquals(String actualText, String expectedText) {
        assertThat(actualText, equalTo(expectedText));
    }

    public static void assertValueEquals(int actualValue, int expectedValue){
        assertThat(actualValue, equalTo(expectedValue));
    }

    public static void fail(String reason) {
        fail(reason);
    }

    public static void Numero1Mayor(int num1, int num2) {
        assertThat(num1, lessThan(num2));
    }



}
