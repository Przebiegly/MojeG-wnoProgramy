package HelpMeAmStuck.GameRelatedButNotGames;

import java.util.ArrayList;
import java.util.List;

class BaseInformation {
    private double baseAD;
    private double baseAP;
    private double baseAS;
    private int baseHealth;
    private boolean mana;
    private double manaRegen;
    private boolean energy;
    private double energyRegen;
    private double baseHPRegen;
    private double MR;
    private double armor;

    public BaseInformation(double baseAD, double baseAP, double baseAS, int baseHealth, boolean mana,
                           double manaRegen, boolean energy, double energyRegen, double baseHPRegen,
                           double MR, double armor) {
        this.baseAD = baseAD;
        this.baseAP = baseAP;
        this.baseAS = baseAS;
        this.baseHealth = baseHealth;
        this.mana = mana;
        this.manaRegen = manaRegen;
        this.energy = energy;
        this.energyRegen = energyRegen;
        this.baseHPRegen = baseHPRegen;
        this.MR = MR;
        this.armor = armor;
    }

    // Getters for the properties

    public double getBaseAD() {
        return baseAD;
    }

    public double getBaseAP() {
        return baseAP;
    }

    public double getBaseAS() {
        return baseAS;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public boolean hasMana() {
        return mana;
    }

    public double getManaRegen() {
        return manaRegen;
    }

    public boolean hasEnergy() {
        return energy;
    }

    public double getEnergyRegen() {
        return energyRegen;
    }

    public double getBaseHPRegen() {
        return baseHPRegen;
    }

    public double getMR() {
        return MR;
    }

    public double getArmor() {
        return armor;
    }
}

class PerLevelInformation {
    private double ADperLevel;
    private double APperLevel;
    private double ASperLevel;
    private int healthPerLevel;
    private double manaPerLevel;
    private double manaRegenPerLevel;
    private double energyPerLevel;
    private double energyRegenPerLevel;
    private double HPRegenPerLevel;

    public PerLevelInformation(double ADperLevel, double APperLevel, double ASperLevel, int healthPerLevel,
                               double manaPerLevel, double manaRegenPerLevel, double energyPerLevel,
                               double energyRegenPerLevel, double HPRegenPerLevel) {
        this.ADperLevel = ADperLevel;
        this.APperLevel = APperLevel;
        this.ASperLevel = ASperLevel;
        this.healthPerLevel = healthPerLevel;
        this.manaPerLevel = manaPerLevel;
        this.manaRegenPerLevel = manaRegenPerLevel;
        this.energyPerLevel = energyPerLevel;
        this.energyRegenPerLevel = energyRegenPerLevel;
        this.HPRegenPerLevel = HPRegenPerLevel;
    }

    // Getters for the properties

    public double getADperLevel() {
        return ADperLevel;
    }

    public double getAPperLevel() {
        return APperLevel;
    }

    public double getASperLevel() {
        return ASperLevel;
    }

    public int getHealthPerLevel() {
        return healthPerLevel;
    }

    public double getManaPerLevel() {
        return manaPerLevel;
    }

    public double getManaRegenPerLevel() {
        return manaRegenPerLevel;
    }

    public double getEnergyPerLevel() {
        return energyPerLevel;
    }

    public double getEnergyRegenPerLevel() {
        return energyRegenPerLevel;
    }

    public double getHPRegenPerLevel() {
        return HPRegenPerLevel;
    }
}

class FromItemInformation {
    private String itemName;
    private double itemAD;
    private double itemAP;
    private double itemAS;
    private int itemHealth;
    private boolean itemMana;
    private double itemManaRegen;
    private boolean itemEnergy;
    private double itemEnergyRegen;
    private double itemHPRegen;
    private double itemMR;
    private double itemArmor;

