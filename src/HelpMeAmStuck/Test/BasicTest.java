package HelpMeAmStuck.Test;

import org.junit.jupiter.api.*;


public class BasicTest {


    @Test
    public void runTest(int x, int y) {
        try {
            int result = Basic.add(x, y);
            Assertions.assertEquals(5, result);
            System.out.println("Test was successful!");
        } catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred during the test: " + e.getMessage());
        }
    }


}


