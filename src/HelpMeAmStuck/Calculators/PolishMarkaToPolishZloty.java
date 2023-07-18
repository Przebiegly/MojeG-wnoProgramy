package HelpMeAmStuck.Calculators;

import HelpMeAmStuck.Voids.Voids;

public class PolishMarkaToPolishZloty {
    // all the data are for 1924
    public static String ZlotyPrefix = "Pln";
    public static String MarkPrefix = "Polish Mark";
    public static String DollarPrefix = "USD";

    public static double ZlotyValue = 1.0;
    public static double PolishMarkValue = 1.0;

    public static double ZlotyToMarkExchangeRate = 1800000.0;
    public static double OldDollarValueInZloty = ZlotyValue * 5.18; // value 5.18 zloty = 1 USD was set by Michał Grabowski creator of zloty and Polish National Bank
    public static void WhereTheMarkGo(){
        System.out.println("Marka Has no Power Here");
        String input;
        while(true){
            Voids.DisplayDevider2();
            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if(Voids.EndingProgram(input)) break;
            try{
                double inputDouble = Double.parseDouble(input);

                double Result = inputDouble * ZlotyToMarkExchangeRate;
                String formattedResult = String.format("%.5f", Result);
                double ResultInDollars = inputDouble / OldDollarValueInZloty;
                System.out.println("1924:");
                System.out.println(inputDouble+" "+ZlotyPrefix+" = "+formattedResult+" "+MarkPrefix);
                System.out.println(inputDouble+" "+ZlotyPrefix+" = "+ResultInDollars+" "+DollarPrefix);
            }catch (Exception e){
                System.out.println("Nice try! ("+e+")");
            }
        }
    }
}