    public FromItemInformation(String itemName, double itemAD, double itemAP, double itemAS, int itemHealth,
                               boolean itemMana, double itemManaRegen, boolean itemEnergy, double itemEnergyRegen,
                               double itemHPRegen, double itemMR, double itemArmor) {
        this.itemName = itemName;
        this.itemAD = itemAD;
        this.itemAP = itemAP;
        this.itemAS = itemAS;
        this.itemHealth = itemHealth;
        this.itemMana = itemMana;
        this.itemManaRegen = itemManaRegen;
        this.itemEnergy = itemEnergy;
        this.itemEnergyRegen = itemEnergyRegen;
        this.itemHPRegen = itemHPRegen;
        this.itemMR = itemMR;
        this.itemArmor = itemArmor;
    }

    // Getters for the properties

    public String getItemName() {
        return itemName;
    }

    public double getItemAD() {
        return itemAD;
    }

    public double getItemAP() {
        return itemAP;
    }

    public double getItemAS() {
        return itemAS;
    }

    public int getItemHealth() {
        return itemHealth;
    }

    public boolean hasItemMana() {
        return itemMana;
    }

    public double getItemManaRegen() {
        return itemManaRegen;
    }

    public boolean hasItemEnergy() {
        return itemEnergy;
    }

    public double getItemEnergyRegen() {
        return itemEnergyRegen;
    }

    public double getItemHPRegen() {
        return itemHPRegen;
    }

    public double getItemMR() {
        return itemMR;
    }

    public double getItemArmor() {
        return itemArmor;
    }
}

class ItemStats {
    private double totalAD;
    private double totalAP;
    private double totalAS;
    private int totalHealth;
    private boolean hasMana;
    private double totalManaRegen;
    private boolean hasEnergy;
    private double totalEnergyRegen;
    private double totalHPRegen;
    private double totalMR;
    private double totalArmor;

    public ItemStats() {
        totalAD = 0.0;
        totalAP = 0.0;
        totalAS = 0.0;
        totalHealth = 0;
        hasMana = false;
        totalManaRegen = 0.0;
        hasEnergy = false;
        totalEnergyRegen = 0.0;
        totalHPRegen = 0.0;
        totalMR = 0.0;
        totalArmor = 0.0;
    }

    public void updateStats(FromItemInformation item) {
        totalAD += item.getItemAD();
        totalAP += item.getItemAP();
        totalAS += item.getItemAS();
        totalHealth += item.getItemHealth();
        if (item.hasItemMana()) {
            hasMana = true;
            totalManaRegen += item.getItemManaRegen();
        }
        if (item.hasItemEnergy()) {
            hasEnergy = true;
            totalEnergyRegen += item.getItemEnergyRegen();
        }
        totalHPRegen += item.getItemHPRegen();
        totalMR += item.getItemMR();
        totalArmor += item.getItemArmor();
    }

    // Getters for the properties

    public double getTotalAD() {
        return totalAD;
    }

    public double getTotalAP() {
        return totalAP;
    }

    public double getTotalAS() {
        return totalAS;
    }

    public int getTotalHealth() {
        return totalHealth;
    }

    public boolean hasMana() {
        return hasMana;
    }

    public double getTotalManaRegen() {
        return totalManaRegen;
    }

    public boolean hasEnergy() {
        return hasEnergy;
    }

    public double getTotalEnergyRegen() {
        return totalEnergyRegen;
    }

    public double getTotalHPRegen() {
        return totalHPRegen;
    }

    public double getTotalMR() {
        return totalMR;
    }

    public double getTotalArmor() {
        return totalArmor;
    }
}

class ChampionStatsCalculator {
    private BaseInformation baseInfo;
    private PerLevelInformation perLevelInfo;
    private ItemStats itemStats;

    public ChampionStatsCalculator(BaseInformation baseInfo, PerLevelInformation perLevelInfo) {
        this.baseInfo = baseInfo;
        this.perLevelInfo = perLevelInfo;
        this.itemStats = new ItemStats();
    }

    public void equipItem(FromItemInformation item) {
        itemStats.updateStats(item);
    }

