import javax.swing.*;
import java.awt.*;

class GUI_Management {

    public void add_panel(JPanel panel, Component... comps) {
        for (Component comp : comps) {
            panel.add(comp);
        }
    }

    public void add_frame(JFrame frame, Component... comps) {
        for (Component comp : comps) {
            frame.add(comp);
        }
    }

    public void create_title(String title, JPanel title_p){
        JLabel title_l = new JLabel(title);
        title_l.setHorizontalAlignment(SwingConstants.CENTER);
        title_l.setFont(new Font("Arial", Font.BOLD, 24));
        title_p.add(title_l, BorderLayout.CENTER);
    }

    public JTextField createLabelTextFiel(JPanel panel, String str){
        JLabel label = new JLabel(str);
        JTextField tField= new JTextField();
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        tField.setPreferredSize(new Dimension(200,24));

        add_panel(panel, label, tField);

        return tField;
    }

    public JPasswordField create_pass(JPanel pass){
        JLabel pass_l = new JLabel("Password:");
        JPasswordField password = new JPasswordField();
        pass_l.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setPreferredSize(new Dimension(200,24));

        add_panel(pass, pass_l, password);

        return password;
    }

    public void defaultWindow(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DEI Event");
        frame.setSize(width,height);
        frame.setVisible(true);
    }
}
