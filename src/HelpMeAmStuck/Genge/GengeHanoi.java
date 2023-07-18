package HelpMeAmStuck.Genge;

public class GengeHanoi {
    public static void Tower() {
        int numDiscs = 3;
        char source = 'A';
        char auxiliary = 'B';
        char destination = 'C';

        solveHanoiTower(numDiscs, source, auxiliary, destination);
    }

    public static void solveHanoiTower(int numDiscs, char source, char auxiliary, char destination) {
        if (numDiscs == 1) {
            System.out.println("Move disc 1 from " + source + " to " + destination);
        } else {
            solveHanoiTower(numDiscs - 1, source, destination, auxiliary);
            System.out.println("Move disc " + numDiscs + " from " + source + " to " + destination);
            solveHanoiTower(numDiscs - 1, auxiliary, source, destination);
        }
    }
}
