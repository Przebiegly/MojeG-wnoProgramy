package HelpMeAmStuck.Test;

import HelpMeAmStuck.Calculators.CfromABinTriangle;
import HelpMeAmStuck.Calculators.Triangle;
import HelpMeAmStuck.Voids.Voids;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CfromABinTriangleTest {

    @Test
    public void testCalculation() {
        // Test input values
        double Ax = 2.0;
        double Ay = 3.0;
        double Bx = 5.0;
        double By = 7.0;
        double Cx = 9.0;
        double Cy = 4.0;


        double expectedLengthAB = Math.sqrt(Math.pow(Bx - Ax, 2) + Math.pow(By - Ay, 2));
        double expectedLengthBC = Math.sqrt(Math.pow(Cx - Bx, 2) + Math.pow(Cy - By, 2));
        double expectedLengthAC = Math.sqrt(Math.pow(Cx - Ax, 2) + Math.pow(Cy - Ay, 2));
        double expectedArea = Triangle.TriangleAreaV3(expectedLengthAB,expectedLengthBC,expectedLengthAC);
        double expectedHeight = Math.abs((Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By)) / expectedLengthBC);
        double expectedOuterLength = Triangle.TriangleOuterV1(expectedLengthAB,expectedLengthBC,expectedLengthAC);


        CfromABinTriangle.Ax = Ax;
        CfromABinTriangle.Ay = Ay;
        CfromABinTriangle.Bx = Bx;
        CfromABinTriangle.By = By;
        CfromABinTriangle.Cx = Cx;
        CfromABinTriangle.Cy = Cy;
        CfromABinTriangle.DoSomeMath();

        try {
            Assertions.assertEquals(expectedLengthAB, CfromABinTriangle.lengthAB, 0.001);
            Assertions.assertEquals(expectedLengthBC, CfromABinTriangle.lengthBC, 0.001);
            Assertions.assertEquals(expectedLengthAC, CfromABinTriangle.lengthAC, 0.001);
            Assertions.assertEquals(expectedArea, CfromABinTriangle.area, 0.001);
            Assertions.assertEquals(expectedHeight, CfromABinTriangle.height, 0.001);
            Assertions.assertEquals(expectedOuterLength, CfromABinTriangle.outerLength, 0.001);
            Voids.DisplayDevider3();
            System.out.println("Test Passed!");
            Voids.DisplayDevider3();
        }catch (AssertionError e) {
            System.out.println("Test failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred during the test: " + e.getMessage());
        }
    }
}
