package HelpMeAmStuck.Games;

import HelpMeAmStuck.Voids.Voids;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiniSweeperIGGuess {
    public static Tile[][] Board;
    public static boolean display_past_moves = false;

    public static void displayBoard() {
        if (!display_past_moves) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        System.out.println("   | 0.| 1.| 2.| 3.| 4.| 5.| 6.| 7.| 8.| 9.| ");
        for (int i = 0; i < Board.length; i++) {
            System.out.print(i + ". | ");
            for (int j = 0; j < Board[i].length; j++) {
                System.out.print(Board[i][j].getCurrentValue() + " | ");
            }
            System.out.println();
        }
    }

    public static void displayUnderCoverValue() {
        // Only for tests
        System.out.println("   | 0.| 1.| 2.| 3.| 4.| 5.| 6.| 7.| 8.| 9.| ");
        for (int i = 0; i < Board.length; i++) {
            System.out.print(i + ". | ");
            for (int j = 0; j < Board[i].length; j++) {
                System.out.print(Board[i][j].getUndercoverValue() + " | ");
            }
            System.out.println();
        }
    }

    public static void populateBoard() {
        int rows = 10;
        int columns = 10;
        Board = new Tile[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Board[i][j] = new Tile();
            }
        }
    }

    public static void generateBombs() {
        int bombsAmount = 10;
        for (int i = 0; i < bombsAmount; i++) {
            int expectedI = Voids.random.nextInt(10);
            int expectedJ = Voids.random.nextInt(10);
            while (true) {
                if (!Board[expectedI][expectedJ].hasMine()) {
                    Board[expectedI][expectedJ].setHasMine(true);
                    break;
                } else {
                    expectedI = Voids.random.nextInt(10);
                    expectedJ = Voids.random.nextInt(10);
                }
            }
        }
    }

    public static void showBombs() {
        // Only for tests
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Board[i][j].hasMine())
                    Board[i][j].setCurrentValue("X");
            }
        }
    }

    public static void settingUp() {
        int rows = 10;
        int columns = 10;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (Board[i][j].hasMine()) {
                    Board[i][j].setUndercoverValue("B");
                } else {
                    int minesAround = 0;
                    if (i + 1 < rows && j - 1 >= 0 && Board[i + 1][j - 1].hasMine())
                        minesAround++;
                    if (i + 1 < rows && Board[i + 1][j].hasMine())
                        minesAround++;
                    if (i + 1 < rows && j + 1 < columns && Board[i + 1][j + 1].hasMine())
                        minesAround++;
                    if (j - 1 >= 0 && Board[i][j - 1].hasMine())
                        minesAround++;
                    if (j + 1 < columns && Board[i][j + 1].hasMine())
                        minesAround++;
                    if (i - 1 >= 0 && j - 1 >= 0 && Board[i - 1][j - 1].hasMine())
                        minesAround++;
                    if (i - 1 >= 0 && Board[i - 1][j].hasMine())
                        minesAround++;
                    if (i - 1 >= 0 && j + 1 < columns && Board[i - 1][j + 1].hasMine())
                        minesAround++;

                    if (minesAround == 0) {
                        Board[i][j].setUndercoverValue(" ");
                    } else {
                        Board[i][j].setUndercoverValue(String.valueOf(minesAround));
                    }
                }
            }
        }
    }

    public static Map<String, String> inputs = new HashMap<>();

    static {
        // For Actual game
        inputs.put("f", "flag");
        inputs.put("u", "uncover");
        // Additions
        inputs.put("g", "get");
        inputs.put("h", "help");
    }

    public static List<String> possibleDividers = new ArrayList<>();

    static {
        possibleDividers.add("/");
        possibleDividers.add(",");
        possibleDividers.add(".");
        // Example 1/1 will be row 1 and column 1 same goes for 1,1 also 1.1 and 11 will be column 1 row 1 why? cuz last index is 9
    }

    public static void handlePlayerInput(String input) {
        if (input.startsWith("f")) {
            // Flag tile
            String position = input.substring(1).trim();
            int[] coordinates = parseCoordinates(position);
            if (coordinates != null) {
                int row = coordinates[0];
                int column = coordinates[1];
                flagTile(row, column);
            } else {
                System.out.println("Invalid position. Please enter valid coordinates.");
            }
        } else if (input.startsWith("u")) {
            // Uncover tile
            String position = input.substring(1).trim();
            int[] coordinates = parseCoordinates(position);
            if (coordinates != null) {
                int row = coordinates[0];
                int column = coordinates[1];
                uncoverTile(row, column);
            } else {
                System.out.println("Invalid position. Please enter valid coordinates.");
            }
        } else if (input.startsWith("g")) {
            // Get tile value
            String position = input.substring(1).trim();
            int[] coordinates = parseCoordinates(position);
            if (coordinates != null) {
                int row = coordinates[0];
                int column = coordinates[1];
                getTileValue(row, column);
            } else {
                System.out.println("Invalid position. Please enter valid coordinates.");
            }
        } else if (input.startsWith("h")) {
            // Display help
            displayHelp();
        } else {
            System.out.println("Invalid command. Please enter a valid command.");
        }
    }

    public static int[] parseCoordinates(String position) {
        for (String divider : possibleDividers) {
            if (position.contains(divider)) {
                String[] parts = position.split(divider);
                if (parts.length == 2) {
                    try {
                        int row = Integer.parseInt(parts[0]);
                        int column = Integer.parseInt(parts[1]);
                        if (isValidPosition(row, column)) {
                            return new int[]{row, column};
                        } else {
                            System.out.println("Invalid position. Please enter valid coordinates.");
                            return null;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid position. Please enter valid coordinates.");
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static boolean isValidPosition(int row, int column) {
        return row >= 0 && row < 10 && column >= 0 && column < 10;
    }

    public static void flagTile(int row, int column) {
        if (Board[row][column].getCurrentValue().equals("F")) {
            Board[row][column].setCurrentValue("-");
        } else {
            Board[row][column].setCurrentValue("F");
        }
        displayBoard();
    }

    public static void uncoverTile(int row, int column) {
        if (Board[row][column].getCurrentValue().equals("F")) {
            Board[row][column].setCurrentValue("-");
        } else if (Board[row][column].getUndercoverValue().equals("B")) {
            showBombs();
            System.out.println("You lost!");
        } else if (Board[row][column].getUndercoverValue().equals(" ")) {
            uncoverEmptyTiles(row, column);
        } else {
            Board[row][column].setCurrentValue(Board[row][column].getUndercoverValue());
        }
        displayBoard();
    }

    public static void uncoverEmptyTiles(int row, int column) {
        if (row < 0 || row >= 10 || column < 0 || column >= 10 || !Board[row][column].getCurrentValue().equals("-"))
            return;

        if (Board[row][column].getUndercoverValue().equals(" ")) {
            Board[row][column].setCurrentValue(" ");
            uncoverEmptyTiles(row - 1, column - 1);
            uncoverEmptyTiles(row - 1, column);
            uncoverEmptyTiles(row - 1, column + 1);
            uncoverEmptyTiles(row, column - 1);
            uncoverEmptyTiles(row, column + 1);
            uncoverEmptyTiles(row + 1, column - 1);
            uncoverEmptyTiles(row + 1, column);
            uncoverEmptyTiles(row + 1, column + 1);
        } else {
            Board[row][column].setCurrentValue(Board[row][column].getUndercoverValue());
        }
    }

    public static void getTileValue(int row, int column) {
        System.out.println("Tile value: " + Board[row][column].getUndercoverValue());
    }

    public static void displayHelp() {
        System.out.println("Commands:");
        System.out.println("- 'f row/column' - Flag a tile");
        System.out.println("- 'u row/column' - Uncover a tile");
        System.out.println("- 'g row/column' - Get the value of a tile");
        System.out.println("- 'h' - Display help");
    }

    public static void LunchGame() {
        populateBoard();
        generateBombs();
        settingUp();
        displayBoard();

        System.out.println("Welcome to Mini Sweeper!");

        while (true) {
            System.out.print("Enter a command (h for help): ");
            String input = Voids.sc.nextLine().toLowerCase();
            if (Voids.EndingProgram(input)) {
                System.out.println("Thank you for playing Mini Sweeper! Goodbye!");
                break;
            } else if (input.toLowerCase().equals("reset")) {
                LunchGame();
                break;
            }
            handlePlayerInput(input);
        }
    }
}

class Tile {
    private boolean hasMine;
    private String undercoverValue;
    private String currentValue;

    public Tile() {
        hasMine = false;
        undercoverValue = "-";
        currentValue = "-";
    }

    public boolean hasMine() {
        return hasMine;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public String getUndercoverValue() {
        return undercoverValue;
    }

    public void setUndercoverValue(String undercoverValue) {
        this.undercoverValue = undercoverValue;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }
}
