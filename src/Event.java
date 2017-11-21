import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Event{
    public static ArrayList<Spot> spots;
    public static ArrayList<Person> people;
    public static ArrayList<Person> deiCommunity;
    public static int min_revenue;

    public Event() {
        this.spots = importSpots();
        this.people = importPeople();
        this.deiCommunity = importDEICommunity();
    }

    private ArrayList<Spot> importSpots() {
        String fileName = "/Users/tiagomartins/uni/OOP-Project/src/spotsInfo.txt";
        String line;
        String[] sLine;
        ArrayList<Spot> spots = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(";");
                    Coordinates c = new Coordinates(Double.parseDouble(sLine[1]), Double.parseDouble(sLine[2]));
                    switch (sLine[0]) {
                        case "Garden":
                            Garden g = new Garden(c, Integer.parseInt(sLine[3]), Integer.parseInt(sLine[4]));
                            spots.add(g);
                            break;

                        case "SportsArea":
                            ArrayList<String> sports = new ArrayList<>();
                            for(int j = 4; j < sLine.length; j++) {
                                sports.add(sLine[j]);
                            }
                            SportsArea sa = new SportsArea(c, Integer.parseInt(sLine[3]), sports);
                            spots.add(sa);
                            break;

                        case "Exposition":
                            Exposition e = new Exposition(c, Integer.parseInt(sLine[3]), sLine[4], Double.parseDouble(sLine[5]));
                            spots.add(e);
                            break;

                        case "Bar":
                            ArrayList<Person> guestList = new ArrayList<>();
                            Bar b = new Bar(c, Integer.parseInt(sLine[3]), sLine[4], Integer.parseInt(sLine[5]), Integer.parseInt(sLine[6]), Integer.parseInt(sLine[7]), guestList);
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
        String fileName = "/Users/tiagomartins/uni/OOP-Project/src/peopleInfo.txt";

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);

            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(";");
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

    private ArrayList<Person> importDEICommunity(){
        String fileName = "/Users/tiagomartins/uni/OOP-Project/src/deicommunity.txt";
        ArrayList<Person> deiCommunity = new ArrayList<>();
        String line;
        String[] sLine;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            try {
                while ((line = bufferReader.readLine()) != null) {
                    sLine = line.split(";");
                    System.out.println(Arrays.toString(sLine));
                    ArrayList<Spot> spots = new ArrayList<>();

                    switch(sLine[0]){
                        case "Teacher":
                            Teacher t = new Teacher("", "", sLine[1], sLine[2], sLine[3], spots);
                            people.add(t);
                            break;

                        case "Employee":
                            Employee e = new Employee("", "", sLine[1], sLine[2], sLine[3], spots);
                            people.add(e);
                            break;

                        case "Student":
                            Student s = new Student("", "", sLine[1], sLine[2], sLine[3], spots);
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
        return  deiCommunity;
    }

    public boolean checkUsernameAndName(String username, String name){
        for(Person p : this.people) {
            if (username.equals(p.getPassword()) || name.equals(p.getName())) {
                return false;
            }
        }
        for(Person p : this.deiCommunity){
            if(name.equals(p.getName())){
                return true;
            }

        }
        return true;
    }

    public boolean checkLoginInfo(String username, String password) {
        for(Person p : this.people) {
            if(username.equals(p.getUsername()) && username.equals(p.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void sortSpots() {
        Collections.sort(this.spots, new Comparator<Spot>() {
            @Override
            public int compare(Spot spot_1, Spot spot_2) {
                return Integer.compare(spot_1.getSubs(), spot_2.getSubs());
            }
        });
    }

    public void addPerson(Person p) {
        this.people.add(p);
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
    protected String password;
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

    public String getName() {
        return name;
    }

    public ArrayList<Spot> getChosenSpots() {
        return chosenSpots;
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