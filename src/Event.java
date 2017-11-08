import java.util.ArrayList;
import javax.swing.*;

class Event{
    public static ArrayList<Spot> spots;
    public static ArrayList<Person> people;
    public static int min_revenue;

    public Event(ArrayList<Spot> spots, ArrayList<Person> people) {
        this.spots = spots;
        this.people = people;
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
    protected String username, password, name, profile, post, subPost;
    protected ArrayList<Spot> chosenSpots;

    public Person(String username, String password, String name, String profile, String post, String subPost, ArrayList<Spot> chosenSpots) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.profile = profile;
        this.post = post;
        this.subPost = subPost;
        this.chosenSpots = chosenSpots;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Teacher extends Person{
    public Teacher(String username, String password, String name, String profile, String subPost, ArrayList<Spot> chosenSpots) {
        super(username, password, name, profile, "Teacher", subPost, chosenSpots);
    }
}

class Employee extends Person{
    public Employee(String username, String password, String name, String profile, String subPost, ArrayList<Spot> chosenSpots) {
        super(username, password, name, profile, "Employee", subPost, chosenSpots);
    }
}

class Student extends Person{
    public Student(String username, String password, String name, String profile, String course, ArrayList<Spot> chosenSpots) {
        super(username, password, name, profile, "Student", course, chosenSpots);
    }
}

class Park extends Spot{
    protected String subType;

    public Park(Coordinates place, int subs, String subType) {
        super(place, subs, "Park");
        this.subType = subType;
    }
}

class Garden extends Park{
    private int area;

    public Garden(Coordinates place, int subs, String type, String subType, int area) {
        super(place, subs, "Garden");
        this.area = area;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "place=" + place +
                ", subs=" + subs +
                ", type='" + type + '\'' +
                ", sub_type='" + subType + '\'' +
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
                ", sub_type='" + subType + '\'' +
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
    private int capacity, minConsump, percGuest;
    private ArrayList<Person> guest_list;

    public Bar(Coordinates place, int subs, String type, int capacity, int minConsump, int percGuest, ArrayList<Person> guest_list) {
        super(place, subs, type);
        this.capacity = capacity;
        this.minConsump = minConsump;
        this.percGuest = percGuest;
        this.guest_list = guest_list;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "place=" + place +
                ", subs=" + subs +
                ", type='" + type + '\'' +
                ", capacity=" + capacity +
                ", minConsump=" + minConsump +
                ", percGuest=" + percGuest +
                ", guest_list=" + guest_list +
                '}';
    }
}

