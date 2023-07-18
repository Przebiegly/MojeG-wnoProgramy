package HelpMeAmStuck.Calculators;

import HelpMeAmStuck.Voids.Voids;

public class SqrtCal {
    public static void SqrtGet(int sw,double num){

        if(sw == 1){
            Voids.DisplayInputArrow();
            num = Voids.sc.nextDouble();

        }

        double result = Math.pow(num,2);
        System.out.println("-/ "+result+" = "+num);
    }
}
