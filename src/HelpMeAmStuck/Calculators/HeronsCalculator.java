package HelpMeAmStuck.Calculators;

import HelpMeAmStuck.Voids.Voids;

import java.text.DecimalFormat;

public class HeronsCalculator {
    public static void CalculateHeron(){

        System.out.println("Herons Roots");
        Voids.DisplayDevider3();
        System.out.println("Give number to root:");
        Voids.DisplayInputArrow();
        String input = Voids.sc.nextLine();
        double inputDouble = 0;

        try{
            inputDouble = Double.parseDouble(input);
            Calculate(inputDouble);
        }catch (Exception exception){
            System.out.println("Error occurred: "+exception);
        }


    }

    private static void Calculate(double x){

        int r = String.valueOf(x).length() + 1;
        double R = r * (Math.pow(10,2));
        double g = 0;
        for(int i = 0; i<20;i++){
            g = (R + x / R)/2;
            R = g;

        }
        double check = Math.sqrt(x);
        System.out.println("result = "+R);
        System.out.println("check = "+check);

        double acc = calculateAccuracy(R,check);
        System.out.println("Accuracy: "+formatAccuracy(acc));


    }

    private static double calculateAccuracy(double result, double check) {
        return Math.abs(((result - check) / check) * 100);
    }

    private static String formatAccuracy(double accuracy) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(accuracy) + "%";
    }

}

