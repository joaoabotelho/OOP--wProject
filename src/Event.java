import java.io.*;
import java.util.ArrayList;

class Event {
    private static ArrayList<Spot> spots;
    private static ArrayList<Person> people;
    private static int min_revenue;

    public Event() {
        this.spots = importSpots();
        this.people = importPeople();
    }

    public static ArrayList<Spot> getSpots() {
        return spots;
    }

    public static ArrayList<Person> getPeople() {
        return people;
    }

    private ArrayList<Spot> importSpots() {
        String fileName = "./spotsInfo.txt";
        String line;
        String[] sLine;
        ArrayList<Spot> spots = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(" ");
                    Coordinates c = new Coordinates(Integer.parseInt(sLine[1]), Integer.parseInt(sLine[2]), Integer.parseInt(sLine[3]));
                    switch (sLine[0]) {
                        case "Garden":
                            Garden g = new Garden(c, Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5]));
                            spots.add(g);
                            break;

                        case "Sports_Area":
                            ArrayList<String> sports = new ArrayList<>();
                            for (int j = 5; j < sLine.length; j++) {
                                sports.add(sLine[j]);
                            }
                            Sports_Area sa = new Sports_Area(c, Integer.parseInt(sLine[4]), sports);
                            spots.add(sa);
                            break;

                        case "Exposition":
                            Exposition e = new Exposition(c, Integer.parseInt(sLine[4]), sLine[5], Integer.parseInt(sLine[6]));
                            spots.add(e);
                            break;

                        case "Bar":
                            ArrayList<Person> guestList = new ArrayList<>();
                            Bar b = new Bar(c, Integer.parseInt(sLine[4]), Integer.parseInt(sLine[5]), Integer.parseInt(sLine[6]), Integer.parseInt(sLine[7]), guestList);
                            spots.add(b);
                    }
                }
            }
            catch (IOException ex) {
                System.out.println("Unable to read " + fileName);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open " + fileName);
        }

        return spots;
    }

    private static ArrayList<Person> importPeople(){
        ArrayList<Person> people = new ArrayList<>();
        String line;
        String[] sLine;
        String fileName = "./peopleInfo.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);

            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(" ");
                    ArrayList<Spot> spots = new ArrayList<>();

                    switch(sLine[0]){
                        case "Teacher":
                            Teacher t = new Teacher(sLine[1], sLine[2], sLine[3], sLine[4], sLine[5], spots);
                            people.add(t);
                            break;

                        case "Employee":
                            Employee e = new Employee(sLine[1], sLine[2], sLine[3], sLine[4], sLine[5], spots);
                            people.add(e);
                            break;

                        case "Student":
                            Student s = new Student(sLine[1], sLine[2], sLine[3], sLine[4], sLine[5], spots);
                            people.add(s);
                    }
                }
            }
            catch(IOException ex){
                System.out.println("Unable to read " + fileName);
            }

        }
        catch(FileNotFoundException ex){
            System.out.println("Unable to open " + fileName);
        }

        return people;
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

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", post='" + post + '\'' +
                ", subPost='" + subPost + '\'' +
                ", chosenSpots=" + chosenSpots +
                '}';
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
    private int cost;

    @Override
    public String toString() {
        return "Exposition{" +
                "art='" + art + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Exposition(Coordinates place, int subs, String art, int cost) {
        super(place, subs, "Exposition");
        this.art = art;
        this.cost = cost;
    }
}

class Bar extends Spot{
    private int capacity, minConsump, percGuest;
    private ArrayList<Person> guest_list;

    public Bar(Coordinates place, int subs, int capacity, int minConsump, int percGuest, ArrayList<Person> guest_list) {
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