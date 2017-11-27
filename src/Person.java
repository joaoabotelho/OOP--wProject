import java.io.Serializable;
import java.util.ArrayList;

class Person implements Serializable {
    private String username;
    String name, profile;
    String subPost;
    private String post;
    private String password;
    ArrayList<Spot> chosenSpots;

    Person(String username, String password, String name, String profile, String post, String subPost, ArrayList<Spot> chosenSpots) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.profile = profile;
        this.post = post;
        this.subPost = subPost;
        this.chosenSpots = chosenSpots;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", subPost='" + subPost + '\'' +
                ", post='" + post + '\'' +
                ", password='" + password + '\'' +
                ", chosenSpots=" + chosenSpots +
                '}';
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String guestPresent(){
        return name + " and " + profile;
    }

    public Double expoCost(Double full){
        return full;
    }

    String getName() {
        return name;
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

    @Override
    public String guestPresent(){
        return name + ", " + profile + " and " + subPost;
    }

    @Override
    public Double expoCost(Double full){
        return full * 90 / 100;
    }
}

