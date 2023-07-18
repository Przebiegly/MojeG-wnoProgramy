package HelpMeAmStuck.Games;

public class RubiksCube {
    public static int[][][] cube = {
            {   // Center Wall
                    {1, 1, 1},
                    {1, 1, 1},
                    {1, 1, 1}
            },
            {   // Top Wall
                    {2, 2, 2},
                    {2, 2, 2},
                    {2, 2, 2}
            },
            {   // Down Wall
                    {3, 3, 3},
                    {3, 3, 3},
                    {3, 3, 3}
            },
            {   // Right Wall
                    {4, 4, 4},
                    {4, 4, 4},
                    {4, 4, 4}
            },
            {   // Left Wall
                    {5, 5, 5},
                    {5, 5, 5},
                    {5, 5, 5}
            },
            {   // Back Wall
                    {6, 6, 6},
                    {6, 6, 6},
                    {6, 6, 6}
            }
    };

    public static int CENTER_WALL_NUM = 1;
    public static int TOP_WALL_NUM = 2;
    public static int DOWN_WALL_NUM = 3;
    public static int RIGHT_WALL_NUM = 4;
    public static int LEFT_WALL_NUM = 5;
    public static int BACK_WALL_NUM = 6;

    public static void game() {
        showCube();
    }

    private static void showCube() {
        // Display Center Wall
        System.out.println("/ Center /");
        displayFace(cube[0]);

        // Display Top Wall
        System.out.println("/ Top /");
        displayFace(cube[1]);

        // Display Down Wall
        System.out.println("/ Down /");
        displayFace(cube[2]);

        // Display Right Wall
        System.out.println("/ Right /");
        displayFace(cube[3]);

        // Display Left Wall
        System.out.println("/ Left /");
        displayFace(cube[4]);

        // Display Back Wall
        System.out.println("/ Back /");
        displayFace(cube[5]);
    }

    private static void displayFace(int[][] face) {
        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face[i].length; j++) {
                System.out.print(face[i][j] + " ");
            }
            System.out.println();
        }
    }

}
