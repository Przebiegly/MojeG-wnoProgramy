package HelpMeAmStuck.Calculators;
import HelpMeAmStuck.Voids.Voids;
import ch.obermuhlner.math.big.BigDecimalMath;
import java.math.BigDecimal;
import java.math.BigInteger;

import static HelpMeAmStuck.Voids.Voids.ConvertToDecimal;

public class CfromABinTriangle {
    public static double Ax;
    public static double Ay;
    public static double Bx;
    public static double By;
    public static double Cx;
    public static double Cy;
    public static double lengthAB;
    public static double lengthBC;
    public static double lengthAC;
    public static double area;
    public static double height;
    public static double outerLength;
    public static void GettingDone() {
        String a;
        String b;
        String c;

        while (true) {
            System.out.println("Awaiting A, B, C position (x, y)");
            Voids.DisplayDevider3();

            System.out.print("A: ");
            a = Voids.sc.nextLine();
            if (Voids.EndingProgram(a)) {
                break;
            }
            String[] ATab = a.split(",");
            Ax = ConvertToDecimal(ATab[0]);
            Ay = ConvertToDecimal(ATab[1]);

            System.out.print("B: ");
            b = Voids.sc.nextLine();
            if (Voids.EndingProgram(b)) {
                break;
            }
            String[] BTab = b.split(",");
            Bx = ConvertToDecimal(BTab[0]);
            By = ConvertToDecimal(BTab[1]);

            System.out.print("C: ");
            c = Voids.sc.nextLine();
            if (Voids.EndingProgram(c)) {
                break;
            }
            String[] CTab = c.split(",");
            Cx = ConvertToDecimal(CTab[0]);
            Cy = ConvertToDecimal(CTab[1]);

            DoSomeMath();
        }
    }
    public static void DoSomeMath() {
        double SxAB = (Ax + Bx) / 2.0;
        double SyAB = (Ay + By) / 2.0;
        double SxBC = (Bx + Cx) / 2.0;
        double SyBC = (By + Cy) / 2.0;
        double SxAC = (Ax + Cx) / 2.0;
        double SyAC = (Ay + Cy) / 2.0;

        lengthAB = Math.sqrt(Math.pow(Bx - Ax, 2) + Math.pow(By - Ay, 2));
        lengthBC = Math.sqrt(Math.pow(Cx - Bx, 2) + Math.pow(Cy - By, 2));
        lengthAC = Math.sqrt(Math.pow(Cx - Ax, 2) + Math.pow(Cy - Ay, 2));

        area = Triangle.TriangleAreaV3(lengthAB, lengthBC, lengthAC);
        height = Triangle.TriangleHeightByPoints(Ax, Ay, Bx, By, Cx, Cy, lengthBC);
        outerLength = Triangle.TriangleOuterV1(lengthAB, lengthBC, lengthAC);

        calculateSymmetricalLineAB();
        calculateSymmetricalLineBC();
        calculateSymmetricalLineAC();

        System.out.println("Center of AB: (" + SxAB + ", " + SyAB + ")");
        System.out.println("Center of BC: (" + SxBC + ", " + SyBC + ")");
        System.out.println("Center of AC: (" + SxAC + ", " + SyAC + ")");

        System.out.println("Length of AB: " + lengthAB);
        System.out.println("Length of BC: " + lengthBC);
        System.out.println("Length of AC: " + lengthAC);

        System.out.println("Area of the triangle: " + area);
        System.out.println("Height of the triangle: " + height);
        System.out.println("Outer length of the triangle: " + outerLength);

        Voids.DisplayDevider2();
    }


    private static String convertToFraction(double decimal) {
        if (decimal % 1 == 0) {
            return String.valueOf((int) decimal);
        } else {
            BigDecimal decimalValue = BigDecimal.valueOf(decimal);
            BigDecimal fractionValue = BigDecimalMath.fractionalPart(decimalValue);
            BigInteger numerator = fractionValue.unscaledValue();
            BigInteger denominator = BigInteger.TEN.pow(fractionValue.scale());
            return numerator + "/" + denominator;
        }
    }
    public static void calculateSymmetricalLineAB() {
        double Sx = (Ax + Bx) / 2;
        double Sy = (Ay + By) / 2;
        double A1 = (By - Ay) / (Bx - Ax);
        double A2 = -1 / A1;
        double X = Sx;
        double Y = Sy;
        double B = Y - (A2 * X);

        System.out.println("b = y - ax");
        System.out.println("b = " + convertToFraction(Y) + " - (" + convertToFraction(A2) + " * " + convertToFraction(X) + ")");
        Voids.DisplayDevider3();
    }
    public static void calculateSymmetricalLineBC() {
        double Sx = (Bx + Cx) / 2;
        double Sy = (By + Cy) / 2;
        double A1 = (Cy - By) / (Cx - Bx);
        double A2 = -1 / A1;
        double X = Sx;
        double Y = Sy;
        double B = Y - (A2 * X);

        System.out.println("b = y - ax");
        System.out.println("b = " + convertToFraction(Y) + " - (" + convertToFraction(A2) + " * " + convertToFraction(X) + ")");
        Voids.DisplayDevider3();
    }
    public static void calculateSymmetricalLineAC() {
        double Sx = (Ax + Cx) / 2;
        double Sy = (Ay + Cy) / 2;
        double A1 = (Cy - Ay) / (Cx - Ax);
        double A2 = -1 / A1;
        double X = Sx;
        double Y = Sy;
        double B = Y - (A2 * X);

        System.out.println("b = y - ax");
        System.out.println("b = " + convertToFraction(Y) + " - (" + convertToFraction(A2) + " * " + convertToFraction(X) + ")");
        Voids.DisplayDevider3();
    }

}