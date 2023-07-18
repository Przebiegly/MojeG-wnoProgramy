package HelpMeAmStuck.EncryptionAndDecryption;

import HelpMeAmStuck.Voids.Voids;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeAttempt1 {
    private static final Map<Character, String> charToMorse = new HashMap<>();
    private static final Map<String, Character> morseToChar = new HashMap<>();

    static {
        charToMorse.put('A', ".-");
        charToMorse.put('B', "-...");
        charToMorse.put('C', "-.-.");
        charToMorse.put('D', "-..");
        charToMorse.put('E', ".");
        charToMorse.put('F', "..-.");
        charToMorse.put('G', "--.");
        charToMorse.put('H', "....");
        charToMorse.put('I', "..");
        charToMorse.put('J', ".---");
        charToMorse.put('K', "-.-");
        charToMorse.put('L', ".-..");
        charToMorse.put('M', "--");
        charToMorse.put('N', "-.");
        charToMorse.put('O', "---");
        charToMorse.put('P', ".--.");
        charToMorse.put('Q', "--.-");
        charToMorse.put('R', ".-.");
        charToMorse.put('S', "...");
        charToMorse.put('T', "-");
        charToMorse.put('U', "..-");
        charToMorse.put('V', "...-");
        charToMorse.put('W', ".--");
        charToMorse.put('X', "-..-");
        charToMorse.put('Y', "-.--");
        charToMorse.put('Z', "--..");
        charToMorse.put('0', "-----");
        charToMorse.put('1', ".----");
        charToMorse.put('2', "..---");
        charToMorse.put('3', "...--");
        charToMorse.put('4', "....-");
        charToMorse.put('5', ".....");
        charToMorse.put('6', "-....");
        charToMorse.put('7', "--...");
        charToMorse.put('8', "---..");
        charToMorse.put('9', "----.");
        charToMorse.put('.', ".-.-.-");
        charToMorse.put(',', "--..--");
        charToMorse.put('?', "..--..");
        charToMorse.put('!', "-.-.--");

        for (Map.Entry<Character, String> entry : charToMorse.entrySet()) {
            morseToChar.put(entry.getValue(), entry.getKey());
        }
    }

    public static void Code() {
        String input;
        while(true){
            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if(Voids.EndingProgram(input)) break;
            else{
                String Temp1 = input; //"Adam";
                String Temp2 = "";
                for (int i = 0; i < Temp1.length(); i++)
                    Temp2 += charToMorse.get(Character.toUpperCase(Temp1.charAt(i)))+" ";


                if(Temp2.isEmpty())
                    Temp2 = "Non!";
                System.out.println("The Morse code for '" + Temp1 + "' is: " + Temp2);

                String Temp3 = input;  //".- -.. .- --";
                String Temp4 = "";


                StringBuilder morseBuilder = new StringBuilder();
                StringBuilder textBuilder = new StringBuilder();

                for (int i = 0; i < Temp3.length(); i++) {
                    char c = Temp3.charAt(i);

                    if (c == '.' || c == '-') {
                        morseBuilder.append(c);
                    } else if (c == ' ') {
                        // Space indicates the end of a Morse code sequence
                        String morseCode = morseBuilder.toString();
                        char translatedChar = morseToChar.getOrDefault(morseCode, '?');
                        textBuilder.append(translatedChar);
                        morseBuilder.setLength(0); // Reset the morseBuilder
                    }
                }


                if (morseBuilder.length() > 0) {
                    String morseCode = morseBuilder.toString();
                    char translatedChar = morseToChar.getOrDefault(morseCode, '?');
                    textBuilder.append(translatedChar);
                }

                Temp4 = textBuilder.toString();
                if(Temp4.isEmpty())
                    Temp4 = "Non!";

                System.out.println("The translated text for Morse code '" + Temp3 + "' is: " + Temp4);
            }
        }


    }


}
