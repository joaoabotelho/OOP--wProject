import java.util.ArrayList;

public class Main {
    protected static Event event;
    protected GUI_Management manage;

    public Main() {
        this.manage = new GUI_Management();
    }

    public static void main(String[] args) {
        ArrayList<Person> people, guest; // use arraylists???
        ArrayList<Spot> spots;

        spots = new ArrayList<Spot>();
        guest = new ArrayList<Person>();

        ArrayList<String> sports = new ArrayList<String>();

        sports.add("Judo");
        sports.add("Basket");
        sports.add("Badminton");
        sports.add("Tenis");

        Coordinates expoCoor = new Coordinates(10.12,10.21);
        Coordinates coord1 = new Coordinates(1212.2,-10.2);
        Exposition expo = new Exposition(expoCoor,9, "Painting",2.33);
        Garden gard[] = new Garden[10];
        SportsArea spo = new SportsArea(coord1, 8, sports);
        Bar b = new Bar (coord1, 8, "Casa dos Pregos", 8, 5, 50, guest);

        spots.add(expo);
        spots.add(spo);
        spots.add(b);
        for(int i = 0; i < 8; i++) {
            gard[i] = new Garden(expoCoor, 7, 200);
            spots.add(gard[i]);
        }


        people = new ArrayList<Person>();
        event = new Event(spots, people);
        new Login();
    }
}