    public void printStats() {
        System.out.println("Champion Stats:");
        System.out.println("Base AD: " + baseInfo.getBaseAD());
        System.out.println("Base AP: " + baseInfo.getBaseAP());
        System.out.println("Base AS: " + baseInfo.getBaseAS());
        System.out.println("Base Health: " + baseInfo.getBaseHealth());
        System.out.println("Mana: " + (baseInfo.hasMana() ? "Yes" : "No"));
        System.out.println("Mana Regeneration: " + baseInfo.getManaRegen());
        System.out.println("Energy: " + (baseInfo.hasEnergy() ? "Yes" : "No"));
        System.out.println("Energy Regeneration: " + baseInfo.getEnergyRegen());
        System.out.println("Base HP Regeneration: " + baseInfo.getBaseHPRegen());
        System.out.println("Magic Resist: " + baseInfo.getMR());
        System.out.println("Armor: " + baseInfo.getArmor());

        System.out.println("\nStats Per Level:");
        System.out.println("AD per Level: " + perLevelInfo.getADperLevel());
        System.out.println("AP per Level: " + perLevelInfo.getAPperLevel());
        System.out.println("AS per Level: " + perLevelInfo.getASperLevel());
        System.out.println("Health per Level: " + perLevelInfo.getHealthPerLevel());
        System.out.println("Mana per Level: " + perLevelInfo.getManaPerLevel());
        System.out.println("Mana Regeneration per Level: " + perLevelInfo.getManaRegenPerLevel());
        System.out.println("Energy per Level: " + perLevelInfo.getEnergyPerLevel());
        System.out.println("Energy Regeneration per Level: " + perLevelInfo.getEnergyRegenPerLevel());
        System.out.println("HP Regeneration per Level: " + perLevelInfo.getHPRegenPerLevel());

        System.out.println("\nItem Stats:");
        System.out.println("Total AD: " + itemStats.getTotalAD());
        System.out.println("Total AP: " + itemStats.getTotalAP());
        System.out.println("Total AS: " + itemStats.getTotalAS());
        System.out.println("Total Health: " + itemStats.getTotalHealth());
        System.out.println("Mana: " + (itemStats.hasMana() ? "Yes" : "No"));
        System.out.println("Total Mana Regeneration: " + itemStats.getTotalManaRegen());
        System.out.println("Energy: " + (itemStats.hasEnergy() ? "Yes" : "No"));
        System.out.println("Total Energy Regeneration: " + itemStats.getTotalEnergyRegen());
        System.out.println("Total HP Regeneration: " + itemStats.getTotalHPRegen());
        System.out.println("Total Magic Resist: " + itemStats.getTotalMR());
        System.out.println("Total Armor: " + itemStats.getTotalArmor());
    }
}

public class ChampionStatsApp {
    public static void Test() {
        // Create base information
        BaseInformation baseInfo = new BaseInformation(100.0, 50.0, 1.0, 1000, true,
                10.0, false, 0.0, 5.0, 30.0, 20.0);

        // Create per level information
        PerLevelInformation perLevelInfo = new PerLevelInformation(10.0, 5.0, 0.1, 100, 10.0,
                1.0, 0.0, 0.0, 1.0);

        // Create champion stats calculator
        ChampionStatsCalculator calculator = new ChampionStatsCalculator(baseInfo, perLevelInfo);

        // Create and equip items
        List<FromItemInformation> items = new ArrayList<>();
        items.add(new FromItemInformation("Item 1", 20.0, 0.0, 0.2, 200, false,
                0.0, false, 0.0, 2.0, 10.0, 5.0));
        items.add(new FromItemInformation("Item 2", 0.0, 30.0, 0.3, 0, true,
                5.0, false, 0.0, 0.0, 5.0, 0.0));
        items.add(new FromItemInformation("Item 3", 10.0, 0.0, 0.1, 100, false,
                0.0, true, 10.0, 1.0, 5.0, 0.0));

        for (FromItemInformation item : items) {
            calculator.equipItem(item);
        }

        // Print champion stats
        calculator.printStats();
    }
}
