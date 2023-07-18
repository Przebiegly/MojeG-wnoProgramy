package HelpMeAmStuck.Calculators;

import HelpMeAmStuck.Voids.Voids;

public class BasicCalculator {
    public static void Calculator() {
        String input;

        System.out.println("Basic Calculator");
        Voids.DisplayDevider3();

        while(true){

            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if(Voids.EndingProgram(input)) break;
            Voids.BasicCalculator(input);
            Voids.DisplayDevider3();
        }
    }
}
