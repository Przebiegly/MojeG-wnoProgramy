package HelpMeAmStuck.Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import HelpMeAmStuck.Calculators.FindDonAxis;

public class FindDonAxisTest {

    @Test
    public void testFindingD() {
        double Ax = 1.3;
        double Ay = 1.2;
        double Bx = -2.0;
        double By = -1.0;
        double Cx = 2.0;
        double Cy = 1.0;
        double Dx; // Should be 2.6 calculated by using vector AB and vector DC knowing that AB = DC
        double Dy; // Should be 3.2 calculated by using vector AB and vector DC


        FindDonAxis.Ax = Ax;
        FindDonAxis.Ay = Ay;
        FindDonAxis.Bx = Bx;
        FindDonAxis.By = By;
        FindDonAxis.Cx = Cx;
        FindDonAxis.Cy = Cy;
        FindDonAxis.MathDoing();
        Dx = FindDonAxis.Dx;
        Dy = FindDonAxis.Dy;

        try {
            assertEquals(2.6, Dx, 0.001);
            assertEquals(3.2, Dy, 0.001);
            System.out.println("Test passed!");
        }catch (Exception exception) {
            System.out.println("Error: " +exception);
        }
        }
}
