package bmps.com.stacks;

import bmps.com.dsa.stacks.ValidateParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateParenthesesTest {

    @Test
    void isValid() {
        var isValidParentheses = new ValidateParentheses();
        assertTrue(isValidParentheses.isValid("[]"));
        assertTrue(isValidParentheses.isValid("([{}])"));
        assertFalse(isValidParentheses.isValid("[(])"));
        assertFalse(isValidParentheses.isValid("["));
        assertFalse(isValidParentheses.isValid("]"));
        assertFalse(isValidParentheses.isValid("]})"));
    }
}