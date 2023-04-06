import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void simpleCase1() {
        assertEquals("",Solution.minWindow("a","aa"));

    }
    @org.junit.jupiter.api.Test
    void simpleCase2() {
        assertEquals("BANC", Solution.minWindow("ADOBECODEBANC","ABC"));

    }
    @org.junit.jupiter.api.Test
    void simpleCase3() {
        assertEquals("aa", Solution.minWindow("aa","aa"));

    }
}