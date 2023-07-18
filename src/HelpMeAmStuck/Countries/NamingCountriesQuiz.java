package HelpMeAmStuck.Countries;

import HelpMeAmStuck.Voids.Voids;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class NamingCountriesQuiz {
    private static final int GAME_DURATION_MINUTES = 10;
    private static Timer timer;
    private static boolean timeIsUp = false;
    private static int MaximumPoints;
    private static int CurrentPoints;
    private static List<String> Answers;
    private static Set<String> previousGuesses;
    private static List<String> missingAnswers;
    private static int gamesPlayed;
    private static Set<String> correctGuesses;

    public static void Game() {
        System.out.println("Welcome to the Blind Country Naming Game!");
        System.out.println("You have " + GAME_DURATION_MINUTES + " minute to name as many countries as you can.");

        initializeGame();
        startTimer();
        playGame();
        stopTimer();
        showMissingGuesses();
        writeStatisticsToFile();
    }

    private static void initializeGame() {
        MaximumPoints = CountriesList.countries.size();
        CurrentPoints = 0;
        Answers = new ArrayList<>();
        previousGuesses = new HashSet<>();
        missingAnswers = new ArrayList<>();
        gamesPlayed = 0;
        correctGuesses = new HashSet<>();
    }

    private static void playGame() {
        String input;
        System.out.println("Enter a country name (or 'end' to finish the game): ");

        while (!timeIsUp) {
            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();

            if (Voids.EndingProgram(input)) {
                System.out.println("Game ended by user.");
                break;
            }

            if (previousGuesses.contains(input)) {
                System.out.println("You have already guessed that country.");
                continue;
            }

            previousGuesses.add(input);

            if (isAnswerCorrect(input)) {
                System.out.println("Correct guess!");
                CurrentPoints++;
                Answers.add(input);
                correctGuesses.add(input);
            } else {
                System.out.println("Incorrect guess!");
                if (!missingAnswers.contains(input)) {
                    missingAnswers.add(input);
                }
            }
        }
        gamesPlayed++;
    }

    private static boolean isAnswerCorrect(String input) {
        String lowerCaseInput = input.toLowerCase();
        for (String country : CountriesList.countries) {
            if (country.toLowerCase().equals(lowerCaseInput) && !Answers.contains(input)) {
                return true;
            }
        }
        return false;
    }

    private static void startTimer() {
        timer = new Timer();
        int totalGameDuration = GAME_DURATION_MINUTES;
        int emergencyExitDelay = 2;

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!timeIsUp) {
                    timeIsUp = true;
                    System.out.println("Game duration exceeded. Initiating emergency exit...");
                    stopTimer();
                    System.exit(0);
                } else {
                    System.out.println("Emergency exit triggered. Game ended.");
                    stopTimer();
                    System.exit(0);
                }
            }
        }, totalGameDuration * 60 * 1000, emergencyExitDelay * 60 * 1000);
    }

    private static void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    private static void showMissingGuesses() {
        System.out.println("Missing guesses:");
        for (String country : CountriesList.countries) {
            if (!correctGuesses.contains(country)) {
                System.out.println(country);
            }
        }
        double percentage = MaximumPoints/CurrentPoints;
        System.out.println(CurrentPoints+"/"+MaximumPoints+" pts");
        System.out.println("Accuracy: "+percentage+"%");
    }

    private static void writeStatisticsToFile() {
        String filePath = "C:\\Users\\pauli\\IdeaProjects\\HelpMeAmStuckWithDamnCode\\src\\HelpMeAmStuck\\Countries\\statistics.txt";

        int totalGamesPlayed = Math.max(gamesPlayed, 1);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Country: Correct/Out of\n");
            for (String country : CountriesList.countries) {
                int correctGuessesCount = getCorrectGuessCount(country);
                writer.write(country + ": " + correctGuessesCount + "/" + totalGamesPlayed + "\n");
            }
        } catch (IOException e) {
            System.out.println("Failed to write statistics to file: " + e.getMessage());
        }
    }

    private static int getCorrectGuessCount(String country) {
        int count = 0;
        for (String answer : Answers) {
            if (answer.equalsIgnoreCase(country)) {
                count++;
            }
        }
        return count;
    }
}

