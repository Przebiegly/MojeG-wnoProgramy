import java.util.Arrays;
import java.util.Random;

public class Main {

    public static String NameTabel(int index){
        Random rand = new Random();

        String FullName = "";
        String x;
        String y;
        String[] names = {"Jan","Kamil","Hubert","Adrian","Sasza",
       "Eugieni","Huan","Huen","Jin","Albert","John","Rohan",
        "Cyprian","Marcallo"};
        String[] surnames = {"Bam","King","Kowalski","Something","Universe","Mona","Johnson","Simson"};
        index = rand.nextInt(14);
        x = names[index];
        index = rand.nextInt(8);
        y = surnames[index];
        FullName = x;
        FullName += " ";
        FullName += y;


    return FullName;
    }


    public static void main(String[] args) {
        Random rnd = new Random();


        int randomer = rnd.nextInt(100);
        String name = "";

        Variable[] variables = new Variable[randomer];

        for (int i = 0; i< randomer; i++){
            int rand = rnd.nextInt(3000);
            name = NameTabel(i);
            variables[i] = new Variable(rand,name , i);
        }

        Arrays.stream(variables).forEach(e ->{
            System.out.printf("%s: %d pts  #%d\n", e.name, e.points, e.id);
        });

    }
}