import java.util.ArrayList;

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
   private Double latitude, longitude, elevation;

    public Coordinates(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "latitude: " + latitude + "| length: " + longitude;
    }

}

class Spot {
    protected Coordinates place;
    protected int subs;
    protected String type;

    public Spot(Coordinates place, int subs, String type) {
        this.place = place;
        this.subs = subs;
        this.type = type;
    }

    public Coordinates getPlace() {
        return place;
    }

    public int getSubs() {
        return subs;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "place=" + place +
                ", subs=" + subs +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }
}

class Person{
    protected String username, name, profile, post, subPost;
    protected char[] password;
    protected ArrayList<Spot> chosenSpots;

    public Person(String username, char[] password, String name, String profile, String post, String subPost, ArrayList<Spot> chosenSpots) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.profile = profile;
        this.post = post;
        this.subPost = subPost;
        this.chosenSpots = chosenSpots;
    }

    public ArrayList<Spot> getChosenSpots() {
        return chosenSpots;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }
}

class Teacher extends Person{
    public Teacher(String username, char[] password, String name, String profile, String subPost, ArrayList<Spot> chosenSpots) {
        super(username, password, name, profile, "Teacher", subPost, chosenSpots);
    }
}

class Employee extends Person{
    public Employee(String username, char[] password, String name, String profile, String subPost, ArrayList<Spot> chosenSpots) {
        super(username, password, name, profile, "Employee", subPost, chosenSpots);
    }
}

class Student extends Person{
    public Student(String username, char[] password, String name, String profile, String course, ArrayList<Spot> chosenSpots) {
        super(username, password, name, profile, "Student", course, chosenSpots);
    }
}

class Park extends Spot{
    protected String subType;

    public Park(Coordinates place, int subs, String subType) {
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

    public Garden(Coordinates place, int subs, int area) {
        super(place, subs, "Garden");
        this.area = area;
    }

    public int getArea() {
        return area;
    }
}

class SportsArea extends Park{
    private ArrayList<String> sports;

    public SportsArea(Coordinates place, int subs, ArrayList<String> sports) {
        super(place, subs, "Sports Area");
        this.sports = sports;
    }

    public ArrayList<String> getSports() {
        return sports;
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
    private Double cost;

    public Exposition(Coordinates place, int subs, String art, Double cost) {
        super(place, subs, "Exposition");
        this.art = art;
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }

    public String getArt() {
        return art;
    }

    @Override
    public String getType() {
        return super.getType() + " - " + art;
    }
}

class Bar extends Spot{
    private String name;
    private int capacity, minConsump, percGuest;
    private ArrayList<Person> guestList;

    public Bar(Coordinates place, int subs, String name, int capacity, int minConsump, int percGuest, ArrayList<Person> guestList) {
        super(place, subs, "Bar");
        this.name = name;
        this.capacity = capacity;
        this.minConsump = minConsump;
        this.percGuest = percGuest;
        this.guestList = guestList;
    }

    public int getPercGuest() {
        return percGuest;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getType() {
        return super.getType() + " - " + name;
    }

    public ArrayList<Person> getGuestList() {
        return guestList;
    }

    public int getMinConsump() {
        return minConsump;
    }
}