import javax.swing.*;
import java.awt.*;

class MoreInfo extends GUI_Management{

    MoreInfo(Event event, Spot a, int indexUser){
        createPanels();
        JLabel type = new JLabel(a.getType());
        JLabel coord = new JLabel(a.getPlace().toString());
        JLabel subL = new JLabel();
        JButton exit = new JButton("Exit");
        String instBar;
        super.event = event;

        instBar = a.stringCapacity();
        subL.setText("Num of subscribers" + instBar + ": " + Integer.toString(a.getSubs()));

        exit.addActionListener(e -> frame.dispose());

        type.setFont(new Font("Arial", Font.BOLD, 15));
        addFrame(frame, type, subL, coord);

        a.InfoUI(frame, super.event.d.people.get(indexUser));

        frame.add(exit);
        defaultWindow(frame, 450,400, super.event.d);
    }

    /**
     * Creates panel to display "more info"
     */
    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(0,2));
    }
}
