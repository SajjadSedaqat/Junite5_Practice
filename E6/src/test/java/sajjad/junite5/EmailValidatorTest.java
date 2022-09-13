package sajjad.junite5;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class EmailValidatorTest {
    // TODO Write test for EmailValidator
    // The names of the methods should give you a pointer what to test for

    @Test
    public void ensureThatEmailValidatorReturnsTrueForValidEmail() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@gmail.com"));
    }

    @Test
    @DisplayName("Ensure that the usage of a subdomain is still valid, see https://en.wikipedia.org/wiki/Subdomain")
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("lars.vogel@shop.exmple.com"));
    }

    @Test
    @DisplayName("Ensure that a missing top level domain returns false")
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("anyText@example"));
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("anyText@exmple..com"));
        //this need more test and fix in the code
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@exmple.com"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null));
    }

}