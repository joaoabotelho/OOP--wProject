import java.util.ArrayList;
import java.io.IOException;

public class Main {
    protected static Event event;
    protected GUI_Management manage;

    public Main(){
        this.manage = new GUI_Management();
    }

    public static void main(String[] args) {
        ArrayList<Person> people; // use arraylists???
        ArrayList<Spot> spots;
        Data a = new Data();
      
        try {
            a.importUsersData("/Users/tiagomartins/github/OOP-Project/src/usersInfo.txt");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        spots = new ArrayList<Spot>();
        people = new ArrayList<Person>();
        event = new Event(spots, people);
        new Login();
   }