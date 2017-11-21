import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Menu extends Main {
    private JFrame frame;
    private JScrollPane scroll;
    private JLabel warningL;
    private JPanel warningP, titleP, all;
    private Person user;

    public Menu(Person user) {
        String coord;
        Spot pot;
        int i;
        this.user = user;
        createPanels();

        // Title Panel
        manage.createTitle("Locations", titleP);

        // Locations Panel
        for (i = 0; i < event.spots.size(); i++) {
            pot = event.spots.get(i);
            basicSpotInfo(all, pot);
        }

        // Warning Panel
        int subs = this.user.getChosenSpots().size();
        warningL = manage.setWarning(frame, warningL, warningP, "You have subscibed to " + subs +" locations.");

        manage.addFrame(frame, titleP, scroll, warningP);
        manage.defaultWindow(frame, 500,1000);
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        titleP = new JPanel(new BorderLayout());
        all = new JPanel(new GridLayout(0,1));
        scroll = new JScrollPane(all);
        warningP = new JPanel(new FlowLayout());
    }

    protected void basicSpotInfo(JPanel panel, Spot a){
            JPanel panels = new JPanel(new GridLayout(3, 1));
            JPanel line1 = new JPanel(new FlowLayout());
            JPanel line2 = new JPanel(new FlowLayout());
            JPanel line3 = new JPanel(new BorderLayout());
            JLabel subL = new JLabel();
            JButton info = new JButton("More Info");
            JButton add = new JButton();
            JLabel type = new JLabel(a.getType());
            String coord = a.getPlace().toString();
            String instBar = "";

            if(a instanceof Bar){
                instBar = " (Max: " + ((Bar) a).getCapacity() + ")";
            }
            subL.setText("Num of subscribers" + instBar + ": " + Integer.toString(a.getSubs()));

            type.setFont(new Font("Arial", Font.BOLD, 15));
            ((FlowLayout)line1.getLayout()).setHgap(50);
            ((FlowLayout)line2.getLayout()).setHgap(50);

            if(this.user.getChosenSpots().contains(a)){
                add.setText("Unsubscribed");
            } else {
                add.setText("Subscribe to");
            }

            info.addActionListener(e -> new MoreInfo(a,user));

        String finalInstBar = instBar;
        add.addActionListener(e -> {
                int subs = this.user.chosenSpots.size();
                String extraWarning = "";
                if(add.getText() == "Subscribe to") {
                    if(subs >= 5){
                        extraWarning = "You can only subscribe to 5 locations! ";
                    } else if(a instanceof Bar && ((Bar) a).getCapacity() == a.getSubs()){
                        extraWarning = "This Bar is full! ";
                    } else {
                        this.user.getChosenSpots().add(a);
                        a.subs++;
                        add.setText("Unsubscribed");
                        if(a instanceof Bar){
                            ((Bar) a).getGuestList().add(this.user);
                        }
                    }
                } else {
                    add.setText("Subscribe to");
                    this.user.getChosenSpots().remove(a);
                    a.subs--;
                    if(a instanceof Bar){
                        ((Bar) a).getGuestList().remove(this.user);
                    }
                }

                subs = this.user.chosenSpots.size();

                subL.setText("Num of subscribres" + finalInstBar + ": " + Integer.toString(a.getSubs()));
                warningP.remove(warningL);
                warningL = manage.setWarning(frame, warningL, warningP, extraWarning + "You have subscibed to " + subs + " locations.");
            });

            manage.addPanel(line1, type, subL);
            manage.addPanel(line2, new JLabel(coord), info);
            line3.add(add, BorderLayout.CENTER);

            manage.addPanel(panels, line1, line2, line3);
            panels.setBorder(BorderFactory.createRaisedBevelBorder());
            panel.add(panels);
    }
}

