package HelpMeAmStuck.SymetralnaOdcinka;

import HelpMeAmStuck.Voids.Voids;

public class SymetralnaOdcinka {
    public static void Symetralna(){
        String Input1;
        String Input2;
        while(true){

        System.out.print("A ");
        Voids.DisplayInputArrow();
        Input1 = Voids.sc.nextLine();
        if(Voids.EndingProgram(Input1)) break;

        System.out.print("B ");
        Voids.DisplayInputArrow();
        Input2 = Voids.sc.nextLine();
        if(Voids.EndingProgram(Input2)) break;
        Voids.SymVoid(Input1,Input2);
        }

    }
}
