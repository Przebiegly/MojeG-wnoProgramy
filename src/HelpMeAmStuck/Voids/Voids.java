package HelpMeAmStuck.Voids;

import java.io.IOException;
import java.util.*;

import HelpMeAmStuck.BankingByMeAttemptUno.Bank;
import HelpMeAmStuck.Calculators.*;
import HelpMeAmStuck.Chemia.Chemia;
import HelpMeAmStuck.Countries.NamingCountriesQuiz;
import HelpMeAmStuck.DisplayInfo.DisplayInfo;
import HelpMeAmStuck.EncryptionAndDecryption.HowToDoThisWhenYou;
import HelpMeAmStuck.EncryptionAndDecryption.KeyGenerationExample;
import HelpMeAmStuck.EncryptionAndDecryption.MorseCodeAttempt1;
import HelpMeAmStuck.GameRelatedButNotGames.ChampionStatsApp;
import HelpMeAmStuck.GameRelatedButNotGames.SionCalculator;
import HelpMeAmStuck.Games.CardGamesIGuess;
import HelpMeAmStuck.Games.MiniSweeperIGGuess;
import HelpMeAmStuck.Games.RubiksCube;
import HelpMeAmStuck.Games.TwoZeroFourEight;
import HelpMeAmStuck.Genge.*;
import HelpMeAmStuck.Othere.LettersAndCharacters;
import HelpMeAmStuck.Othere.Names;
import HelpMeAmStuck.Othere.Numbers;
import HelpMeAmStuck.Petri.*;
import HelpMeAmStuck.Speedway.Speedway;
import HelpMeAmStuck.SymetralnaOdcinka.SymetralnaOdcinka;
import HelpMeAmStuck.Test.BasicTest;
import HelpMeAmStuck.Test.CfromABinTriangleTest;
import HelpMeAmStuck.Test.FindDonAxisTest;
import HelpMeAmStuck.Test.TwoZeroFourEightTest;
import HelpMeAmStuck.TicTacToe.TicTacToe;
import HelpMeAmStuck.Weebs.FirstWeeb;
import HelpMeAmStuck.Weebs.SecondWeeb;
import HelpMeAmStuck.Weebs.ThirdWeeb;
import HelpMeAmStuck.WithThisCode.ImageExtractor;


public class Voids {

    public static Random random = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static boolean EndingProgram(String UserInput) {
        return UserInput.equals("end") || UserInput.equals("quit") || UserInput.equals("exit");
    }

    public static void SwitchBetweenPrograms(String UserInput) throws IOException {
        switch (UserInput) {

            case "test1" ->{
                int x = 0;
                int y = 0;
                System.out.println("New Test");
                DisplayDevider2();
                System.out.println("Number x:");
                DisplayInputArrow();
                x = sc.nextInt();
                System.out.println("Number y:");
                DisplayInputArrow();
                y = sc.nextInt();
                BasicTest basicTest = new BasicTest();
                basicTest.runTest(x,y);


            }
            case "test2" ->{
                CfromABinTriangleTest ctest = new CfromABinTriangleTest();
                ctest.testCalculation();
            }
            case "test3" ->{
                FindDonAxisTest fnd = new FindDonAxisTest();
                fnd.testFindingD();
            }
            case "test4" ->{
                TwoZeroFourEightTest TwoZeroFourEightTest = new TwoZeroFourEightTest();
                TwoZeroFourEightTest.runTest();
            }

            case "sqrt" -> SqrtCal.SqrtGet(1,0);
            case "heron" -> HeronsCalculator.CalculateHeron();
            case "bakh" -> BakhshaliCalculator.CalculateBakhshali();
            case "Sym" -> SymetralnaOdcinka.Symetralna();
            case "cal" -> BasicCalculator.Calculator();
            case "Ft" -> StoopkyCalculator.FancyFeats();
            case "Tri1" -> CfromABinTriangle.GettingDone();
            case "exchange" -> ExchangeCalculator.Exchange();
            case "euclid" -> EuclideanAlgorithm.Algorithmically();
            case "marka" -> PolishMarkaToPolishZloty.WhereTheMarkGo();

            case "chem" -> Chemia.ChemiaPick();

            case "SpeedwayMatch" -> SpeedwayMatch();

            case "tictac" -> TicTacToe.TicTac();

            case "QuizC1" -> NamingCountriesQuiz.Game();

            case "Baus" -> SionCalculator.BausLaw();
            case "2048" -> TwoZeroFourEight.Game();
            case "minesweeper" -> MiniSweeperIGGuess.LunchGame();
            case "cards" -> CardGamesIGuess.SelectingGameMode();
            case "lol1" -> ChampionStatsApp.Test();
            case "qube" -> RubiksCube.game();

            case "Genge" -> GengeSwitch();
            case "lotto" -> GengeLotto.Kumulacja();

            case "note1" -> NotepadApp.Swinger();
            case "note2" -> NotepadApp2.Swinger2();
            case "note3" ->NotepadApp3.Swinger3();
            case "enote1" -> ExtendedNotepadApp1.Lunch();
            case "enote2" -> ExtendedNotepadApp2UIForm.Lunch();

            case "key1" -> KeyGenerationExample.GettingKeys();

            case "bank1" -> Bank.BankBegin();
            case "bank2" -> HelpMeAmStuck.BankingByMeAttemptDuo.Bank.BankingIGuess();

            case "morse" -> MorseCodeAttempt1.Code();
            case "encrypt1" -> HowToDoThisWhenYou.AreDumb();

            case "LunchWeeb1" -> FirstWeeb.Weeb();
            case "LunchWeeb2" -> SecondWeeb.Weeb();
            case "lunchWeeb3" -> ThirdWeeb.Weeb();

            case "tractor" -> ImageExtractor.Tractor();

            case "shutdown" -> System.exit(0);
            default -> DisplayInfo.Info();
        }
    }

