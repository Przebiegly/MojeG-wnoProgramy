import java.util.ArrayList;

public class Płacownik {
    int id;
    String name;
    String CompanyName;

    ArrayList<Integer>WorkerId = new ArrayList<>();

    public Płacownik(int id, String name, String CompanyName){
        this.id = id;
        this.name = name;
        this.CompanyName = CompanyName;
    }
}
