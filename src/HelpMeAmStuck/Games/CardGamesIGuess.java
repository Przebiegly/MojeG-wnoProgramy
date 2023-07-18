package HelpMeAmStuck.Games;

import HelpMeAmStuck.Voids.Voids;

import java.util.ArrayList;
import java.util.List;

public class CardGamesIGuess {

    public static void SelectingGameMode() {
        String input;
        while (true) {
            System.out.println("Select Game Mode");
            Voids.DisplayDevider2();
            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if (Voids.EndingProgram(input)) {
                System.out.println("Closing! ");
                break;
            } else {
                GameModesSwitch(input);
            }
        }
    }

    private static void GameModesSwitch(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "demo":
                Games.demoGame();
                break;
            default:
                System.out.println("Error! Game Mode '" + input + "' Does not Exist!");
                break;
        }
    }
}

class Games {

    public static void demoGame() {
        System.out.println("Selected: Demo Game");

        // Create a player with a full deck
        Player player = new Player(1, false);
        Deck deck = new Deck("standard");
        player.setDeck(deck);
        System.out.println("Player's Deck:");
        player.displayDeck();

        // Test methods with administrator access
        player.administratorAccess();
    }
}

class Deck {
    private List<Cards> cards;

    public Deck(String deckType) {
        cards = new ArrayList<>();
        switch (deckType.toLowerCase()) {
            case "standard":
                // Standard deck with 52 cards
                for (Symbol symbol : Symbol.values()) {
                    for (int numericalValue = 2; numericalValue <= 10; numericalValue++) {
                        cards.add(new Cards(numericalValue, Color.RED, symbol));
                        cards.add(new Cards(numericalValue, Color.BLACK, symbol));
                    }
                }
                // Add face cards and jokers
                for (Symbol symbol : Symbol.values()) {
                    cards.add(new Cards(11, Color.RED, symbol)); // Joker (red without symbol)
                    cards.add(new Cards(11, Color.BLACK, symbol)); // Joker (black without symbol)
                    for (int i = 0; i < 4; i++) {
                        cards.add(new Cards(10, Color.RED, symbol)); // Jack
                        cards.add(new Cards(10, Color.RED, symbol)); // Queen
                        cards.add(new Cards(10, Color.RED, symbol)); // King
                        cards.add(new Cards(10, Color.RED, symbol)); // Ace
                    }
                }
                break;
            case "standard+":
                // Standard deck with 53 cards (additional joker)
                for (Symbol symbol : Symbol.values()) {
                    for (int numericalValue = 2; numericalValue <= 10; numericalValue++) {
                        cards.add(new Cards(numericalValue, Color.RED, symbol));
                        cards.add(new Cards(numericalValue, Color.BLACK, symbol));
                    }
                }
                // Add face cards and jokers
                for (Symbol symbol : Symbol.values()) {
                    cards.add(new Cards(11, Color.RED, symbol)); // Joker (red without symbol)
                    cards.add(new Cards(11, Color.BLACK, symbol)); // Joker (black without symbol)
                    cards.add(new Cards(11, Color.BLUE, symbol)); // Additional Joker (blue without symbol)
                    for (int i = 0; i < 4; i++) {
                        cards.add(new Cards(10, Color.RED, symbol)); // Jack
                        cards.add(new Cards(10, Color.RED, symbol)); // Queen
                        cards.add(new Cards(10, Color.RED, symbol)); // King
                        cards.add(new Cards(10, Color.RED, symbol)); // Ace
                    }
                }
                break;
            case "poker":
                // Poker style deck with cards from 9 to Ace
                for (Symbol symbol : Symbol.values()) {
                    for (int numericalValue = 9; numericalValue <= 10; numericalValue++) {
                        cards.add(new Cards(numericalValue, Color.RED, symbol));
                        cards.add(new Cards(numericalValue, Color.BLACK, symbol));
                    }
                    for (int numericalValue = 11; numericalValue <= 14; numericalValue++) {
                        cards.add(new Cards(numericalValue, Color.RED, symbol));
                        cards.add(new Cards(numericalValue, Color.BLACK, symbol));
                    }
                }
                break;
            default:
                System.out.println("Invalid deck type!");
                break;
        }
    }

    // Add deck-related logic here

    public List<Cards> getCards() {
        return cards;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }
}


class Cards {
    private int numericalValue;
    private Color color;
    private Symbol symbol;

    public Cards(int numericalValue, Color color, Symbol symbol) {
        this.numericalValue = numericalValue;
        this.color = color;
        this.symbol = symbol;
    }

    public String getSymbolAsString() {
        switch (symbol) {
            case CLUBS:
                return "\u2663"; // Club symbol ♣
            case DIAMONDS:
                return "\u2666"; // Diamond symbol ♦
            case HEARTS:
                return "\u2665"; // Heart symbol ♥
            case SPADES:
                return "\u2660"; // Spade symbol ♠
            default:
                return "?";
        }
    }

    // Getter and setter methods
    public int getNumericalValue() {
        return numericalValue;
    }

    public void setNumericalValue(int numericalValue) {
        this.numericalValue = numericalValue;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}

class Player {
    private int points;
    private int id;
    private List<Cards> currentCards;
    private boolean isAI;
    private Deck deck;

    public Player(int id, boolean isAI) {
        this.id = id;
        this.isAI = isAI;
        currentCards = new ArrayList<>();
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
        this.currentCards = new ArrayList<>(deck.getCards());
    }

    public void displayDeck() {
        System.out.print("Deck: [");
        for (int i = 0; i < currentCards.size(); i++) {
            Cards card = currentCards.get(i);
            System.out.print(card.getNumericalValue() + card.getSymbolAsString() + (i != currentCards.size() - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public void administratorAccess() {
        System.out.println("Administrator Access:");
        System.out.println("Points: " + points);
        System.out.println("ID: " + id);
        System.out.println("Is AI: " + isAI);
        System.out.println("Deck: [");
        for (int i = 0; i < currentCards.size(); i++) {
            Cards card = currentCards.get(i);
            System.out.print("Numerical Value: " + card.getNumericalValue());
            System.out.print(", Color: " + card.getColor());
            System.out.println(", Symbol: " + card.getSymbolAsString());
        }
        System.out.println("]");
    }
}

enum Color {
    RED,
    BLACK;
    public static Color BLUE;
}

enum Symbol {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}


