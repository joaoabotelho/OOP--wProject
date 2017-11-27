import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class Menu extends Event {
    private JFrame frame;
    private JScrollPane scroll;
    private JLabel warningL, revenueL;
    private JPanel warningP, firstP, titleP , all;
    private int indexUser;

    Menu(int indexUser) {
        int subs;
        this.indexUser = indexUser;
        createPanels();

        // Title Panel
        revenueL = new JLabel("Revenue: " + super.d.revenue);
        manage.createTitle("Locations", titleP);
        manage.addPanel(firstP, titleP, revenueL);

        // Locations Panel
        for (Spot s : super.d.spots) {
            basicSpotInfo(all, s);
        }

        // Warning Panel
        subs = super.d.people.get(indexUser).chosenSpots.size();
        warningL = manage.setWarning(frame, warningP, "You have subscribed to " + subs +" locations.");


        manage.addFrame(frame, firstP, scroll, warningP);
        manage.defaultWindow(frame, 500,1000, super.d);
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        titleP = new JPanel(new BorderLayout());
        firstP = new JPanel(new GridLayout(1,2));
        all = new JPanel(new GridLayout(0,1));
        scroll = new JScrollPane(all);
        warningP = new JPanel(new FlowLayout());
    }

    private void updateScrollPanel(){
        all.removeAll();

        // Locations Panel
        for (Spot s : super.d.spots) {
            basicSpotInfo(all, s);
        }

        frame.revalidate();
        frame.repaint();
    }

    private void basicSpotInfo(JPanel panel, Spot a) {
        JPanel panels = new JPanel(new GridLayout(3, 1));
        JPanel line1 = new JPanel(new FlowLayout());
        JPanel line2 = new JPanel(new FlowLayout());
        JPanel line3 = new JPanel(new BorderLayout());
        JLabel subL = new JLabel();
        JButton info = new JButton("More Info");
        JButton add = new JButton();
        JLabel type = new JLabel(a.getType());
        String coord = a.getPlace().toString();
        String instBar;

        instBar = a.stringCapacity(); // "" if not a Bar
        subL.setText("Num of subscribers" + instBar + ": " + Integer.toString(a.getSubs()));

        type.setFont(new Font("Arial", Font.BOLD, 15));
        ((FlowLayout) line1.getLayout()).setHgap(50);
        ((FlowLayout) line2.getLayout()).setHgap(50);

        System.out.println("lalala");
        for (Person z : super.d.people){
            System.out.println(z);
            System.out.println("lalala");
        }
        super.d.people.get(indexUser);
        System.out.println("lalala");
        if(super.d.people.get(indexUser).chosenSpots.contains(a)){
            System.out.println("lalala");
            add.setText("Unsubscribed");
        } else {
            add.setText("Subscribe to");
        }
        System.out.println("lalala");

        info.addActionListener(e -> new MoreInfo(a, indexUser));

        add.addActionListener(e -> {
            int subs = super.d.people.get(indexUser).chosenSpots.size();
            String extraWarning = "";

            if(Objects.equals(add.getText(), "Subscribe to")) {
                if(subs >= 5){
                    extraWarning = "You can only subscribe to 5 locations! ";
                } else if(a instanceof Bar && ((Bar) a).getCapacity() == a.getSubs()){
                    extraWarning = "This Bar is full! ";
                } else {
                    super.d.people.get(indexUser).chosenSpots.add(a);
                    a.subs++;
                    add.setText("Unsubscribed");
                    if(a instanceof Bar){
                        ((Bar) a).getGuestList().add(super.d.people.get(indexUser));
                    }
                    super.d.revenue += a.getCost(super.d.people.get(indexUser));
                }
            } else {
                add.setText("Subscribe to");
                super.d.people.get(indexUser).chosenSpots.remove(a);
                a.subs--;
                if(a instanceof Bar){
                    ((Bar) a).getGuestList().remove(indexUser);
                }
                super.d.revenue -= a.getCost(super.d.people.get(indexUser));
            }

            subs = super.d.people.get(indexUser).chosenSpots.size();

            subL.setText("Num of subscribers" + instBar + ": " + Integer.toString(a.getSubs()));
            revenueL.setText("Revenue: " + super.d.revenue);
            warningP.remove(warningL);
            warningL = manage.setWarning(frame, warningP, extraWarning + "You have subscribed to " + subs + " locations.");
            sortSpots();
            updateScrollPanel();
            System.out.println(super.d.people.get(indexUser));
        });

        manage.addPanel(line1, type, subL);
        manage.addPanel(line2, new JLabel(coord), info);
        line3.add(add, BorderLayout.CENTER);

        manage.addPanel(panels, line1, line2, line3);
        panels.setBorder(BorderFactory.createRaisedBevelBorder());
        panel.add(panels);
    }
}

