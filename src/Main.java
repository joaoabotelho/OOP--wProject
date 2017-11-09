import java.util.ArrayList;
import java.io.IOException;

public class Main {
    protected static Event event;
    protected GUI_Management manage;

    public Main() {
        this.manage = new GUI_Management();
    }

    public static void main(String[] args) {
        Event event = new Event();
        System.out.println(event.toString());
        //new Login();
    }
}