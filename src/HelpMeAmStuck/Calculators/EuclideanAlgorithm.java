package HelpMeAmStuck.Calculators;

public class EuclideanAlgorithm {
    public static int gcd(int a, int b) {
        // Make sure a is greater than or equal to b
        if (b > a) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static void Algorithmically() {
        int num1 = 50;
        int num2 = 15;
        int gcdResult = gcd(num1, num2);

        System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gcdResult);
    }
}
