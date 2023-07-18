package HelpMeAmStuck.EncryptionAndDecryption;

import HelpMeAmStuck.Voids.Voids;

import java.util.Random;
import java.util.Scanner;

public class HowToDoThisWhenYou {
    public static String key;

    public static void AreDumb() {
        GenerateKey getKey = new GenerateKey();
        Thread getKeys = new Thread(getKey);
        getKeys.start();

        while (true) {
            Voids.DisplayDevider3();
            Voids.DisplayInputArrow();
            Scanner sc = Voids.sc;
            String input = sc.nextLine();
            if (Voids.EndingProgram(input)) {
                break;
            } else
                DecryptEncryptSwitch(input);
        }
    }

    public static void DecryptEncryptSwitch(String input) {
        input = input.toUpperCase();
        if (input.startsWith("ENC"))
            input = "ENCRYPT";
        else if (input.startsWith("DEC")) {
            input = "DECRYPT";
        }
        switch (input) {
            case "ENCRYPT" -> Encryption();
            case "DECRYPT" -> Decryption();
            default -> System.out.println("Nice try! Nothing found for: " + input);
        }
    }

    private static void Encryption() {
        Scanner sc = Voids.sc;
        System.out.print("Enter the phrase to encrypt: ");
        String input = sc.nextLine();

        StringBuilder encryptedMessage = new StringBuilder();

        int prefixIndex = key.indexOf('#');
        if (prefixIndex != -1) {
            String prefix = key.substring(prefixIndex);
            String prefixKey = key.substring(0, prefixIndex + 1);
            encryptedMessage.append(prefixKey);

            StringBuilder tempKeyBuilder = new StringBuilder();

            boolean inPrefixKey = true;
            int keyPartCount = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (prefix.indexOf(c) != -1 && inPrefixKey) {
                    inPrefixKey = false;
                    encryptedMessage.append(tempKeyBuilder);
                    tempKeyBuilder.setLength(0);
                    keyPartCount = 0;
                }

                if (inPrefixKey) {
                    if (Character.isLetter(c)) {
                        tempKeyBuilder.append(c);
                    } else if (Character.isDigit(c)) {
                        keyPartCount = Integer.parseInt(String.valueOf(c));
                        encryptedMessage.append(key.substring(0, keyPartCount));
                    }
                } else {
                    encryptedMessage.append(c);
                }

                if (keyPartCount > 0) {
                    keyPartCount--;
                } else {
                    keyPartCount = 0;
                }
            }
        } else {
            encryptedMessage.append(key).append(input);
        }

        System.out.println("Encrypted message: " + encryptedMessage);
    }

    private static void Decryption() {
        Scanner sc = Voids.sc;
        System.out.print("Enter the phrase to decrypt: ");
        String input = sc.nextLine();

        StringBuilder decryptedMessage = new StringBuilder();

        int prefixIndex = key.indexOf('#');
        if (prefixIndex != -1 && input.startsWith(key.substring(0, prefixIndex + 1))) {
            String prefixKey = key.substring(0, prefixIndex + 1);
            input = input.substring(prefixKey.length());

            boolean inPrefixKey = true;
            int keyPartCount = 0;
            StringBuilder tempKeyBuilder = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);

                if (prefixKey.indexOf(c) != -1 && inPrefixKey) {
                    inPrefixKey = false;
                    decryptedMessage.append(tempKeyBuilder);
                    tempKeyBuilder.setLength(0);
                    keyPartCount = 0;
                }

                if (inPrefixKey) {
                    if (Character.isLetter(c)) {
                        tempKeyBuilder.append(c);
                    } else if (Character.isDigit(c)) {
                        keyPartCount = Integer.parseInt(String.valueOf(c));
                        decryptedMessage.append(key.substring(0, keyPartCount));
                    }
                } else {
                    decryptedMessage.append(c);
                }

                if (keyPartCount > 0) {
                    keyPartCount--;
                } else {
                    keyPartCount = 0;
                }
            }
        }

        System.out.println("Decrypted message: " + decryptedMessage);
    }
}

class GenerateKey implements Runnable {
    private static final String PREFIXES = "#&%$?!,@.";
    private static final Random random = Voids.random;

    @Override
    public void run() {
        HowToDoThisWhenYou.key = generateNewKey();
    }

    private String generateNewKey() {
        StringBuilder keyBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A'); // Generate a random uppercase letter
            keyBuilder.append(randomChar);
        }

        String key = keyBuilder.toString();

        StringBuilder encryptedKeyBuilder = new StringBuilder();
        encryptedKeyBuilder.append('#');

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            String binary = Integer.toBinaryString(c);
            int numOfOnes = binary.replaceAll("0", "").length();
            int numOfZeros = binary.replaceAll("1", "").length();
            int shift = (int) ((numOfOnes / (double) numOfZeros) * binary.length() + 1);
            shift %= binary.length();

            String shiftedBinary = shiftedBinary(binary, shift);
            encryptedKeyBuilder.append(shiftedBinary);
            encryptedKeyBuilder.append(c);
        }

        return encryptedKeyBuilder.toString();
    }

    private String shiftedBinary(String binary, int shift) {
        StringBuilder shiftedBuilder = new StringBuilder();
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                shiftedBuilder.append('1');
            } else if (c == '0') {
                shiftedBuilder.append('0');
            } else {
                shiftedBuilder.append('/');
            }
        }

        shiftedBuilder.append(shiftedBuilder.substring(0, shift));
        shiftedBuilder.delete(0, shift);

        return shiftedBuilder.toString();
    }
}
