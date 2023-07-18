import HelpMeAmStuck.Voids.Voids;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String Input = "";
        while(true){
            Voids.DisplayDevider1();
            Voids.DisplayInputArrow();
            Input = Voids.sc.nextLine();
            if(Voids.EndingProgram(Input)) break;
            //Voids.DisplayDevider1();
            Voids.SwitchBetweenPrograms(Input);
            Voids.DisplayDevider1();
        }

    }

}
