package HelpMeAmStuck.Genge;

import HelpMeAmStuck.Voids.Voids;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GengeLotto {
    public static void Kumulacja() {
        Random random = new Random();
        List<Integer> Winners = new ArrayList<>();
        int Population = random.nextInt(10, 1000);
        int LottoNumber = random.nextInt(999, 9999); // chance of winning is 1:9000

        LottoPerson[] lottoPerson = new LottoPerson[Population];
        for (int i = 0; i < lottoPerson.length; i++) {
            int PersonPrediction = random.nextInt(999, 9999);
            lottoPerson[i] = new LottoPerson(i, PersonPrediction);
        }

        int totalCombinations = 9999 - 999 + 1;
        double chancesNoWin = Math.pow((totalCombinations - 1) / (double) totalCombinations, Population);

        for (int i = 0; i < lottoPerson.length; i++) {
            if (lottoPerson[i].LottoNumber == LottoNumber) {
                Winners.add(lottoPerson[i].id);
            }
        }

        for (LottoPerson person : lottoPerson) System.out.println("id #" + person.id + " > " + person.LottoNumber);
        Voids.DisplayDevider3();
        if (Winners.isEmpty()) {
            System.out.println("No one won!");
            Voids.DisplayInputArrow();
            System.out.println(LottoNumber);
        } else {
            System.out.println("We have a winner!");
            for (int i = 0; i < Winners.size(); i++) {
                System.out.println(Winners.get(i));
            }
            System.out.println("For Number");
            Voids.DisplayInputArrow();
            System.out.println(LottoNumber);
        }

        System.out.println("Total Combinations: " + totalCombinations);
        System.out.println("Chances for No Win: " + chancesNoWin);
    }
}

class LottoPerson {
    int id;
    int LottoNumber;

    public LottoPerson(int ID, int LottoNumber) {
        this.id = ID;
        this.LottoNumber = LottoNumber;
    }

}
