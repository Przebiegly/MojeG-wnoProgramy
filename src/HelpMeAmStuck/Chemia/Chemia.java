package HelpMeAmStuck.Chemia;

import HelpMeAmStuck.Voids.Voids;

import java.util.HashMap;
import java.util.Map;


public class Chemia {

    public static void ChemiaPick() {
        ChemiaMapMaker();

        String input;
        while (true) {
            System.out.println("HelpMeAmStuck.Chemia.Chemia:");
            Voids.DisplayInputArrow();
            input = Voids.sc.nextLine();
            if (Voids.EndingProgram(input)) break;
            Voids.ChemiaSwitch(input);
            Voids.DisplayDevider2();

        }
    }

    public static Map<String, String> ChemiaPierwiastkiENG = new HashMap<>();
    public static Map<String, String> ChemiaPierwiastkiPL = new HashMap<>();

    public static String[] elementSymbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"};
    private static void ChemiaMapMaker() {

        String[] elementNamesEn = {"hydrogen", "helium", "lithium", "beryllium", "boron", "carbon", "nitrogen", "oxygen", "fluorine", "neon", "sodium", "magnesium", "aluminum", "silicon", "phosphorus", "sulfur", "chlorine", "argon", "potassium", "calcium", "scandium", "titanium", "vanadium", "chromium", "manganese", "iron", "cobalt", "nickel", "copper", "zinc", "gallium", "germanium", "arsenic", "selenium", "bromine", "krypton", "rubidium", "strontium", "yttrium", "zirconium", "niobium", "molybdenum", "technetium", "ruthenium", "rhodium", "palladium", "silver", "cadmium", "indium", "tin", "antimony", "tellurium", "iodine", "xenon", "cesium", "barium", "lanthanum", "cerium", "praseodymium", "neodymium", "promethium", "samarium", "europium", "gadolinium", "terbium", "dysprosium", "holmium", "erbium", "thulium", "ytterbium", "lutetium", "hafnium", "tantalum", "tungsten", "rhenium", "osmium", "iridium", "platinum", "gold", "mercury", "thallium", "lead", "bismuth", "polonium", "astatine", "radon", "francium", "radium", "actinium", "thorium", "protactinium", "uranium", "neptunium", "plutonium", "americium", "curium", "berkelium", "californium", "einsteinium", "fermium", "mendelevium", "nobelium", "lawrencium", "rutherfordium", "dubnium", "seaborgium", "bohrium", "hassium", "meitnerium", "darmstadtium", "roentgenium", "copernicium", "nihonium", "flerovium", "moscovium", "livermorium", "tennessine", "oganesson"};
        String[] elementNamesPl = {"wodór", "hel", "lit", "beryl", "bor", "węgiel", "azot", "tlen", "fluor", "neon", "sód", "magnez", "glin", "krzem", "fosfor", "siarka", "chlor", "argon", "potas", "wapń", "skand", "tytan", "wanad", "chrom", "mangan", "żelazo", "kobalt", "nikiel", "miedź", "cynk", "gal", "german", "arsen", "selen", "brom", "krypton", "rubid", "stront", "ittr", "cyrkon", "niob", "molibden", "technet", "ruten", "rod", "pallad", "srebro", "kadm", "ind", "cyna", "antymon", "tellur", "jod", "ksenon", "cez", "bar", "lantan", "cer", "prazeodym", "neodym", "promet", "sam", "europ", "gadolin", "terb", "dysp", "holm", "er", "tul", "ytterb", "lutet", "hafn", "tantal", "wolfram", "ren", "osm", "iryd", "platyna", "złoto", "rtęć", "tal", "ołów", "bizmut", "polon", "astat", "radon", "franc", "rad", "aktyn", "tor", "protakt", "uran", "neptun", "pluton", "amer", "kur", "berkel", "kaliforn", "einstein", "ferm", "mendelev", "nobel", "lawrenc", "rutherford", "dubn", "seaborg", "bohr", "hass", "meitn", "darmst", "roentgen", "copernic", "nihon", "flerov", "moskow", "liverm", "tenness", "oganesson"};

        for (int i = 0; i < elementSymbols.length; i++) {
            ChemiaPierwiastkiPL.put(elementSymbols[i], elementNamesPl[i]);
            ChemiaPierwiastkiENG.put(elementSymbols[i], elementNamesEn[i]);
        }

    }
}
