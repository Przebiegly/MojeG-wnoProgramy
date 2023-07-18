package HelpMeAmStuck.Games;

import HelpMeAmStuck.Voids.Voids;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoZeroFourEight {
    public static int[][] Board = new int[4][4];
    private static String input;

    private static void GamePrep() {
        resetBoard();
        GenerateNewNumber();
    }

    public static void Game() {
        GamePrep();
        while (true) {
            Voids.DisplayDevider2();
            ShowBoard();
            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if (Voids.EndingProgram(input)) {
                getScore();
                break;
            } else if (input.equals("reset")) {
                Game();
                break;
            } else {
                MakeMove();
            }
            GenerateNewNumber();
        }
    }

    public static void MakeMove() {
        input = input.toLowerCase();
        if (input.startsWith("u"))
            input = "UP";
        else if (input.startsWith("d"))
            input = "DOWN";
        else if (input.startsWith("l"))
            input = "LEFT";
        else if (input.startsWith("r"))
            input = "RIGHT";

        switch (input) {
            case "UP":
                for (int j = 0; j < 4; j++) {
                    for (int i = 1; i < 4; i++) {
                        if (Board[i][j] != 0) {
                            int k = i;
                            while (k > 0 && Board[k - 1][j] == 0) {
                                Board[k - 1][j] = Board[k][j];
                                Board[k][j] = 0;
                                k--;
                            }
                            if (k > 0 && Board[k - 1][j] == Board[k][j]) {
                                Board[k - 1][j] *= 2;
                                Board[k][j] = 0;
                            }
                        }
                    }
                }
                break;
            case "DOWN":
                for (int j = 0; j < 4; j++) {
                    for (int i = 2; i >= 0; i--) {
                        if (Board[i][j] != 0) {
                            int k = i;
                            while (k < 3 && Board[k + 1][j] == 0) {
                                Board[k + 1][j] = Board[k][j];
                                Board[k][j] = 0;
                                k++;
                            }
                            if (k < 3 && Board[k + 1][j] == Board[k][j]) {
                                Board[k + 1][j] *= 2;
                                Board[k][j] = 0;
                            }
                        }
                    }
                }
                break;
            case "LEFT":
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j < 4; j++) {
                        if (Board[i][j] != 0) {
                            int k = j;
                            while (k > 0 && Board[i][k - 1] == 0) {
                                Board[i][k - 1] = Board[i][k];
                                Board[i][k] = 0;
                                k--;
                            }
                            if (k > 0 && Board[i][k - 1] == Board[i][k]) {
                                Board[i][k - 1] *= 2;
                                Board[i][k] = 0;
                            }
                        }
                    }
                }
                break;
            case "RIGHT":
                for (int i = 0; i < 4; i++) {
                    for (int j = 2; j >= 0; j--) {
                        if (Board[i][j] != 0) {
                            int k = j;
                            while (k < 3 && Board[i][k + 1] == 0) {
                                Board[i][k + 1] = Board[i][k];
                                Board[i][k] = 0;
                                k++;
                            }
                            if (k < 3 && Board[i][k + 1] == Board[i][k]) {
                                Board[i][k + 1] *= 2;
                                Board[i][k] = 0;
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Incorrect action: " + input);
        }
    }

    public static void GenerateNewNumber() {
        int newNum = getNewNum();
        List<String> freeSlots = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Board[i][j] == 0)
                    freeSlots.add(i + "/" + j);
            }
        }
        String position = freeSlots.get(Voids.random.nextInt(0, freeSlots.size()));
        String[] posTab = position.split("/");
        int posX = Integer.parseInt(posTab[0]);
        int posY = Integer.parseInt(posTab[1]);

        Board[posX][posY] = newNum;
    }

    public static void resetBoard() {
        for (int i = 0; i < 4; i++) {
            Arrays.fill(Board[i], 0);
        }
    }

    public static int getNewNum() {
        int temp = Voids.random.nextInt(11);
        int temp2 = (temp == 10) ? 4 : 2;
        return temp2;
    }

    public static void getScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Board[i][j] > score) {
                    score = Board[i][j];
                }
            }
        }
        System.out.println("Highest Score: " + score);
    }

    public static void ShowBoard() {
        for (int i = 0; i < 4; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(Board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static void returnExplanation() {
        System.out.println("Action commands: \nup(u) down(d) left(l) right(r) end\n\nGoal is 2048 and more");
    }
}
