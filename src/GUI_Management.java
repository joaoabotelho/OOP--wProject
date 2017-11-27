import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GUI_Management {
    void addPanel(JPanel panel, Component... comps) {
        for (Component comp : comps) {
            panel.add(comp);
        }
    }

    void addFrame(JFrame frame, Component... comps) {
        for (Component comp : comps) {
            frame.add(comp);
        }
    }

    void createTitle(String title, JPanel titleP) {
        JLabel titleL = new JLabel(title);

        titleL.setHorizontalAlignment(SwingConstants.CENTER);
        titleL.setFont(new Font("Arial", Font.BOLD, 24));
        titleP.add(titleL, BorderLayout.CENTER);
    }

    JTextField createLabelTextField(JPanel panel, String str) {
        JLabel label = new JLabel(str, SwingConstants.RIGHT);
        JTextField tField = new JTextField();

        label.setFont(new Font("Arial", Font.PLAIN, 15));
        tField.setPreferredSize(new Dimension(200, 24));

        addPanel(panel, label, tField);
        return tField;
    }

    void defaultWindow(JFrame frame, int width, int height, Data data){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                ObjectFiles objFile = new ObjectFiles();
                objFile.writeObject(data);
            }
        });
        frame.setTitle("DEI Event");
        frame.setSize(width,height);
        frame.setVisible(true);
    }

    JLabel setWarning(JFrame frame, JPanel warningP, String str) {
        JLabel warningL;

        warningL = new JLabel(str);
        warningL.setFont(new Font("Arial", Font.BOLD, 10));
        warningL.setHorizontalAlignment(SwingConstants.CENTER);
        warningP.add(warningL);
        frame.revalidate();
        frame.repaint();

        return warningL;
    }

    JPasswordField createPass(JPanel pass) {
        JLabel passL = new JLabel("Password:");
        JPasswordField password = new JPasswordField();

        passL.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setPreferredSize(new Dimension(200, 24));

        addPanel(pass, passL, password);

        return password;
    }
}
