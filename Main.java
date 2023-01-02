import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Main {

    static Scanner scan = new Scanner(System.in);
    public static String JarName(int FNI){
        String name = "";
        switch (FNI){
            case 1 ->{
                name = "Orange";
            }case 2->{
                name = "Strawberry";
            }case 3 ->{
                name = "Banana";
            }case 4->{
                name = "Kaszanka";
            }
        }
        return name;
    }

    public static String CompanyName(){
        Random rnd = new Random();
        String name = "";
        int rand = rnd.nextInt(1,32);
        int temp;
        char tempCher;
        for(int i = 0; i<rand; i++){
            temp = rnd.nextInt(1,32);
            tempCher = (char) temp;
            name += tempCher;
        }

        return name;
    }

    public static void Company(){

        Random rand = new Random();
        String nip = "";
        int temp;
        String name;
        for(int i = 0; i<10; i++){
            temp = rand.nextInt(0,9);
            nip += temp;
        }

        name = CompanyName();
        Firma firma = new Firma(nip,name,1);

        System.out.print("Firma "+firma.name+" | "+firma.id+" | "+firma.nip);
    }
    public static void Worker(){

        String name = "Jan";
        String CompanyName;

        CompanyName = CompanyName();
        Płacownik worker = new Płacownik(1,name, CompanyName);

        System.out.println(" Worker "+worker.name+" | "+worker.id+" | "+worker.CompanyName);
    }
    public static void SwitchWorkerCompany(String phrase){

        switch (phrase){
            case "worker"->{
                Worker();
            }
            case "company"->{
                Company();
            }default -> {
                System.out.println("Nie znaleziono "+phrase);
            }

        }
    }
    public static void CountInTable(int table[]){
        int positive = 0;
        int negative = 0;
        int zero = 0;
        int temp;


        for(int i = 0; i< table.length;i++){
            temp = table[i];

            if(temp>0){
                positive = positive +temp;

            } else if (temp<0) {
                negative++;
            }else {
                zero++;
            }

        }
        int[] table2 = new int[]{negative, positive, zero};
        System.out.println(Arrays.toString(table2));
    }

    /*public static void AddToCloset(Jar[] j, int x ){

        closet.Closet.add(j[x].position_id,j[x].flavour);

    }
*/
    public static void CreateJar(Jar[] Jar ){
        Random rand = new Random();
        String flavName;
        int rnd;

        for(int ii = 0; ii<Jar.length; ii++){
            rnd = rand.nextInt(1,4);
            flavName = JarName(rnd);
            rnd = rand.nextInt(101);

        Jar[ii] = new Jar(false, 100, rnd, flavName, ii);


        }


    }
    public static void Switch(String phrase3){
        boolean end = false;
        String phrase2 = "";

        switch (phrase3){
            case "jar" ->{
                Jar[] Jar2 = new Jar[100];
                CreateJar(Jar2);
                while(!end){

                    Arrays.stream(Jar2).forEach(e-> System.out.println("#"+ Jar2[e.position_id].position_id + " | " + Jar2[e.position_id].value
                    +" | "+Jar2[e.position_id].flavour + " | " +Jar2[e.position_id].capacity + " | "+Jar2[e.position_id].IsOpen));
                    System.out.print("> ");
                    phrase2 = scan.next();

                    if(phrase2.equals("end")){
                        end = true;
                        continue;
                    }if(phrase2.equals("change")){

                        //Wstaw opcje zmiany wartości
                    }




                }




            }case "tab" ->{
                Random rand = new Random();
                int rnd = rand.nextInt(16);
                int[] tab = new int[rnd];
                for(int i = 0; i< tab.length; i++){
                    int random = rand.nextInt(-10,10);
                    tab[i] = random;
                }
                CountInTable(tab);



            }case "automat" ->{

                String phrase4;
                System.out.print("> ");
                phrase4 = scan.next();


            }case "temat1" ->{

                String phrase5;

                System.out.print("> ");
                phrase5 = scan.next();
                SwitchWorkerCompany(phrase5);

            }case "zad5" ->{

            }
        }
    }

    public static void main(String[] args) {



        String phrase;
        boolean end2 = false;

        while(!end2){

            System.out.println();
            System.out.println("<--------------->");
            System.out.print("> ");
            phrase = scan.next();

            if(phrase.equals("end")){
                end2 = true;
                continue;
            }
            Switch(phrase);



        }
    }
}
