import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

class MoreInfo extends Main{
    private Spot a;
    private JFrame frame;
    private JLabel subL, type, coord;
    private JButton exit;
    private Person user;

    public MoreInfo(Spot a, Person user){
        this.a = a;
        this.user = user;
        createPanels();
        type = new JLabel(a.getType());
        coord = new JLabel(a.getPlace().toString());
        subL = new JLabel();
        exit = new JButton("Exit");
        String instBar = "";

            if(a instanceof Bar){
                instBar = " (Max: " + ((Bar) a).getCapacity() + ")";
            }
            subL.setText("Num of subscribers" + instBar + ": " + Integer.toString(a.getSubs()));

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        type.setFont(new Font("Arial", Font.BOLD, 15));
        manage.addFrame(frame, type, subL, coord);

        if(a instanceof Garden){
            GardenInfoUI(a);
        } else if(a instanceof SportsArea){
            SpotsAreaInfoUI(a);
        } else if(a instanceof Exposition){
            ExpostionInfoUI(a);
        } else if(a instanceof Bar){
            BarInfoUI(a);
        }

        frame.add(exit);
        manage.defaultWindow(frame, 450,400);
    }

    private void GardenInfoUI(Spot a){
        Garden g = (Garden) a;
        JLabel area = new JLabel("Area(m2): " + Integer.toString(g.getArea()));
        frame.add(area);
    }

    private void SpotsAreaInfoUI(Spot a) {
        SportsArea s = (SportsArea) a;
        JPanel f = new JPanel(new GridLayout(2,1));
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JScrollPane sports = new JScrollPane(panel);
        JLabel label = new JLabel("Sports");

        label.setFont(new Font("Arial", Font.BOLD, 15));
        f.add(label);
        for (int i = 0; i < s.getSports().size(); i++){
            label = new JLabel(s.getSports().get(i));
            label.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(label);
        }

        f.add(sports);
        frame.add(f);
    }

    private void ExpostionInfoUI(Spot a){
        Exposition e = (Exposition) a;
        double cost;
        if(this.user instanceof Student){
            cost = e.getCost() * 10/100;
        } else {
            cost = e.getCost();
        }
        JLabel costL = new JLabel("Cost: " + cost + "€");
        frame.add(costL);
    }

    private void BarInfoUI(Spot a){
        Bar b = (Bar) a;
        JLabel minConsump = new JLabel("Minimum Consumption: " + b.getMinConsump() + "€");
        JPanel f = new JPanel(new GridLayout(2,1));
        JPanel panel = new JPanel(new GridLayout(0, 1));
        JScrollPane guest = new JScrollPane(panel);
        JLabel label = new JLabel("Guest List (Max: " + b.getPercGuest() * b.getCapacity() / 100 + ")");
        String str;
        ArrayList<Person> peeps = b.getGuestList();

        label.setFont(new Font("Arial", Font.BOLD, 15));
        f.add(label);
        for (int i = 0; i < peeps.size(); i++){
            if(peeps.get(i) instanceof Student) {
                str = peeps.get(i).name + ", " + peeps.get(i).profile + " and " + peeps.get(i).subPost;
            } else {
                str = peeps.get(i).name + " and " + peeps.get(i).profile;
            }
            label = new JLabel(str);
            label.setFont(new Font("Arial", Font.PLAIN, 15));
            panel.add(label);
        }

        f.add(guest);
        manage.addFrame(frame, minConsump, f);
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(0,2));
    }
}
