package HelpMeAmStuck.TicTacToe;

import HelpMeAmStuck.Voids.Voids;

import java.util.Objects;

public class TicTacToe {

    private static String[][] Board = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
    public static void TicTac(){
        System.out.println("TicTacToe");
        Voids.DisplayDevider3();

        String input;
        int turn = 1;

        String Player1 = "X";
        String Player2 = "O";
        while(true){

            System.out.println("Turn: "+turn+" | "+Player1);
            DisplayBoard(Board);

            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if(Voids.EndingProgram(input)){
                System.out.println("Game ended by resignation ");
                System.out.println(Player2+" Won!");
                break;
            }
            PopulateBoard(Board,input,Player1);
            if(CheckIfWin(Board)){
                System.out.println(Player1+" Won!");
                break;
            };

            turn++;
            if(turn>=10){
                System.out.println("Draw");
                break;
            }

            System.out.println("Turn: "+turn+" | "+Player2);
            DisplayBoard(Board);

            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if(Voids.EndingProgram(input)) {
                System.out.println("Game ended by resignation ");
                System.out.println(Player1+" Won!");
                break;
            }
            PopulateBoard(Board,input,Player2);
            if(CheckIfWin(Board)){
                System.out.println(Player1+" Won!");
                break;
            };

            turn++;
            if(turn>=10){
                System.out.println("Draw");
                break;
            }

        }
    }

    private static void DisplayBoard(String[][] Board){
        for(int i = 0; i<3; i++){
            for(int ii = 0; ii<3; ii++){
                if(ii == 0){
                    System.out.print("        | "+Board[i][ii]+" | ");
                }else{
                    System.out.print(Board[i][ii]+" | ");
                }

            }
            System.out.println();
        }
    }

    private static boolean CheckIfWin(String[][] Board){
        if(Objects.equals(Board[0][0], Board[0][1]) && Objects.equals(Board[0][0], Board[0][2]) ||
           Objects.equals(Board[1][0], Board[1][1]) && Objects.equals(Board[1][0], Board[1][2]) ||
           Objects.equals(Board[2][0], Board[2][1]) || Objects.equals(Board[2][0], Board[2][2]) ||
           Objects.equals(Board[0][0], Board[1][0]) || Objects.equals(Board[0][0], Board[2][0]) ||
           Objects.equals(Board[0][1], Board[1][1]) && Objects.equals(Board[0][1], Board[2][1]) ||
           Objects.equals(Board[0][2], Board[1][2]) && Objects.equals(Board[0][2], Board[2][2]) ||
           Objects.equals(Board[0][0], Board[1][1]) || Objects.equals(Board[0][0], Board[2][2]) ||
           Objects.equals(Board[0][2], Board[1][1]) || Objects.equals(Board[0][2], Board[2][0])
        ){
            return true;
        }


        return false;
    }

    private static void PopulateBoard(String[][] Board,String input,String Player){
        for(int i = 0; i<3; i++){
            for(int ii = 0; ii<3; ii++){
                if(Board[i][ii].equals(input)){
                    Board[i][ii] = Player;
                }
            }
        }
    }
}
