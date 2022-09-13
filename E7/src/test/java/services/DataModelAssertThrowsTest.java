package services;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sajjad.junite5.model.TolkienCharacter;
import sajjad.junite5.services.DataService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static sajjad.junite5.model.Race.HOBBIT;


public class DataModelAssertThrowsTest {

    @Test
    @DisplayName("Ensure that access to the fellowship throws exception outside the valid range")
    void exceptionTesting() {
        DataService dataService = new DataService();
        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> dataService.getFellowship().get(20));
        assertEquals("Index 20 out of bounds for length 9", exception.getMessage());
    }

    @Test
    @Disabled("Please fix and enable")
    public void ensureThatAgeMustBeLargerThanZeroViaSetter() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);
        // use assertThrows() rule to check that the message is:
        // Age is not allowed to be smaller than zero
        assertThrows(IllegalArgumentException.class
                , () -> {
                    frodo.setAge(-1);
                }
                , "Age is not allowed to be smaller than zero");

    }

    @Test
    @Disabled("Please fix and enable")
    public void ensureThatAgeMustBeLargerThanZeroViaConstructor() {
        // use assertThrows() rule to check that an IllegalArgumentException exception is thrown and
        // that the message is:
        // "Age is not allowed to be smaller than zero"

        assertThrows(IllegalArgumentException.class,
                () -> {new TolkienCharacter("Frodo", -1, HOBBIT);},
                "Age is not allowed to be smaller than zero");

    }

}
