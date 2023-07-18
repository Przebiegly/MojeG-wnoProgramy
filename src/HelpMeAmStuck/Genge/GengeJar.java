package HelpMeAmStuck.Genge;

import HelpMeAmStuck.Voids.Voids;

import java.util.*;

public class GengeJar {
    public static void Jars() {
        Table table = new Table();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Table:");
            table.displayTable();

            System.out.print("Enter input: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("end")) {
                break;
            } else if (input.startsWith("buy")) {
                String[] inputParts = input.split(" ");
                if (inputParts.length == 2) {
                    int jarId = Integer.parseInt(inputParts[1]);
                    Jar jar = table.getJarById(jarId);
                    if (jar != null) {
                        System.out.println("Cost of jar with ID " + jarId + ": " + jar.getCost());
                        table.removeJar(jarId);
                    } else {
                        System.out.println("Jar not found.");
                    }
                } else {
                    System.out.println("Invalid input. Usage: buy <jarId>");
                }
            } else if (input.equalsIgnoreCase("restock")) {
                table.restock();
                System.out.println("Table restocked.");
            } else if (input.equalsIgnoreCase("shuffle")) {
                table.shuffleTable();
                System.out.println("Table shuffled.");
            } else {
                System.out.println("Invalid input. Possible commands: buy <jarId>, restock, shuffle, end");
            }
        }

        System.out.println("Program ended.");
    }
}

class Table {
    private List<Jar> jars;

    public Table() {
        jars = new ArrayList<>();
        restock();
    }

    public void restock() {
        Random random = new Random();
        Flavour flavour = new Flavour();

        jars.clear();

        for (int i = 1; i <= 10; i++) {
            int value = random.nextInt(100) + 1;
            String flavourName = flavour.getFlavourName();
            int cost = flavour.getFlavourCost(value, flavourName);
            int ownerID = 0; // Shop owner ID

            Jar jar = new Jar(value, i, cost, flavourName, ownerID);
            jars.add(jar);
        }
    }

    public boolean isEmpty() {
        return jars.isEmpty();
    }

    public void displayTable() {
        for (Jar jar : jars) {
            System.out.println("ID: " + jar.getId() + ", Value: " + jar.getValue() + ", Cost: " + jar.getCost() +
                    ", Flavour: " + jar.getFlavour() + ", Owner ID: " + jar.getOwnerID());
        }
    }

    public Jar getJarById(int jarId) {
        for (Jar jar : jars) {
            if (jar.getId() == jarId) {
                return jar;
            }
        }
        return null;
    }

    public void removeJar(int jarId) {
        Iterator<Jar> iterator = jars.iterator();
        while (iterator.hasNext()) {
            Jar jar = iterator.next();
            if (jar.getId() == jarId) {
                iterator.remove();
                break;
            }
        }
    }

    public void shuffleTable() {
        Collections.shuffle(jars);
    }
}

class Jar {
    private int value;
    private int id;
    private int cost;
    private String flavour;
    private int ownerID;

    public Jar(int value, int id, int cost, String flavour, int ownerID) {
        this.value = value;
        this.id = id;
        this.cost = cost;
        this.flavour = flavour;
        this.ownerID = ownerID;
    }

    public String getFlavour() {
        return flavour;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public int getCost() {
        return cost;
    }

    public int getOwnerID() {
        return ownerID;
    }
}

class Flavour {
    private String[] flavourNames = {"Orange", "Banana", "Strawberry", "Pineapple", "Apple", "Butter", "Peanuts"};
    private Map<String, Integer> flavourCosts;

    public Flavour() {
        flavourCosts = new HashMap<>();
        flavourCosts.put("Orange", 10);
        flavourCosts.put("Banana", 15);
        flavourCosts.put("Strawberry", 12);
        flavourCosts.put("Pineapple", 20);
        flavourCosts.put("Apple", 8);
        flavourCosts.put("Butter", 5);
        flavourCosts.put("Peanuts", 7);
    }

    public String getFlavourName() {
        int index = Voids.random.nextInt(flavourNames.length);
        return flavourNames[index];
    }

    public int getFlavourCost(int value, String name) {
        int cost = flavourCosts.getOrDefault(name, 0);
        return (value * cost)/100;
    }
}


