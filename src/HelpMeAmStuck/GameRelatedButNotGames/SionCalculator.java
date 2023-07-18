package HelpMeAmStuck.GameRelatedButNotGames;

public class SionCalculator {
    private int deathsOnSion;
    private int killsOnSion;
    private int deathsOnEnemy;
    private int killsOnEnemy;
    private int csOnSion;
    private int csOnEnemy;
    private int turretPlatingsOnSion;
    private int turretPlatingsOnEnemy;
    private int levelOnSion;
    private int levelOnEnemy;
    private int startingMoney = 500;
    private String[] startingItems = {"Doran's Blade", "Doran's Shield", "Cull"};

    // Constructor
    public SionCalculator(int deathsOnSion, int killsOnSion, int deathsOnEnemy, int killsOnEnemy,
                          int csOnSion, int csOnEnemy, int turretPlatingsOnSion, int turretPlatingsOnEnemy,
                          int levelOnSion, int levelOnEnemy) {
        this.deathsOnSion = deathsOnSion;
        this.killsOnSion = killsOnSion;
        this.deathsOnEnemy = deathsOnEnemy;
        this.killsOnEnemy = killsOnEnemy;
        this.csOnSion = csOnSion;
        this.csOnEnemy = csOnEnemy;
        this.turretPlatingsOnSion = turretPlatingsOnSion;
        this.turretPlatingsOnEnemy = turretPlatingsOnEnemy;
        this.levelOnSion = levelOnSion;
        this.levelOnEnemy = levelOnEnemy;
    }

    public int calculateGoldForSion() {
        int goldForSion = startingMoney;

        // Calculate gold based on kills, deaths, CS, turret platings, and other factors
        goldForSion += calculateGoldFromKills(killsOnSion);
        goldForSion -= calculateGoldFromDeaths(deathsOnSion);
        goldForSion += calculateGoldFromCS(csOnSion);
        goldForSion += calculateGoldFromTurretPlatings(turretPlatingsOnSion);

        return goldForSion;
    }

    public int calculateGoldForEnemy() {
        int goldForEnemy = startingMoney;

        // Calculate gold based on kills, deaths, CS, turret platings, and other factors
        goldForEnemy += calculateGoldFromKills(killsOnEnemy);
        goldForEnemy -= calculateGoldFromDeaths(deathsOnEnemy);
        goldForEnemy += calculateGoldFromCS(csOnEnemy);
        goldForEnemy += calculateGoldFromTurretPlatings(turretPlatingsOnEnemy);

        return goldForEnemy;
    }

    private int calculateGoldFromKills(int kills) {
        if (kills >= 8) {
            int extraKills = kills - 7;
            return 1000 + (extraKills * 100);
        } else {
            int[] killBounties = {300, 450, 600, 700, 800, 900, 1000};
            return killBounties[kills];
        }
    }

    private int calculateGoldFromDeaths(int deaths) {
        if (deaths <= -6) {
            int extraDeaths = deaths + 6;
            return 100 - (extraDeaths * 12);
        } else if (deaths == -1) {
            return 274;
        } else if (deaths == -2) {
            return 220;
        } else if (deaths == -3) {
            return 176;
        } else if (deaths == -4) {
            return 140;
        } else if (deaths == -5) {
            return 112;
        } else {
            return 0;
        }
    }

    private int calculateGoldFromCS(int cs) {
        if (cs >= 100) {
            return 450 + 350;
        } else {
            return cs;
        }
    }

    private int calculateGoldFromTurretPlatings(int turretPlatings) {
        return turretPlatings * 160;
    }

    public static void BausLaw() {
        // Example usage
        SionCalculator calculator = new SionCalculator(0, 10, 5, 2, 150, 100, 2, 1, 10, 8);
        int goldForSion = calculator.calculateGoldForSion();
        int goldForEnemy = calculator.calculateGoldForEnemy();

        System.out.println("Gold for Sion: " + goldForSion);
        System.out.println("Gold for Enemy: " + goldForEnemy);
    }
}
