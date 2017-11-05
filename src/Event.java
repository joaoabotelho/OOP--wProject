import java.util.ArrayList;
import javax.swing.*;

public class Event{
    ArrayList<Spot> spots;
    ArrayList<Person> people;
    int min_revenue;

    public static void main(String[] args) {
        Login init = new Login();
        init.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init.setTitle("APP");
        init.setSize(400,400);
        init.setVisible(true);
    }
}

class Coordinates{
   private int latitude, longitude, elevation;

    public Coordinates(int latitude, int longitude, int elevation) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.elevation = elevation;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", elevation=" + elevation +
                '}';
    }
}

class Spot{
    protected Coordinates place;
    protected int subs;
    protected String type;

    public Spot(Coordinates place, int subs, String type) {
        this.place = place;
        this.subs = subs;
        this.type = type;
    }
}

class Person{
    protected String username, password, name, profile, post, sub_post;
    protected ArrayList<Spot> chosen_spots;

    public Person(String username, String password, String name, String profile, String post, String sub_post, ArrayList<Spot> chosen_spots) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.profile = profile;
        this.post = post;
        this.sub_post = sub_post;
        this.chosen_spots = chosen_spots;
    }
}

class Teacher extends Person{
    public Teacher(String username, String password, String name, String profile, String sub_post, ArrayList<Spot> chosen_spots) {
        super(username, password, name, profile, "Teacher", sub_post, chosen_spots);
    }
}

class Employee extends Person{
    public Employee(String username, String password, String name, String profile, String sub_post, ArrayList<Spot> chosen_spots){
        super(username, password, name, profile, "Employee", sub_post, chosen_spots);
    }
}

class Student extends Person{
    public Student(String username, String password, String name, String profile, String course, ArrayList<Spot> chosen_spots) {
        super(username, password, name, profile, "Student", course, chosen_spots);
    }
}

class Park extends Spot{
    protected String sub_type;

    public Park(Coordinates place, int subs, String sub_type) {
        super(place, subs, "Park");
        this.sub_type = sub_type;
    }
}

class Garden extends Park{
    private int area;

    public Garden(Coordinates place, int subs, int area) {
        super(place, subs, "Garden");
        this.area = area;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "place=" + place +
                ", subs=" + subs +
                ", type='" + type + '\'' +
                ", sub_type='" + sub_type + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}

class Sports_Area extends Park{
    private ArrayList<String> sports;

    public Sports_Area(Coordinates place, int subs, ArrayList<String> sports) {
        super(place, subs, "Sports Area");
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "Sports_Area{" +
                "place=" + place +
                ", subs=" + subs +
                ", type='" + type + '\'' +
                ", sub_type='" + sub_type + '\'' +
                ", sports=" + sports +
                '}';
    }
}

class Exposition extends Spot{
    private String art;
    private int cost;

    public Exposition(Coordinates place, int subs, String art, int cost) {
        super(place, subs, "Exposition");
        this.art = art;
        this.cost = cost;
    }
}

class Bar extends Spot{
    private int capacity, min_consump, perc_guest;
    private ArrayList<Person> guest_list;


    public Bar(Coordinates place, int subs, String type, int capacity, int min_consump, int perc_guest, ArrayList<Person> guest_list) {
        super(place, subs, type);
        this.capacity = capacity;
        this.min_consump = min_consump;
        this.perc_guest = perc_guest;
        this.guest_list = guest_list;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "place=" + place +
                ", subs=" + subs +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", min_consump=" + min_consump +
                ", perc_guest=" + perc_guest +
                ", guest_list=" + guest_list +
                '}';
    }
}

