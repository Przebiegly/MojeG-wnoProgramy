package HelpMeAmStuck.Calculators;

import HelpMeAmStuck.Voids.Voids;

import static HelpMeAmStuck.Voids.Voids.ConvertToDecimal;

public class FindDonAxis {
    public static double Ax;
    public static double Ay;
    public static double Bx;
    public static double By;
    public static double Cx;
    public static double Cy;
    public static double Dx;
    public static double Dy;

    public static void Finding() {
        String a;
        String b;
        String c;
        while (true) {
            System.out.println("Awaiting A, B, C position (x, y)");
            System.out.println("Remember for this program to work:");
            System.out.println("AB = DC and AD = BC");
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

            MathDoing();
        }
    }

    public static void MathDoing() {
        Dx = Cx - Bx + Ax;
        Dy = Cy - By + Ay;

        System.out.println("D: (" + Dx + ", " + Dy + ")");
    }
}
