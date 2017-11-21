import javax.swing.*;
import java.awt.*;

class MoreInfo extends Main{
    private JFrame frame;

    public MoreInfo(Spot a, Person user){
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

        a.InfoUI(frame, user);

        frame.add(exit);
        manage.defaultWindow(frame, 450,400);
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(0,2));
    }
}
