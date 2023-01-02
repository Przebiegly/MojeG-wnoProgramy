public class Jar {

    boolean IsOpen;
    double capacity;
    int value;
    String flavour;
    int position_id;


    public Jar(boolean IO, double cpt, int value, String flav, int id){
        String name = "";
        this.IsOpen = IO;
        if(IO){
            name = "Open";
        }else {
            name = "Closed";
        }
        this.capacity = cpt;
        this.value = value;
        this.flavour = flav;
        this.position_id = id;


    }


}
