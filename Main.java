import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class Main {

    public static String NameTabel(int index){
        Random rand = new Random();

        String FullName = "";
        String x;
        String y;
        String[] names = {"Jan","Kamil","Hubert","Adrian","Sasza",
                "Eugieni","Huan","Huen","Jin","Albert","John","Rohan",
                "Cyprian","Marcallo","Graham","Joshua","RandomChineseCitizen"};
        String[] surnames = {"Bam","King","Kowalski","Something","Universe","Mona","Johnson",
                "Simson","Citizen 1","Graham","Polak","Litwin","Siekiewicz","Dolny","Gorny",
                "Strzeczewski"};
        index = rand.nextInt(0,17);
        x = names[index];
        index = rand.nextInt(0,16);
        y = surnames[index];
        FullName = x;
        FullName += " ";
        FullName += y;


        return FullName;
    }

    public static int GetPlayerElo(Ozoba[] ozobas, int id) {
        for (Ozoba ozoba : ozobas) {
            if (ozoba.id == id) {
                return ozoba.points;
            }
        }
        return -1;
    }

    public static void Game(int id1, int id2, Ozoba[] ozobas){

        Random rnd = new Random();

        int player1_elo = GetPlayerElo(ozobas, id1);
        int player2_elo = GetPlayerElo(ozobas, id2);

        int EloCap = player1_elo + player2_elo;
        int Rand = rnd.nextInt(EloCap+1);

        int draw_range = Math.abs(player1_elo - player2_elo);

        int player_range = draw_range / 2;

        player1_elo -= player_range;
        player2_elo -= player_range;

        int playedGamesP1 = ozobas[id1].playedGames;
        int playedGamesP2 = ozobas[id2].playedGames;

        ozobas[id1].against.add(playedGamesP1, ozobas[id2].id);
        ozobas[id2].against.add(playedGamesP2, ozobas[id1].id);

        if (Rand <= player1_elo) {
            ozobas[id1].wins += 1;
            ozobas[id2].table.add(playedGamesP2, "L");
            ozobas[id1].table.add(playedGamesP1, "W");
            ozobas[id1].GamePoints += 3;
            ozobas[id2].playedGames += 1;
            ozobas[id1].playedGames += 1;
        }else if (Rand >= player1_elo+1 && Rand <= player1_elo + draw_range){
            ozobas[id2].table.add(playedGamesP2, "D");
            ozobas[id2].GamePoints += 1;
            ozobas[id1].table.add(playedGamesP1, "D");
            ozobas[id1].GamePoints += 1;
            ozobas[id2].playedGames += 1;
            ozobas[id1].playedGames += 1;
        }else{
            ozobas[id2].wins += 1;
            ozobas[id2].table.add(playedGamesP2, "W");
            ozobas[id2].GamePoints += 3;
            ozobas[id1].table.add(playedGamesP1, "L");
            ozobas[id2].playedGames += 1;
            ozobas[id1].playedGames += 1;
        }

    }
    public static void CumySort(Ozoba [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j].GamePoints > array[j + 1].GamePoints) {
                    int temp = array[j + 1].GamePoints;
                    array[j].GamePoints = array[j + 1].GamePoints;
                    array[j + 1].GamePoints = temp;
                }
            }
        }
    }
    public static void PlayOffs(Ozoba [] array){
        //todo do this leaderboard and put it in to switch
    }
//todo do this txt thing


    public static void main(String[] args) throws IOException {

        Random rnd = new Random();
        int randomer = rnd.nextInt(100);
        Ozoba[] ozobas = new Ozoba[randomer];
        Scanner scan = new Scanner(System.in);
        String name = "";
        String phrase;
        String font = "<---------------------------------------------------->";





        for (int i = 0; i< randomer; i++){
            int rand = rnd.nextInt(500,2500);
            name = NameTabel(i);
            ozobas[i] = new Ozoba(rand,name , i, 0,0, 0);
        }

        for(int i = 0; i<ozobas.length; i++){

            for(int ii = 0; ii<ozobas.length-1; ii++){
                if(i == ii) {
                    ii++;
                }
                    if(!ozobas[ii].against.contains(ozobas[i].id)){
                        int id1 = ozobas[i].id;
                        int id2 = ozobas[ii].id;
                        Game(id1, id2, ozobas);
                    }
            }

        }


        System.out.println(font);
        System.out.print("> ");
        phrase = scan.next();
        System.out.println(font);

        switch (phrase){
            case "standard" ->{

                Arrays.stream(ozobas).forEach(e-> {
                    System.out.println("#" + ozobas[e.id].id + " | " + ozobas[e.id].name + " | " +
                            ozobas[e.id].points + " pkt | " + " Played: " + ozobas[e.id].playedGames + " | Wins: " + ozobas[e.id].wins +
                            " | " + ozobas[e.id].GamePoints );
                });
            }case "debug" -> {



                    Arrays.stream(ozobas).forEach(e-> {
                        System.out.println("#" + ozobas[e.id].id + " | " + ozobas[e.id].name + " | " +
                                ozobas[e.id].points + " pkt | " + " Played: " + ozobas[e.id].playedGames + " | " + ozobas[e.id].GamePoints +
                                " | Wins: " + ozobas[e.id].wins + " | W/D/L " + ozobas[e.id].table + " | " + ozobas[e.id].against);
                    });


            }case "soup"->{

                System.out.println("Zupa");

            }case "1"->{



            }case "2"->{



        }default -> {

            }

        }



    }





}
