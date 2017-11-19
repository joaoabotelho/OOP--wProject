import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    protected static Event event;
    protected GUI_Management manage;

    public Main() {
        this.manage = new GUI_Management();
    }

    public static void main(String[] args) {
        Event e = new Event();
        System.out.println(Arrays.toString(e.getSpots().toArray()));
        System.out.println(Arrays.toString(e.getPeople().toArray()));
        //new Login();
    }
}