    //---------------------------------------------------//
    //                  Visual Effects
    private static final String VisualInputArrow = "> ";
    private static final String VisualDevider = "--------------------";
    private static final String SmallVisualDevider = "----------";
    private static final String MiniVisualDevider = "---";

    public static void DisplayInputArrow() {
        System.out.print(VisualInputArrow);
    }

    public static void DisplayDevider1() {
        System.out.println(VisualDevider);
    }

    public static void DisplayDevider2() {
        System.out.println(SmallVisualDevider);
    }

    public static void DisplayDevider3() {
        System.out.println(MiniVisualDevider);
    }

    public static void Sleep1sec(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void Sleep2sec(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //---------------------------------------------------//
    public static double ConvertToDecimal(String value) {
        if (value.contains("/")) {
            String[] fraction = value.split("/");
            double numerator = Double.parseDouble(fraction[0]);
            double denominator = Double.parseDouble(fraction[1]);
            return numerator / denominator;
        } else {
            return Double.parseDouble(value);
        }
    }
    //---------------------------------------------------//

    //---------------------------------------------------//
    // HelpMeAmStuck.SymetralnaOdcinka.SymetralnaOdcinka:

    private static double Ax;
    private static double Ay;
    private static double Bx;
    private static double By;
    // Where are points A i B A(x,y) B(x,y)
    private static double A1, A2; // A1 * A2 has to be always -1 to all be OK
    private static double Sx; // S(x,);
    private static double Sy; // S(,y);
    private static double B; // B from y = ax + b;
    private static double Y; // Y from y = ax + b;
    private static double X; // X from y = ax + b;

    private static void ConvertToDecimal2(String StrAx, String StrAy, String StrBx, String StrBy) {

        //Ax = Ax.replace('.',','); // For now not in use
        double a; // a = x * b
        double b; // b = a / x
        double x; // x = a / b Default

        String[] AxTab = {};
        if (StrAx.contains("/")) {
            AxTab = StrAx.split("/");
            a = Double.parseDouble(AxTab[0]);
            b = Double.parseDouble(AxTab[1]);

            x = a / b;

            Ax = x;

        } else {
            Ax = Double.parseDouble(StrAx);
        }

        String[] AyTab = {};
        if (StrAy.contains("/")) {
            AyTab = StrAy.split("/");
            a = Double.parseDouble(AyTab[0]);
            b = Double.parseDouble(AyTab[1]);

            x = a / b;

            Ay = x;

        } else {
            Ay = Double.parseDouble(StrAy);
        }
        String[] BxTab = {};
        if (StrBx.contains("/")) {
            BxTab = StrBx.split("/");
            a = Double.parseDouble(BxTab[0]);
            b = Double.parseDouble(BxTab[1]);

            x = a / b;

            Bx = x;

        } else {
            Bx = Double.parseDouble(StrBx);
        }

        String[] ByTab = {};
        if (StrBy.contains("/")) {
            ByTab = StrBy.split("/");
            a = Double.parseDouble(ByTab[0]);
            b = Double.parseDouble(ByTab[1]);

            x = a / b;

            By = x;

        } else {
            By = Double.parseDouble(StrBy);
        }

        DoSomeMath();

    }

    public static void DoSomeMath() {
        Sx = (Ax + (Bx)) / 2;
        Sy = (Ay + (By)) / 2;
        A1 = (By - (Ay)) / (Bx - (Ax));
        A2 = -1 / A1;
        X = Sx;
        Y = Sy;
        B = Y - (A2 * X);
    }

    public static void SymVoid(String Input1, String Input2) {
        String[] Atab = {}; // Tab to store inputs associated with Ax and Ay;
        String[] Btab = {}; // Tab to store inputs associated with Bx and By;

        String StringAx, StringAy, StringBx, StringBy; // Strings for inpust to Ax,Ay,Bx,By

        Atab = Input1.split(",");
        StringAx = Atab[0];
        StringAy = Atab[1];
        Btab = Input2.split(",");
        StringBx = Btab[0];
        StringBy = Btab[1];
        System.out.print("A(" + Atab[0] + "," + Atab[1] + ") B(" + Btab[0] + "," + Btab[1] + ") \n");

        ConvertToDecimal2(StringAx, StringAy, StringBx, StringBy);
        System.out.println("y = ax + b \n" + Y + " = " + A2 + " * " + X + " + " + B);
        System.out.println("y = " + A2 + "x + " + B);
        System.out.println("S(" + Sx + "," + Sy + ")");
        System.out.println("y = " + Y + " | a = " + A2 + " | x = " + X + " | b = " + B);
    }


    //---------------------------------------------------//
    // HelpMeAmStuck.Chemia.Chemia:

    public static void ChemiaSwitch(String I) {
        switch (I) {
            case "quiz" -> ChemiaQuiz();
            default -> System.out.println("Invalid command");
        }
    }

    private static void ChemiaQuizSwitch(String I) {
        switch (I) {
            case "1" -> ChemiaQuiz(5, 5);
            case "2" -> ChemiaQuiz(5, 10);
            case "3" -> ChemiaQuiz(10, 10);
            case "4" -> ChemiaQuiz(10, 15);
            case "5" -> ChemiaQuiz(15, 15);
            case "6" -> ChemiaQuiz(10, 20);
            case "7" -> ChemiaQuiz(15, 20);
            case "8" -> ChemiaQuiz(10, Elements.length);
            case "9" -> ChemiaQuiz(20, Elements.length);
            case "10" -> ChemiaQuiz(25, Elements.length);
            default -> System.out.println("Invalid number");
        }
    }

    private static void ChemiaQuiz() {
        String Input;
        if (ElementMapsAreEqual()) {
            while (true) {
                System.out.println("Select level from 1 to 10");
                Voids.DisplayInputArrow();
                Input = Voids.sc.nextLine();
                if (Voids.EndingProgram(Input)) break;
                ChemiaQuizSwitch(Input);
                DisplayDevider3();

            }
        } else {
            System.out.println("An Error Occurred");
        }

    }

    private static boolean ElementMapsAreEqual() {
        return ElementsPL.size() == ElementsENG.size();
    }

    private static Map<String, String> ElementsPL = Chemia.ChemiaPierwiastkiPL;
    private static Map<String, String> ElementsENG = Chemia.ChemiaPierwiastkiPL;
    public static String[] Elements = Chemia.elementSymbols;

    private static void ChemiaQuiz(int num1, int num2) {
        int points = 0;
        String UserAnwser;
        List<String> UsedElements = new ArrayList<>();
        for (int i = 0; i < num1; i++) {


            String Find;
            while (true) {
                int RandomNum = random.nextInt(num2);
                Find = Elements[RandomNum];
                if (!UsedElements.contains(Find)) {
                    UsedElements.add(Find);
                    break;
                }
            }


            System.out.print(Find + ": ");
            UserAnwser = sc.nextLine();
            if (UserAnwser.equals(ElementsENG.get(Find)) || UserAnwser.equals(ElementsPL.get(Find))) points++;
        }

        if (points == num1) {
            System.out.println("Perfect!");
        } else {
            double percent = (points / (double) num1) * 100;
            System.out.println("Completed!");
            System.out.printf("Points: %d/%d (%.2f%%)\n", points, num2, percent);
        }


    }
    //---------------------------------------------------//

    //---------------------------------------------------//
    // HelpMeAmStuck.Speedway.Speedway:

    private static List<Object> PlayerList1 = new ArrayList<>();
    private static List<Object> PlayerList2 = new ArrayList<>();

    private static void SpeedwayMatch() {
        String Team1 = "Staleczka";
        String Team2 = "Falubaz";


        Speedway speedway;
        // Create two teams with 10 random players each
        for (int i = 0; i < 10; i++) {
            int randomIndex1 = random.nextInt(Names.NamesList.length);
            int randomIndex2 = random.nextInt(Names.SureNamesList.length);
            String playerName = Names.NamesList[randomIndex1] + " " + Names.SureNamesList[randomIndex2];

            PlayerList1.add(speedway = new Speedway(playerName, 0));
        }
        for (int i = 0; i < 10; i++) {
            int randomIndex1 = random.nextInt(Names.NamesList.length);
            int randomIndex2 = random.nextInt(Names.SureNamesList.length);
            String playerName = Names.NamesList[randomIndex1] + " " + Names.SureNamesList[randomIndex2];
            PlayerList2.add(speedway = new Speedway(playerName, 0));
        }
        Speedway SpeedwayTeam1 = new Speedway(Team1, 0, PlayerList1);
        Speedway SpeedwayTeam2 = new Speedway(Team2, 0, PlayerList2);

        // Simulate a match between the two teams
        for (int i = 0; i < 13; i++) {
            String player1 = (String) PlayerList1.get(i);
            String player2 = (String) PlayerList1.get(i + 1);
            String player3 = (String) PlayerList2.get(i);
            String player4 = (String) PlayerList2.get(i + 1);

            int P1points = random.nextInt(10);
            int P2points = random.nextInt(10);
            int P3points = random.nextInt(10);
            int P4points = random.nextInt(10);


        }
    }
    //---------------------------------------------------//

    //---------------------------------------------------//
    // Calculator
    private static void Calculation(double num1, double num2, String Operator) {
        double result = 0;

        switch (Operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("Error: Divide by zero");
                } else {
                    result = num1 / num2;
                }
            }
            case "*" -> result = num1 * num2;
            case "^" -> result = Math.pow(num1, num2);
            case "%" -> result = Math.sqrt(num1);
            case "!" -> result = Math.abs(num2);
            case "cos" -> result = Math.cos(num2);
            case "sin" -> result = Math.sin(num2);
            case "tg" -> result = Math.tan(num2);
            case "ctg" -> result = 1.0 / Math.tan(num2);
            case "atan" -> result = Math.atan(num2);
            case "log" -> result = Math.log(num2) / Math.log(num1);
            case "sym" -> SymetralnaOdcinka.Symetralna();
            case "sqrtget" -> SqrtCal.SqrtGet(0,num2);
            case "Ft" -> StoopkyCalculator.FancyFeats();
            case "Tri1" -> CfromABinTriangle.GettingDone();

            default -> {
                result = 0;
            }
        }
        GlobalResult = result;

    }
    public static double GlobalResult;
    public static void BasicCalculator(String input) {

        String Num1String = "";
        String Num2String = "";
        String Operator = "";
        double Num1 = 0;
        double Num2 = 0;
        int ii = 0;

        for(int i = 0; i<input.length(); i++){

            if(ii == 0){
                if(Numbers.ListNumbers.contains(String.valueOf(input.charAt(i)))){
                    Num1String += String.valueOf(input.charAt(i));
                } else if (!(input.charAt(i) == ' ')) {
                    if(LettersAndCharacters.LetterList.contains(String.valueOf(input.charAt(i)))
                            || LettersAndCharacters.SymbolsForMathList.contains(String.valueOf(input.charAt(i)))){

                        Operator += String.valueOf(input.charAt(i));
                        ii++;
                    }
                }
            } else if(ii == 1){
                if(LettersAndCharacters.LetterList.contains(String.valueOf(input.charAt(i)))
                        || LettersAndCharacters.SymbolsForMathList.contains(String.valueOf(input.charAt(i)))){
                    Operator += String.valueOf(input.charAt(i));
                } else if (!(input.charAt(i) == ' ')) {
                    if(Numbers.ListNumbers.contains(String.valueOf(input.charAt(i)))){
                        Num2String += String.valueOf(input.charAt(i));
                        ii++;
                    }
                }
            } else if (ii == 2) {
                if(Numbers.ListNumbers.contains(String.valueOf(input.charAt(i)))){
                    Num2String += String.valueOf(input.charAt(i));
                }
            }
        }


        if(!(Num1String.isEmpty())){
            Num1 = Double.parseDouble(Num1String);
        }
        if(!(Num2String.isEmpty())){
            Num2 = Double.parseDouble(Num2String);
        }
        Calculation(Num1,Num2,Operator);
        System.out.println("= "+GlobalResult);
    }

    //---------------------------------------------------//

    //---------------------------------------------------//
    // Genge Switch

    public static void GengeSwitch(){
        String Input;
        DisplayDevider2();
        System.out.println("Zadania Do Pana Marka");
        DisplayDevider2();
        DisplayInputArrow();
        Input = sc.nextLine();

        switch (Input){
            case "exe"->GengeExeptions.GengeExeption();
            case "lotto"-> GengeLotto.Kumulacja();
            case "json" -> GengeJSON.GetThisJSONRight();
            case "thread" -> GengeThreads.GimeMeThreads();
            case "jar" -> GengeJar.Jars();
            case "stack" ->GengeStack.Stacking();
            case "hanoi" ->GengeHanoi.Tower();

            default -> {
                System.out.println("Wrong program! Exiting GSwitch");

            }
        }
        DisplayDevider2();
    }

    //---------------------------------------------------//

    //---------------------------------------------------//
    //

    //---------------------------------------------------//
}
