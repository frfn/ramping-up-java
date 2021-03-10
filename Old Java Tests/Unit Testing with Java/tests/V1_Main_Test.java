import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 * What are JUnit Suites?
 *
 * They are grouped Test units!
 * That's it! Selected classes that were chosen to be tested. 
 */

/**
 * JUnit 4 - @Before ; @BeforeClass
 *
 * equivalence in
 *
 * JUnit 5 - @BeforeEach ; @BeforeAll
 *
 * also
 *
 * there is @AfterEach ; @AfterAll
 *
 * {before/after}All -- convention, must be STATIC.
 * This only runs once. Usually connecting to a database!
 *
 * {before/after}Each -- convention must be void, that is it!
 * This runs EVERY time there is a @Test method!
 *
 *
 */

class V1_Main_Test {
    V1_Main test = new V1_Main();

    @BeforeEach
    void runBefore() {
        test.setNameAndAge("Flexer", 23);
        test.isHappy();
        System.out.println("Initialized object");
    }


    @Test
    void setNameAndAge() {
        //test.setNameAndAge("Flexer", 23);
        assertEquals(23, test.getAge());
        assertEquals("Flexer", test.getName());
    }

    @Test
    void getName() {
        //test.setNameAndAge("Flexer", 23);
        assertEquals("Flexer", test.getName());
    }

    @Test
    void getAge() {
        //test.setNameAndAge("Flexer", 23);
        assertEquals(23, test.getAge());
    }

    @Test
    void isHappy() {
        //test.isHappy();
        assertEquals(true, test.isHappy());

    }

    /**
     * JUnit 4 has @Test(expected=Exception.class)
     *
     * JUnit 5 has assertThrows()...
     *
     * I don't know this.
     *
     * Test for null value.
     */

    @Test
    void testToCheckForNullPointerException(){
        test.setNameAndAge(null, 0);

    }

    @AfterEach
    void runAfter(){
        test.setNameAndAge("", 0);
        test.setMood(false);
        System.out.println("Cleared Input");
    }
}