import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

class Event{
    private ArrayList<Spot> spots;
    private ArrayList<Person> people;
    private ArrayList<String> dei;
    private int min_revenue;
    private String usersInfoPath = "/Users/tiagomartins/github/OOP-Project/src/usersInfo.txt";
    private String deiMembersPath = "/Users/tiagomartins/github/OOP-Project/src/DEIMembers.txt";
    private String spotsPath = "/Users/tiagomartins/github/OOP-Project/src/spots.txt";

    public Event() {
        try {
            this.spots = this.importSpots();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Event{" +
                "spots=" + spots +
                ", people=" + people +
                ", dei=" + dei +
                ", min_revenue=" + min_revenue +
                ", usersInfoPath='" + usersInfoPath + '\'' +
                ", deiMembersPath='" + deiMembersPath + '\'' +
                ", spotsPath='" + spotsPath + '\'' +
                '}';
    }


    public static ArrayList<Person> getPeople() {
        ArrayList<Person> p = new ArrayList<>();
        return p;
    }

    private void init(){
        try {
            this.importSpots();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    private ArrayList<Spot> importSpots() throws IOException{
        ArrayList<Spot> importedSpots = new ArrayList<>();
        FileReader fr = new FileReader(spotsPath);
        BufferedReader reader = new BufferedReader(fr);
        Coordinates c;
        Garden g;
        Sports_Area s;
        Exposition e;
        Bar b;
        ArrayList<Person> people;
        ArrayList<String> sports;

        String line = reader.readLine();
        String[] sLine;

        while(line != null) {
            sLine = line.split(";");
            line = reader.readLine();
            System.out.println(sLine[0]);
            switch (sLine[0]) {
                case "Garden":
                    c = new Coordinates(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]));
                    g = new Garden(c, Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5]));
                    importedSpots.add(g);
                    break;

                case "Sports_Area":
                    sports = getRemainder(sLine);
                    c = new Coordinates(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]));
                    s = new Sports_Area(c, Integer.parseInt(sLine[4]), sports);
                    importedSpots.add(s);
                    break;

                case "Exposition":
                    c = new Coordinates(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]));
                    e = new Exposition(c, Integer.parseInt(sLine[4]), sLine[5], Double.parseDouble(sLine[6]));
                    System.out.println(e);
                    importedSpots.add(e);
                    break;

                case "Bar":
                    c = new Coordinates(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]));
                    people = new ArrayList<>();
                    b = new Bar(c, Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5]), Double.parseDouble(sLine[6]), Integer.parseInt(sLine[7]), people);
                    importedSpots.add(b);
                    break;
            }
        }
        return importedSpots;
    }

    private ArrayList<String> importPeople(){

    }

    private ArrayList<String> getRemainder(String[] line){
        ArrayList<String> result = new ArrayList<>();

        for(int i = 5; i < line.length; i++){
            result.add(line[i]);
        }

        return result;
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


class Park extends Spot{
    protected String subType;

    public Park(Coordinates place, int subs, String subType) {
        super(place, subs, "Park");
        this.subType = subType;
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
    private double cost;

    public Exposition(Coordinates place, int subs, String art, double cost) {
        super(place, subs, "Exposition");
        this.art = art;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Exposition{" +
                "art='" + art + '\'' +
                ", cost=" + cost +
                '}';
    }
}

class Bar extends Spot{
    private int capacity, percGuest;
    private double minConsump;
    private ArrayList<Person> guest_list;

    public Bar(Coordinates place, int subs, int capacity, double minConsump, int percGuest, ArrayList<Person> guest_list) {
        super(place, subs, "Bar");
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



//sort spots