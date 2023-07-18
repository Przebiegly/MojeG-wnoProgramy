package HelpMeAmStuck.BankingByMeAttemptUno;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;



public class Bank {
    private static ArrayList<User> users = new ArrayList<>();
    private static int theI;
    public static boolean CheckIfLoginIsCorrect(String Login, String Password ){
        boolean IsTrue = false;
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new File("resources/AdamInBank/Login&password"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(int i = 0; i<users.size();i++){
            String tempLogin = users.get(i).login;
            String tempPassword = users.get(i).password;

            if(tempLogin.equals(Login) && tempPassword.equals(Password)){
                theI = i;
                IsTrue = true;
            }

        }

        return IsTrue;
    }
    public static int CurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int CurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH) + 1; // add 1 because Calendar.MONTH starts from 0
    }

    public static int CurrentDay() {
        return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    public static String CurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(Calendar.getInstance().getTime());
    }
    private static double IntrestRate(int Age){
        if(Age > 18 && Age < 26){
            return 0.02;
        }else if(Age >= 26 && Age < 40 ){
            return 0.08;
        }else if(Age >= 40 && Age < 50 ){
            return 0.05;
        }else if(Age >= 50 && Age < 60){
            return 0.02;
        }else {
            return 0.01;
        }

    }
    private static String Waluta(){
        return "$";
    }
    public static void Logged(){
        Scanner sc = new Scanner(System.in);
        int userId = theI;

        String file = String.valueOf(userId)+".txt";
        String path = "resources/AdamInBank/UserFiles/"+file;
        FileWriter fw = null;
        Path paths = Path.of(path);
        if(!Files.exists(paths)){
            try {
                System.out.println("General Information:");
                System.out.print("Name: \n> ");
                String name = sc.nextLine();
                System.out.print("Surname: \n> ");
                String surname = sc.nextLine();
                System.out.print("Insert Age: \n> ");
                String Age = sc.nextLine();
                String BirthDate = "";
                System.out.print("Birth Day: \n> ");
                BirthDate += sc.nextLine();
                BirthDate += ".";
                System.out.print("Birth Month: \n> ");
                BirthDate += sc.nextLine();
                BirthDate += ".";
                System.out.print("Birth Year: \n> ");
                BirthDate += sc.nextLine();
                int age = Integer.parseInt(Age);
                System.out.print("Phone Number: \n> +48 ");
                String PhoneNum = sc.next();
                if(PhoneNum.length() > 9){
                    String PhoneNum2 = "";
                    for(int i = 1; i<10; i++){
                        PhoneNum2 += String.valueOf(PhoneNum.charAt(i));
                    }
                    PhoneNum = PhoneNum2;
                }
                System.out.print("Insert First Deposit\n> ");
                int Deposit = sc.nextInt();
                Files.createFile(paths);
                fw = new FileWriter(path, true);
                fw.write("-------------------------\n");
                fw.write("   General Information: \n");
                fw.write("ID: #"+userId+"\n");
                fw.write("Account Login: "+users.get(userId).login+"\n");
                fw.write("Account Password: "+users.get(userId).password+"\n");
                fw.write("Account Creation: "+CurrentDate()+"\n");
                fw.write("Name: "+name+" Surname: "+surname+"\n");
                fw.write("Birth: "+BirthDate+" Age: "+age+"\n");
                fw.write("Phone: "+PhoneNum+" \n");
                fw.write("-------------------------\n");
                fw.write("Last login: "+CurrentDate()+"\n");
                fw.write("-------------------------\n");
                fw.write("Deposit: "+Deposit+"\n");
                fw.write("Last Deposit: "+Deposit+"\n");
                fw.write("Loan: 0\n");
                fw.write("Invested: 0\n");
                fw.write("-------------------------\n");





                fw.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Account Information Updated");
            System.out.println("Login Once More to verify");
        }
        else {
            Scanner fr = null;
            try {
                fr = new Scanner(paths);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            List<String>Lista = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "."));
            ArrayList<String> FileOutput = new ArrayList<>();
            while(fr.hasNextLine()){
                FileOutput.add(fr.nextLine());
            }
            String TextToSetAboutCurrentDate = "Last login: "+ CurrentDate();
            for(int i = 0; i< FileOutput.size(); i++){
                if(FileOutput.get(i).contains("Last login:")){

                    FileOutput.set(i,TextToSetAboutCurrentDate);

                }
            } // Ustawianei obecnej daty logowania

            //-------------------------------------------//
            String birthDate = "";
            int userAge = 0;
            int birthYear = 0;
            int birthMonth = 0;
            int birthDay = 0;
            int iofAge = -1;

            for (int i = 0; i < FileOutput.size(); i++) {
                if (FileOutput.get(i).contains("Birth: ")) {
                    iofAge = i;
                    String[] parts = FileOutput.get(i).split(" ");
                    birthDate = parts[1];
                    userAge = Integer.parseInt(parts[3]);
                    break;
                }
            }

            if (!birthDate.isEmpty()) {
                String[] dateParts = birthDate.split("\\.");
                birthDay = Integer.parseInt(dateParts[0]);
                birthMonth = Integer.parseInt(dateParts[1]);
                birthYear = Integer.parseInt(dateParts[2]);

                int currentYear = CurrentYear();
                int currentMonth = CurrentMonth();
                int currentDay = CurrentDay();

                userAge = currentYear - birthYear;

                if (birthMonth > currentMonth || (birthMonth == currentMonth && birthDay > currentDay)) {
                    userAge--;
                }

                String ageToSet = "Birth: " + birthDate + " Age: " + userAge;
                FileOutput.set(iofAge, ageToSet);
            }


            //------------------------------------------------//
            boolean end = false;
            while(!end){//Tutaj będą działania urzytkowniaka
                Double Deposit;
                String StringDeposit = "";
                String NewStringDeposit = "";
                for(int i = 0; i< FileOutput.size(); i++){
                    if(FileOutput.get(i).contains("Deposit: ")){
                        StringDeposit = FileOutput.get(i);
                    }
                } // Przyjmowanie String Depozytu
                for(int i = 0; i< StringDeposit.length();i++){
                    String Temp = String.valueOf(StringDeposit.charAt(i));
                    if(Lista.contains(Temp)){
                        NewStringDeposit += Temp;
                    }
                } // Dodawanie nowego depozytu
                Deposit = Double.valueOf(NewStringDeposit); // zmienna liczbowa depozytu
                String GetNewLoan = "";
                String GetLoan = "";
                for(int i = 0; i< FileOutput.size(); i++){
                    if(FileOutput.get(i).contains("Loan: ")){
                        GetNewLoan = FileOutput.get(i);
                    }
                }
                for(int i = 0; i< GetNewLoan.length();i++){
                    String Temp = String.valueOf(GetNewLoan.charAt(i));
                    if(Lista.contains(Temp)){
                        GetLoan += Temp;
                    }
                }

                Double Invest;
                String StringInvest = "";
                String NewStringInvest = "";
                for(int i = 0; i< FileOutput.size(); i++){
                    if(FileOutput.get(i).contains("Invested: ")){
                        NewStringInvest = FileOutput.get(i);
                    }
                }
                for(int i = 0; i< NewStringInvest.length();i++){
                    String Temp = String.valueOf(NewStringInvest.charAt(i));
                    if(Lista.contains(Temp)){
                        StringInvest += Temp;
                    }
                }
                Invest = Double.parseDouble(StringInvest);


                System.out.println("--------------------");
                System.out.println("Deposit: "+Deposit+" "+Waluta());
                System.out.println("Loan: "+GetLoan+" "+Waluta());
                System.out.println("Current Investment: "+Invest+" "+Waluta());
                System.out.println("");
                System.out.print("User Action: \n> ");
                String UserAction = sc.nextLine();
                String DepositToAdd = "";
                Double DepositToAddDouble = 0.0;
                Double GetLoanDouble = Double.parseDouble(GetLoan);
                Double Loan = 0.0;
                String InvestToAddString = "";
                Double InvestToAdd = 0.0;

                if(UserAction.startsWith("+")){
                    for(int i = 0; i< UserAction.length();i++){
                        String Temp = String.valueOf(UserAction.charAt(i));
                        if(Lista.contains(Temp)){
                            DepositToAdd += Temp;
                        }
                    }
                    UserAction = "+";
                }
                else if (UserAction.startsWith("-")) {
                    for(int i = 0; i< UserAction.length();i++){
                        String Temp = String.valueOf(UserAction.charAt(i));
                        if(Lista.contains(Temp)){
                            DepositToAdd += Temp;
                        }
                    }
                    UserAction = "-";
                }
                else if (UserAction.startsWith("invest") || UserAction.startsWith("inv")) {
                    for(int i = 0; i< UserAction.length();i++){
                        String Temp = String.valueOf(UserAction.charAt(i));
                        if(Lista.contains(Temp)){
                            InvestToAddString += Temp;
                        }
                    }
                    InvestToAdd = Double.parseDouble(InvestToAddString);
                    UserAction = "invest";
                }
                //----------------------------------//
                switch (UserAction){


                    case "+"->{
                        DepositToAddDouble = Double.parseDouble(DepositToAdd);
                        Deposit = Deposit + DepositToAddDouble;
                    }
                    case "-"->{
                        DepositToAddDouble = Double.parseDouble(DepositToAdd);
                        Deposit = Deposit - DepositToAddDouble;
                    }
                    case "info"->{

                        System.out.println("Account Details");
                        for (int i = 0; i< FileOutput.size(); i++){
                            System.out.println(FileOutput.get(i));
                        }
                        System.out.println("Account Details Are Above");
                    }
                    case "invest"->{
                        Deposit = Deposit - InvestToAdd;
                        if(Deposit >0){
                            Invest = Invest + InvestToAdd;
                        }else {
                            Deposit = Deposit + InvestToAdd;
                            System.out.println("Cannot Invest");
                        }

                    }

                    case "end"->{
                        System.out.println("Shutting down Program!");
                        end = true;
                    }
                    case "exit"->{
                        System.out.println("Logging out!");
                        end = true;
                    }
                    default -> {
                        System.out.println("Cannot resolve Action: "+UserAction);
                        System.out.println("If you want to logout try to use Action: 'exit' or 'end' ");
                    }
                }




                if(Deposit < 0){
                    Loan = Deposit;
                    Deposit = 0.0;
                    Math.abs(Loan);
                    GetLoanDouble = GetLoanDouble + Loan;
                }
                if(Deposit > 0 && GetLoanDouble > 0){
                    if(Deposit > GetLoanDouble){
                        Deposit = Deposit - GetLoanDouble;
                        GetLoanDouble = 0.0;
                    }else {
                        GetLoanDouble = GetLoanDouble - Deposit;
                        Deposit = 0.0;
                    }

                }
                String TextInvest = "Invested: "+Invest;
                for(int i = 0; i< FileOutput.size(); i++){
                    if(FileOutput.get(i).contains("Invested: ")){

                        FileOutput.set(i,TextInvest);
                    }
                }
                String TextLoan = "Loan: "+GetLoanDouble;
                for(int i = 0; i< FileOutput.size(); i++){
                    if(FileOutput.get(i).contains("Loan: ")){

                        FileOutput.set(i,TextLoan);
                    }
                }
                String TextDeposit = "Deposit: "+Deposit;
                for(int i = 0; i< FileOutput.size(); i++){
                    if(FileOutput.get(i).contains("Deposit: ")){

                        FileOutput.set(i,TextDeposit);

                    }
                } //Dodaje do arraylisty aktualny depozyt

            }


            try {
                fw = new FileWriter(path,false);
                for(int i = 0; i< FileOutput.size(); i++){
                    fw.write(FileOutput.get(i)+"\n");
                }
                fw.close();
            } catch (IOException e) { // Zwraca wszystko do pliku
                throw new RuntimeException(e);
            }

            System.out.println("-----");
        }


    }

    public static boolean HasNoCoppy(String P){
        for (User user : users) {
            String p = user.login;
            if (p.equals(P)) {
                return false;
            }
        }
        return true;
    }
    public static void BankBegin() {
        Scanner sc = new Scanner(System.in);

        String Login = "";
        String Password = "";
        boolean end = false;
        boolean forceExit = false;

        while(!end){

            int id = 0;
            Scanner fileScanner;
            try {
                fileScanner = new Scanner(new FileReader("resources/AdamInBank/Login&password"));
            }
            catch (IOException e) {
                System.out.println("Failed To Read File");
                return;
            }
            users.clear();
            while(fileScanner.hasNext()) {
                users.add(new User(fileScanner.next(), fileScanner.next(), id));
                id++;
            }
            fileScanner.close();
            System.out.print("Login > ");
            Login = sc.next();
            if(Login.equals(".end")) {
                end = true;
                continue;
            }
            System.out.print("Password > ");
            Password = sc.next();
            if(Password.equals(".end")) {
                end = true;
                continue;
            }
            boolean IsLoginOK = CheckIfLoginIsCorrect(Login,Password);
            if(IsLoginOK){
                Logged();
            }
            else {
                System.out.println("User not Found! Try to create account");
                boolean end2 = false;

                while (!end2){
                    System.out.print("Create Login > ");
                    Login = sc.next();
                    if(Login.equals(".end")){
                        end2 = true;
                        forceExit = true;
                        continue;
                    }

                    boolean HasNoCoppy = HasNoCoppy(Login);
                    if(HasNoCoppy){
                        end2 = true;
                        continue;
                    }else {
                        System.out.println("User Exist!");
                    }
                }

                if (forceExit){
                    end = true;
                    continue;
                }

                System.out.print("Insert Password > ");
                Password = sc.next();
                String PasswordAgain = "";
                if(Password.equals(".end")){
                    end = true;
                    continue;
                }

                while(!Objects.equals(Password, PasswordAgain)){
                    System.out.print("Insert Password Again > ");
                    PasswordAgain = sc.next();
                    if(PasswordAgain.equals(".end")){
                        forceExit = true;
                        break;
                    }
                }
                if (forceExit){
                    end = true;
                    continue;
                }

                String WhatToWrite = Login+" "+Password;
                String Path = "resources/AdamInBank/Login&password";


                try{
                    FileWriter fw = new FileWriter(Path, true);
                    fw.write("\n");
                    fw.write(WhatToWrite);
                    fw.close();




                    System.out.println("Account Successfully Created!");
                    //Logged();
                    int id2 = 0;
                    Scanner fileScanner2;
                    try {
                        fileScanner2 = new Scanner(new FileReader("resources/AdamInBank/Login&password"));
                    }
                    catch (IOException e) {
                        System.out.println("Failed To Read File");
                        return;
                    }
                    users.clear();
                    while(fileScanner2.hasNext()) {
                        users.add(new User(fileScanner2.next(), fileScanner2.next(), id2));
                        id2++;
                    }
                    boolean CanLogIn = CheckIfLoginIsCorrect(Login,Password);
                    if(CanLogIn){
                        Logged();
                    }else {
                        System.out.println("System Failed To Login\nTry to Log once more!\n");
                    }
                }catch (IOException e) {
                    System.out.println("Failed To Read File");
                    return;
                }




            }

        }

    }

    public static void printUsers() {
        for (User u : users) {
            System.out.printf("Login: %s\nPassword: %s\nId: %d\n", u.getLogin(), u.getPassword(), u.getId());

        }
    }
}


