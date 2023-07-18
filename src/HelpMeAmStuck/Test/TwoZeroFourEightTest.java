package HelpMeAmStuck.Test;

import HelpMeAmStuck.Games.TwoZeroFourEight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoZeroFourEightTest {

    @Test
    public void runTest() {
        try {
            TwoZeroFourEight.resetBoard();
            int[][] previousBoard = TwoZeroFourEight.Board;

            String[] moves = {"right", "up", "left", "down"};
            for (String move : moves) {
                TwoZeroFourEight.MakeMove();
                if (boardDidNotChange(previousBoard)) {
                    Assertions.fail("Board did not change after move: " + move);
                }
                previousBoard = copyBoard(TwoZeroFourEight.Board);
            }

            System.out.println("Test was successful!");
        } catch (Exception e) {
            System.out.println("An error occurred during the test: " + e.getMessage());
        }
    }

    private boolean boardDidNotChange(int[][] previousBoard) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (TwoZeroFourEight.Board[i][j] != previousBoard[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] copy = new int[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, 4);
        }
        return copy;
    }
}
