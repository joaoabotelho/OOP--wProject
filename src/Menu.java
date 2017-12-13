import javax.swing.*;
import java.awt.*;
import java.util.Objects;

class Menu extends GUI_Management{
    private JScrollPane scroll;
    private JLabel revenueL;
    private JPanel firstP, titleP , lastP, all;
    private int indexUser;

    Menu(Event event, int indexUser) {
        int subs;
        JButton logout = new JButton("Logout");
        this.indexUser = indexUser;
        super.event = event;
        createPanels();

        // Title Panel
        revenueL = new JLabel("Revenue: " + super.event.d.revenue);
        createTitle("Locations", titleP);
        addPanel(firstP, titleP, revenueL);

        // Locations Panel
        for (Spot s : super.event.d.spots) {
            basicSpotInfo(all, s);
        }

        // Warning Panel
        subs = super.event.d.people.get(indexUser).chosenSpots.size();
        warningL = setWarning(frame, warningP, "You have subscribed to " + subs +" locations.");

        logout.addActionListener(e -> {
            frame.dispose();
            new Login(event);
        });

        lastP.add(logout, BorderLayout.CENTER);
        addFrame(frame, firstP, scroll, warningP, lastP);
        defaultWindow(frame, 500,1000, super.event.d);
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        titleP = new JPanel(new BorderLayout());
        firstP = new JPanel(new GridLayout(1,2));
        warningP = new JPanel(new FlowLayout());
        lastP = new JPanel(new BorderLayout());
        all = new JPanel(new GridLayout(0,1));
        scroll = new JScrollPane(all);
    }

    private void updateScrollPanel(){
        all.removeAll();

        // Locations Panel
        for (Spot s : super.event.d.spots) {
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

        super.event.d.people.get(indexUser);
        if(super.event.d.people.get(indexUser).chosenSpots.contains(a)){
            add.setText("Unsubscribed");
        } else {
            add.setText("Subscribe to");
        }

        info.addActionListener(e -> new MoreInfo(super.event, a, indexUser));

        add.addActionListener(e -> {
            int subs = super.event.d.people.get(indexUser).chosenSpots.size();
            String extraWarning = "";

            if(Objects.equals(add.getText(), "Subscribe to")) {
                if(subs >= 5){
                    extraWarning = "You can only subscribe to 5 locations! ";
                } else if(a instanceof Bar && ((Bar) a).getCapacity() == a.getSubs()){
                    extraWarning = "This Bar is full! ";
                } else {
                    super.event.d.people.get(indexUser).chosenSpots.add(a);
                    a.subs++;
                    add.setText("Unsubscribed");
                    if(a instanceof Bar){
                        ((Bar) a).getGuestList().add(super.event.d.people.get(indexUser));
                    }
                    super.event.d.revenue += a.getCost(super.event.d.people.get(indexUser));
                }
            } else {
                add.setText("Subscribe to");
                super.event.d.people.get(indexUser).chosenSpots.remove(a);
                a.subs--;
                if(a instanceof Bar){
                    ((Bar) a).getGuestList().remove(indexUser);
                }
                super.event.d.revenue -= a.getCost(super.event.d.people.get(indexUser));
            }

            subs = super.event.d.people.get(indexUser).chosenSpots.size();

            subL.setText("Num of subscribers" + instBar + ": " + Integer.toString(a.getSubs()));
            revenueL.setText("Revenue: " + super.event.d.revenue);
            warningP.remove(warningL);
            warningL = setWarning(frame, warningP, extraWarning + "You have subscribed to " + subs + " locations.");
            super.event.sortSpots();
            updateScrollPanel();
            System.out.println(super.event.d.people.get(indexUser));
        });

        addPanel(line1, type, subL);
        addPanel(line2, new JLabel(coord), info);
        line3.add(add, BorderLayout.CENTER);

        addPanel(panels, line1, line2, line3);
        panels.setBorder(BorderFactory.createRaisedBevelBorder());
        panel.add(panels);
    }
}

