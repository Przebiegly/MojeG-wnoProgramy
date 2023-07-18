package HelpMeAmStuck.Calculators;

public class Triangle {
    public static double TriangleAreaV3(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Found Zero and Below!");
            return 0;
        } else {
            double semiP = (a + b + c) / 2.0;
            return Math.sqrt(semiP * (semiP - a) * (semiP - b) * (semiP - c));
        }
    }

    public static double TriangleOuterV1(double a, double b, double c){
        if(a <= 0 || b <= 0 || c<= 0){
            System.out.println("Found Zero and Below!");
            return 0;
        }else {
            return a + b + c;

        }
    }

    public static double TriangleHeightByPoints(double Ax, double Ay, double Bx, double By, double Cx, double Cy, double lengthBC) {
        double height = Math.abs((Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By)) / lengthBC);
        return height;
    }

}
