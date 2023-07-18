package HelpMeAmStuck.GameRelatedButNotGames;

import java.io.*;
import java.util.*;

public class TFTChampChances {
    private static final String DATA_FILE_PATH = "C:\\Users\\pauli\\IdeaProjects\\HelpMeAmStuckWithDamnCode\\src\\HelpMeAmStuck\\GameRelatedButNotGames\\TFTChampionsFile.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void Champs() {
        EmblemManager emblemManager = new EmblemManager();
        ChampionManager championManager = new ChampionManager(emblemManager);

        // Load data from file
        loadDataFromFile(championManager, emblemManager);

        // User interaction
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter an option:");
            System.out.println("1. Create Champion");
            System.out.println("2. Delete Champion");
            System.out.println("3. Delete Emblem");
            System.out.println("4. Print Champions with Emblems");
            System.out.println("5. Calculate Champion Chances");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    createChampion(scanner, championManager, emblemManager);
                    break;
                case 2:
                    deleteChampion(scanner, championManager, emblemManager);
                    break;
                case 3:
                    deleteEmblem(scanner, emblemManager);
                    break;
                case 4:
                    championManager.printChampionsWithEmblems();
                    break;
                case 5:
                    calculateChampChances(scanner, championManager);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    saveDataToFile(championManager, emblemManager);
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void loadDataFromFile(ChampionManager championManager, EmblemManager emblemManager) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(CSV_SEPARATOR);
                if (tokens.length > 1) {
                    String name = tokens[0];
                    int level = Integer.parseInt(tokens[1]);

                    List<Emblem> emblems = new ArrayList<>();
                    for (int i = 2; i < tokens.length; i++) {
                        emblems.add(emblemManager.getOrCreateEmblem(tokens[i]));
                    }

                    championManager.createChampion(name, level, emblems);
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while loading data from file: " + e.getMessage());
        }
    }

    private static void saveDataToFile(ChampionManager championManager, EmblemManager emblemManager) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_PATH))) {
            for (Champion champion : championManager.getAllChampions()) {
                StringBuilder lineBuilder = new StringBuilder();
                lineBuilder.append(champion.getName()).append(CSV_SEPARATOR);
                lineBuilder.append(champion.getLevel());

                for (Emblem emblem : champion.getChampionEmblems()) {
                    lineBuilder.append(CSV_SEPARATOR).append(emblem.getEmblemName());
                }

                writer.write(lineBuilder.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while saving data to file: " + e.getMessage());
        }
    }

    private static void createChampion(Scanner scanner, ChampionManager championManager, EmblemManager emblemManager) {
        System.out.println("Enter the champion name:");
        String name = scanner.nextLine();

        System.out.println("Enter the champion level (1-5):");
        int level = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Emblem> emblems = new ArrayList<>();
        while (true) {
            System.out.println("Enter an emblem name (or type 'done' to finish):");
            String emblemName = scanner.nextLine();
            if (emblemName.equalsIgnoreCase("done")) {
                break;
            }

            Emblem emblem = emblemManager.getOrCreateEmblem(emblemName);
            emblems.add(emblem);
        }

        championManager.createChampion(name, level, emblems);
        System.out.println("Champion created successfully.");
    }

    private static void deleteChampion(Scanner scanner, ChampionManager championManager, EmblemManager emblemManager) {
        System.out.println("Enter the name of the champion to delete:");
        String name = scanner.nextLine();

        if (championManager.deleteChampion(name)) {
            System.out.println("Champion deleted successfully.");
        } else {
            System.out.println("Champion not found.");
        }
    }

    private static void deleteEmblem(Scanner scanner, EmblemManager emblemManager) {
        System.out.println("Enter the name of the emblem to delete:");
        String name = scanner.nextLine();

        if (emblemManager.deleteEmblem(name)) {
            System.out.println("Emblem deleted successfully.");
        } else {
            System.out.println("Emblem not found.");
        }
    }

    private static void calculateChampChances(Scanner scanner, ChampionManager championManager) {
        System.out.println("Enter the player level (1-9):");
        int playerLevel = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Champion Chances at Player Level " + playerLevel + ":");
        for (Champion champion : championManager.getAllChampions()) {
            double chance = calculateChance(playerLevel, champion.getLevel());
            System.out.println(champion.getName() + ": " + chance + "%");
        }
    }

    private static double calculateChance(int playerLevel, int championLevel) {
        if (playerLevel < championLevel) {
            return 0.0;
        } else if (playerLevel == championLevel) {
            return 100.0;
        } else {
            int levelDiff = playerLevel - championLevel;
            int maxLevelDiff = 9 - championLevel;
            double chancePerLevel = 100.0 / (maxLevelDiff + 1);
            return (1 - levelDiff * chancePerLevel) * 100;
        }
    }
}

// Rest of the classes remain the same


class Champion {
    private String name;
    private int level;
    private List<Emblem> championEmblems;

    public Champion(String name, int level, List<Emblem> championEmblems) {
        this.name = name;
        this.level = level;
        this.championEmblems = championEmblems;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public List<Emblem> getChampionEmblems() {
        return championEmblems;
    }

    public void addEmblem(Emblem emblem) {
        championEmblems.add(emblem);
    }

    public void removeEmblem(Emblem emblem) {
        championEmblems.remove(emblem);
    }
}

class Emblem {
    private String emblemName;

    public Emblem(String emblemName) {
        this.emblemName = emblemName;
    }

    public String getEmblemName() {
        return emblemName;
    }
}

class EmblemManager {
    private Map<String, Emblem> emblems;

    public EmblemManager() {
        this.emblems = new HashMap<>();
    }

    public Emblem getOrCreateEmblem(String emblemName) {
        Emblem emblem = emblems.get(emblemName);
        if (emblem == null) {
            emblem = new Emblem(emblemName);
            emblems.put(emblemName, emblem);
        }
        return emblem;
    }

    public boolean deleteEmblem(String emblemName) {
        Emblem emblem = emblems.remove(emblemName);
        return emblem != null;
    }
}

class ChampionManager {
    private Map<String, Champion> champions;
    private EmblemManager emblemManager;

    public ChampionManager(EmblemManager emblemManager) {
        this.champions = new HashMap<>();
        this.emblemManager = emblemManager;
    }

    public void createChampion(String name, int level, List<Emblem> emblems) {
        Champion champion = new Champion(name, level, emblems);
        champions.put(name, champion);

        for (Emblem emblem : emblems) {
            emblemManager.getOrCreateEmblem(emblem.getEmblemName());
        }
    }

    public boolean deleteChampion(String name) {
        Champion champion = champions.remove(name);
        return champion != null;
    }

    public Collection<Champion> getAllChampions() {
        return champions.values();
    }

    public Champion getChampion(String name) {
        return champions.get(name);
    }

    public void printChampionsWithEmblems() {
        for (Champion champion : champions.values()) {
            System.out.println("Champion: " + champion.getName());
            System.out.println("Emblems:");
            for (Emblem emblem : champion.getChampionEmblems()) {
                System.out.println("- " + emblem.getEmblemName());
            }
            System.out.println();
        }
    }
}
