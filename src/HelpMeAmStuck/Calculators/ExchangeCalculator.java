package HelpMeAmStuck.Calculators;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import HelpMeAmStuck.Voids.Voids;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ExchangeCalculator {
    public static double ZlotyValue = 1.0;
    public static String ZlotyPrefix = "pln";
    public static double CurrencyValue;
    public static int CurrencyUnits;
    public static String CurrencyPrefix;
    public static List<CurrencyDetails> CurrencyAndExchangesList = new ArrayList<>();
    public static List<String> convertedValuesList = new ArrayList<>();
    public static void Exchange() {
        System.out.println("Exchange Calculator");
        String Input;
        Double InputDouble;
        GetInformation();
        while(true){
            Voids.DisplayInputArrow();
            Input = Voids.sc.nextLine();
            if(Voids.EndingProgram(Input)) break;
            if(Input.equals("DisplayList")){
                DisplayList(CurrencyAndExchangesList);
            }
            else {

                InputDouble = ParsetDouble(Input);
                PerformThisExchange(InputDouble);
                ShowThisExchangeResults();
                Voids.DisplayDevider2();
            }
        }
    }

    public static void ShowThisExchangeResults(){
        for(int i = 0; i<convertedValuesList.size(); i++)
            System.out.println(convertedValuesList.get(i));
    }
    public static void PerformThisExchange(double inputDouble) {
        for (int i = 0; i < CurrencyAndExchangesList.size() - 1; i++) {
            CurrencyDetails currencyDetails = CurrencyAndExchangesList.get(i);
            double exchangeRate = currencyDetails.getValue();
            int units = currencyDetails.getUnits();

            double convertedValue = (inputDouble * units) / exchangeRate;
            String result = inputDouble + " " + ZlotyPrefix + " = " + convertedValue + " " + currencyDetails.getCurrency();
            convertedValuesList.add(result);
        }
    }

    public static double ParsetDouble(String Input){
        try{
            double ID = Double.parseDouble(Input);
            return ID;
        }catch (Exception e){
            System.out.println("An Error Occurred: "+e);
            System.out.println("Returning for 1");
            return 1;
        }

    }
    public static void GetInformation(){
        try {

            URL url = new URL("https://static.nbp.pl/dane/kursy/xml/en/23a102en.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(url.openStream());

            document.getDocumentElement().normalize();

            NodeList midRates = document.getElementsByTagName("mid-rate");

            AddToList(CurrencyAndExchangesList,midRates);
            //DisplayList(CurrencyAndExchangesList);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
    public static void AddToList(List<CurrencyDetails> List,NodeList midRates){
        for (int i = 0; i < midRates.getLength(); i++) {
            Node midRate = midRates.item(i);
            Element midRateElement = (Element) midRate;
            String currency = midRateElement.getAttribute("currency");
            double value = Double.parseDouble(midRate.getTextContent());
            int units = Integer.parseInt(midRateElement.getAttribute("units"));
            CurrencyDetails currencyDetails = new CurrencyDetails(currency, value, units);
            List.add(currencyDetails);
        }
    }
    public static void DisplayList(List<CurrencyDetails> List){
        for (CurrencyDetails currencyDetails : List) {
            String currency = currencyDetails.getCurrency();
            double value = currencyDetails.getValue();
            int units = currencyDetails.getUnits();
            System.out.println(currency + ": " + value + " (Units: " + units + ")");
        }
    }
    public static void DisplayConvertedValues() {
        for (String convertedValue : convertedValuesList) {
            System.out.println(convertedValue);
        }
    }
}

class CurrencyDetails {
    private final String currency;
    private final double value;
    private final int units;

    public CurrencyDetails(String currency, double value, int units) {
        this.currency = currency;
        this.value = value;
        this.units = units;
    }

    public String getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    public int getUnits() {
        return units;
    }
}
