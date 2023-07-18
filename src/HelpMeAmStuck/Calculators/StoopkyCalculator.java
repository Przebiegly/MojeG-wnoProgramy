package HelpMeAmStuck.Calculators;

import HelpMeAmStuck.Voids.Voids;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoopkyCalculator {
    public static double Centimeter = 1.0;
    public static double Millimeter = Centimeter / 10.0;
    public static double Meter = 100.0 * Centimeter;
    public static double KiloMeter = 1000.0 * Meter;
    public static double Inch = 2.54 * Centimeter;
    public static double Feet = 12.0 * Inch;

    public static String StringMillimeter = "mm";
    public static String StringCentimeter = "cm";
    public static String StringMeter = "m";
    public static String StringKiloMeter = "km";
    public static String StringFeet = "ft";
    public static String StringInch = "inch";

    public static Map<String, Double> unitMap;

    static {
        unitMap = new HashMap<>();
        unitMap.put(StringMillimeter, Millimeter);
        unitMap.put(StringCentimeter, Centimeter);
        unitMap.put(StringMeter, Meter);
        unitMap.put(StringKiloMeter, KiloMeter);
        unitMap.put(StringFeet, Feet);
        unitMap.put(StringInch, Inch);
    }

    public static void FancyFeats() {
        System.out.println("Calculator");
        Voids.DisplayDevider3();

        String input;
        while (true) {
            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if (Voids.EndingProgram(input)) break;

            double value = extractNumericValue(input);
            String unit = extractUnit(input);

            if (value != 0 && unit != null) {
                Double conversionFactor = unitMap.get(unit);
                if (conversionFactor != null) {
                    double meters = value * conversionFactor;
                    double centimeters = meters * Centimeter;

                    double feet = centimeters / Feet;
                    double inches = centimeters / Inch;

                    System.out.println("Meters: " + meters);
                    System.out.println("Centimeters: " + centimeters);
                    System.out.println("Feet: " + feet);
                    System.out.println("Inches: " + inches);
                } else {
                    System.out.println("Invalid unit!");
                }
            } else {
                System.out.println("Invalid input!");
            }

            Voids.DisplayDevider2();
        }
    }





    private static double extractNumericValue(String input) {
        String numericRegex = "(\\d+(?:\\.\\d+)?)"; // Match one or more digits (with optional decimal point and decimal digits)
        Pattern pattern = Pattern.compile(numericRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String numericValue = matcher.group();
            return Double.parseDouble(numericValue);
        }
        return 0;
    }

    private static String extractUnit(String input) {
        String unitRegex = "(mm|cm|m|km|ft|inch)"; // Match one of the supported units
        Pattern pattern = Pattern.compile(unitRegex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }
}
