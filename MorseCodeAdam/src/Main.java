import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final ArrayList<Character> validMorseCodeChars = new ArrayList<>(List.of('.', '-', ' ', '/'));
    private static final Map<String, String> alphabet = new HashMap<>() {{
        put("a", ".-");
        put("b", "-...");
        put("c", "-.-.");
        put("d", "-..");
        put("e", ".");
        put("f", "..-.");
        put("g", "--.");
        put("h", "....");
        put("i", "..");
        put("j", ".---");
        put("k", "-.-");
        put("l", ".-..");
        put("m", "--");
        put("n", "-.");
        put("o", "---");
        put("p", ".--.");
        put("q", "--.-");
        put("r", ".-.");
        put("s", "...");
        put("t", "-");
        put("u", "..-");
        put("v", "...-");
        put("w", ".--");
        put("x", "-..-");
        put("y", "-.--");
        put("z", "--..");
        put("0", "-----");
        put("1", ".----");
        put("2", "..---");
        put("3", "...--");
        put("4", "....-");
        put("5", ".....");
        put("6", "-....");
        put("7", "--...");
        put("8", "---..");
        put("9", "----.");
        put(".", ".-.-.-");
        put(",", "--..--");
        put("?", "..--..");
        put("'", ".----.");
        put("!", "-.-.--");
        put("/", "-..-.");
        put("(", "-.--.");
        put(")", "-.--.-");
        put("&", ".-...");
        put(":", "---...");
        put(";", "-.-.-.");
        put("=", "-...-");
        put("+", ".-.-.");
        put("-", "-....-");
        put("_", "..--.-");
        put("\"", ".-..-.");
        put("$", "...-..-");
        put("@", ".--.-.");
        put("¿", "..-.-");
        put("¡", "--...-");
        put(" ", "/");
    }};
    private static final Map<String, String> morseAlphabet = new HashMap<>();
    static {
        for (Map.Entry<String, String> entry : alphabet.entrySet()) {
            morseAlphabet.put(entry.getValue(), entry.getKey());
        }
    }

    public static String charToMorse(char c) {
        String s = alphabet.get(Character.toString(c).toLowerCase());
        if (s == null) return "N";
        return s;
    }

    public static String morseToChar(String morse) {
        String s = morseAlphabet.get(morse);
        if (s == null) return "N";
        return s;
    }

    private static boolean validMorseCode(String code) {
        ArrayList<Character> chars = new ArrayList<>();

        if (code.trim().isEmpty()) return false;

        for (char c : code.toCharArray()) { chars.add(c); }
        for (int i = 0; i < code.length(); i++) {
            if (!validMorseCodeChars.contains(chars.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static String TranslateToMorse(String text) {
        StringBuilder sb = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i ++) {
            sb.append(charToMorse(chars[i]));
            if (i != chars.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    private static String TranslateToText(String morseCode) {
        if (!validMorseCode(morseCode)) {
            System.out.println("Invalid Morse Code");
            return null;
        }

        StringBuilder sb = new StringBuilder();
        String[] chars = morseCode.split(" ");
        for (String aChar : chars) sb.append(morseToChar(aChar));
        return sb.toString();
    }

    private static void saveToFile(String path, String text) {
        BufferedWriter bf;
        try {
            bf = new BufferedWriter(new FileWriter(path));
            bf.append(text);
            bf.close();
        } catch (IOException e) {
            System.out.printf("Can't Open File [%s]", path);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Mode mode = Mode.TEXT;
        boolean toFile = false;
        boolean running = true;
        String prefix = "/";

        while (running) {
            System.out.printf("%s> ", mode.toString().toCharArray()[0]);
            String input = scan.nextLine();

            if (input.startsWith(prefix)) {
                String command = input.substring(prefix.length());
                switch (command) {
                    case "exit" -> running = false;
                    case "morse" -> mode = Mode.MORSECODE;
                    case "text" -> mode = Mode.TEXT;
                    case "file" -> toFile = !toFile;
                    case "mode" -> {
                        if (mode == Mode.MORSECODE) mode = Mode.TEXT;
                        else mode = Mode.MORSECODE;
                    }
                    case "info" -> System.out.printf("""
                                Translating To: %s
                                Save To File  : %b
                                """, mode, toFile);
                    default -> System.out.printf("""
                                %1$sexit  - Exits The Program
                                %1$smorse - Changes The Mode To Translate To Morse Code
                                %1$stext  - Changes The Mode To Translate to Text
                                %1$sfile  - Switch Between Saving To File And Displaying in Console
                                %1$smode  - Switch Between Morse And Text Modes
                                %1$sinfo  - Some Basic Information
                                %1$shelp  - Displays This Message
                                """, prefix);
                }
                continue;
            }

            if (mode == Mode.MORSECODE) input = TranslateToMorse(input);
            else input = TranslateToText(input);

            if (input == null) continue;

            if (toFile) {
                System.out.println("Saving To File..");
                saveToFile("/disc1/programming/Java/MorseCode/src/test.txt", input);
            } else {
                System.out.printf("%s\n", input);
            }


        }

    }
}