package HelpMeAmStuck.Othere;

import java.util.List;

public class LettersAndCharacters {
    private static String[] Letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private static String[] SymbolsForMath = {"!", "#", "$", "%", "&", "*", "+", "-", "/", ":", ";", "<", ">", "?", "^"};
    private static String[] commonSymbols = {" ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "@", "[", "\\", "]", "^", "_", "`", "{", "|", "}", "~"};


    public static List<String> LetterList = List.of(Letters);
    public static List<String> SymbolsForMathList = List.of(SymbolsForMath);
    public static List<String> ComonSymbolsList = List.of(commonSymbols);

}
