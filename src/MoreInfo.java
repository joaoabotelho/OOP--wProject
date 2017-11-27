import javax.swing.*;
import java.awt.*;

class MoreInfo extends Event{
    private JFrame frame;

    MoreInfo(Spot a, int indexUser){
        createPanels();
        JLabel type = new JLabel(a.getType());
        JLabel coord = new JLabel(a.getPlace().toString());
        JLabel subL = new JLabel();
        JButton exit = new JButton("Exit");
        String instBar;

        instBar = a.stringCapacity();
        subL.setText("Num of subscribers" + instBar + ": " + Integer.toString(a.getSubs()));

        exit.addActionListener(e -> frame.dispose());

        type.setFont(new Font("Arial", Font.BOLD, 15));
        manage.addFrame(frame, type, subL, coord);

        a.InfoUI(frame, super.d.people.get(indexUser));

        frame.add(exit);
        manage.defaultWindow(frame, 450,400, super.d);
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(0,2));
    }
}
