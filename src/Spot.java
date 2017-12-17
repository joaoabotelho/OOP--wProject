import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

class Coordinates implements Serializable{
    private Double latitude, longitude;

    Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "latitude: " + latitude + "| length: " + longitude;
    }

}

class Spot implements Serializable {
    private Coordinates place;
    private String type;
    int subs;

    Spot(Coordinates place, int subs, String type) {
        this.place = place;
        this.subs = subs;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "place=" + place +
                ", type='" + type + '\'' +
                ", subs=" + subs +
                '}';
    }

    Coordinates getPlace() {
        return place;
    }

    int getSubs() {
        return subs;
    }

    public String getType() {
        return type;
    }

    public Double getCost(Person user) {
        return 0.0;
    }

    public String stringCapacity(){
        return "";
    }

    public void InfoUI(JFrame frame, Person user) { }
}

class Park extends Spot{
    private String subType;

    Park(Coordinates place, int subs, String subType) {
        super(place, subs, "Park");
        this.subType = subType;
    }

    @Override
    public String getType() {
        return subType;
    }
}

class Garden extends Park{
    private int area;

    Garden(Coordinates place, int subs, int area) {
        super(place, subs, "Garden");
        this.area = area;
    }

    @Override
    public void InfoUI(JFrame frame, Person user){
        JLabel area = new JLabel("Area(m2): " + Integer.toString(this.area));
        frame.add(area);
    }
}

class SportsArea extends Park{
    private ArrayList<String> sports;

    SportsArea(Coordinates place, int subs, ArrayList<String> sports) {
        super(place, subs, "Sports Area");
        this.sports = sports;
    }

    @Override
    public void InfoUI(JFrame frame, Person user){
        JPanel f = new JPanel(new GridLayout(2,1));
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JScrollPane sports = new JScrollPane(panel);
        JLabel label = new JLabel("Sports");

        label.setFont(new Font("Arial", Font.BOLD, 15));
        f.add(label);
        for (String sport : this.sports){
            label = new JLabel(sport);
            label.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(label);
        }

        f.add(sports);
        frame.add(f);
    }
}

class Exposition extends Spot{
    private String art;
    private Double cost;

    Exposition(Coordinates place, int subs, String art, Double cost) {
        super(place, subs, "Exposition");
        this.art = art;
        this.cost = cost;
    }

    @Override
    public Double getCost(Person user) {
        return user.expoCost(cost);
    }

    @Override
    public String getType() {
        return super.getType() + " - " + art;
    }

    @Override
    public void InfoUI(JFrame frame, Person user){
        double cost;
        cost = user.expoCost(this.cost);
        JLabel costL = new JLabel("Cost: " + cost + "€");
        frame.add(costL);
    }
}

class Bar extends Spot{
    private String name;
    private int capacity, percGuest;
    private Double minConsump;
    private ArrayList<Person> guestList;
    private ArrayList<Person> bohemianWaiting;

    Bar(Coordinates place, int subs, String name, int capacity, Double minConsump, int percGuest, ArrayList<Person> guestList){
        super(place, subs, "Bar");
        this.name = name;
        this.capacity = capacity;
        this.minConsump = minConsump;
        this.percGuest = percGuest;
        this.guestList = guestList;
    }

    int getCapacity() {
        return capacity;
    }

    @Override
    public String stringCapacity(){
        return "(Max: " + capacity + ")";
    }

    @Override
    public String getType() {
        return super.getType() + " - " + name;
    }

    ArrayList<Person> getGuestList() {
        return guestList;
    }

    @Override
    public Double getCost(Person user) {
        return minConsump;
    }

    public int getPercGuest() {
        return percGuest;
    }

    @Override
    public void InfoUI(JFrame frame, Person user){
        JLabel minConsump = new JLabel("Minimum Consumption: " + this.minConsump + "€");
        JPanel f = new JPanel(new GridLayout(2,1));
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JScrollPane guest = new JScrollPane(panel);
        JLabel label = new JLabel("Guest List (Max: " + this.percGuest * this.capacity / 100 + ")");
        String str;
        ArrayList<Person> guestArray = this.guestList;
        GUI_Management manage = new GUI_Management();

        label.setFont(new Font("Arial", Font.BOLD, 15));
        f.add(label);
        for (Person p: guestArray) {
            str = p.guestPresent();
            label = new JLabel(str);
            label.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(label);
        }

        f.add(guest);
        manage.addFrame(frame, minConsump, f);
    }
}
