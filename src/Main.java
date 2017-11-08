import java.util.ArrayList;

public class Main {
    protected static Event event;
    protected GUI_Management manage;

    public Main(){
        this.manage = new GUI_Management();
    }

    public static void main(String[] args) {
        ArrayList<Person> people; // use arraylists???
        ArrayList<Spot> spots;

        spots = new ArrayList<Spot>();
        people = new ArrayList<Person>();
        event = new Event(spots, people);
        new Login();
   }
}
