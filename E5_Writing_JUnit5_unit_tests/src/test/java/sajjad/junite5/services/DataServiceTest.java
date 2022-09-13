package sajjad.junite5.services;

import static org.junit.jupiter.api.Assertions.*;
import static sajjad.junite5.model.Race.*;

import org.junit.jupiter.api.*;
import sajjad.junite5.model.Movie;
import sajjad.junite5.model.Ring;
import sajjad.junite5.model.TolkienCharacter;

import java.time.Duration;
import java.util.List;
import java.util.Map;

class DataServiceTest {


    DataService dataService;

    // Task: initialize before each test
    @BeforeEach
    void setUp() {
        dataService = new DataService();
    }

    @Test
    void ensureThatInitializationOfTolkeinCharactersWorks() {

        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);

        // Task: check that age is 33
        assertEquals(33, frodo.age, "Frodo should be 33");
        // Task: check that name is "Frodo"
        assertEquals("Frodo", frodo.getName(), "Frodo has wrong name");
        // Task: check that name is not "Frodon"
        assertNotEquals("Frodon", frodo.getName(), "Frodo has wrong name");

        /*fail("not yet implemented");*/
    }

    @Test
    void ensureThatEqualsWorksForCharacters() {
        Object jake = new TolkienCharacter("Jake", 43, HOBBIT);
        Object sameJake = jake;
        Object jakeClone = new TolkienCharacter("Jake", 12, HOBBIT);
        // Task: check that:
        // jake is equal to sameJake
        assertEquals(sameJake, jake, "jake should be equal to same jake");
        // jake is not equal to jakeClone
        assertNotEquals(jake, jakeClone, "jake the clone shouldn't be equal");
        /*fail("not yet implemented");*/
    }

    @Test
    void checkInheritance() {
        TolkienCharacter tolkienCharacter = dataService.getFellowship().get(0);
        // Task: check that tolkienCharacter.getClass is not a movie class
        assertFalse(Movie.class.isAssignableFrom(tolkienCharacter.getClass()));
        assertTrue(TolkienCharacter.class.isAssignableFrom(tolkienCharacter.getClass()));

    }

    @Test
    void ensureFellowShipCharacterAccessByNameReturnsNullForUnknownCharacter() {
        // Task: implement a check that dataService.getFellowshipCharacter returns null for an
        // unknow felllow, e.g. "Lars";
        assertNull(dataService.getFellowshipCharacter("Lars"));
    }

    @Test
    void ensureFellowShipCharacterAccessByNameWorksGivenCorrectNameIsGiven() {
        // Task: implement a check that dataService.getFellowshipCharacter returns a fellow for an
        // existing fellow, e.g. "Frodo"
        assertNotNull(dataService.getFellowshipCharacter("Frodo"));

    }


    @Test
    void ensureThatFrodoAndGandalfArePartOfTheFellowship() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();
        // Task: check that Frodo and Gandalf are part of the fellowship
        assertTrue(fellowship.contains(new TolkienCharacter("Frodo", 33, HOBBIT)));
        assertTrue(fellowship.contains(new TolkienCharacter("Gandalf", 2020, MAIA)));
    }

    @Test
    void ensureThatOneRingBearerIsPartOfTheFellowship() {

        // Task: test that at least one ring bearer is part of the fellowship
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        Map<Ring, TolkienCharacter> map = dataService.getRingBearers();
        assertTrue(map.values().stream().anyMatch(fellowship::contains));

    }

    // Task: Use @RepeatedTest(int) to execute this test 1000 times
    @Tag("slow")
    @RepeatedTest(1000)
    @DisplayName("Minimal stress testing: run this test 1000 times to ")
    void ensureThatWeCanRetrieveFellowshipMultipleTimes() {
        dataService = new DataService();
        assertNotNull(dataService.getFellowship());
    }

    @Test
    void ensureOrdering() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();
        // ensure that the order of the fellowship is:
        // frodo, sam, merry,pippin, gandalf,legolas,gimli,aragorn,boromir
        assertEquals("Frodo", fellowship.get(0).getName());
        assertEquals("Sam", fellowship.get(1).getName());
        assertEquals("Merry", fellowship.get(2).getName());
        assertEquals("Pippin", fellowship.get(3).getName());
        assertEquals("Gandalf", fellowship.get(4).getName());
        assertEquals("Legolas", fellowship.get(5).getName());
        assertEquals("Gimli", fellowship.get(6).getName());
        assertEquals("Aragorn", fellowship.get(7).getName());
        assertEquals("Boromir", fellowship.get(8).getName());
    }

    @Test
    void ensureAge() {
        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // Task: test ensure that all hobbits and men are younger than 100 years
        assertTrue(fellowship.stream().filter(f -> f.getRace().equals(HOBBIT)).allMatch(f -> f.age < 100));
        // Task: also ensure that the elfs, dwars the maia are all older than 100 years
        assertTrue(fellowship.stream().filter(f -> f.getRace().equals(ELF)).allMatch(f -> f.age > 100));
        assertTrue(fellowship.stream().filter(f -> f.getRace().equals(DWARF)).allMatch(f -> f.age > 100));
        assertTrue(fellowship.stream().filter(f -> f.getRace().equals(MAIA)).allMatch(f -> f.age > 100));


        // HINT fellowship.stream might be useful here
    }

    @Test
    void ensureThatFellowsStayASmallGroup() {

        List<TolkienCharacter> fellowship = dataService.getFellowship();

        // Task: Write a test to get the 20 element from the fellowship throws an
        // IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> fellowship.get(20));
    }

    @Test
    void ensureUpdateDoesNotRunLongerThan3Seconds() {
        assertTimeout(Duration.ofSeconds(3), () -> dataService.update());

    }

}