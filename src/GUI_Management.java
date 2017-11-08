import javax.swing.*;
import java.awt.*;

class GUI_Management {

    public void addPanel(JPanel panel, Component... comps) {
        for (Component comp : comps) {
            panel.add(comp);
        }
    }

    public void addFrame(JFrame frame, Component... comps) {
        for (Component comp : comps) {
            frame.add(comp);
        }
    }

    public void createTitle(String title, JPanel titleP){
        JLabel titleL = new JLabel(title);

        titleL.setHorizontalAlignment(SwingConstants.CENTER);
        titleL.setFont(new Font("Arial", Font.BOLD, 24));
        titleP.add(titleL, BorderLayout.CENTER);
    }

    public JTextField createLabelTextField(JPanel panel, String str){
        JLabel label = new JLabel(str, SwingConstants.RIGHT);
        JTextField tField= new JTextField();

        label.setFont(new Font("Arial", Font.PLAIN, 15));
        tField.setPreferredSize(new Dimension(200,24));

        addPanel(panel, label, tField);
        return tField;
    }

    public JComboBox createLabelComboBox(JPanel panel, String str, String[] comboStr){
        JLabel label = new JLabel(str);
        JComboBox comboBox = new JComboBox(comboStr);

        label.setFont(new Font("Arial", Font.PLAIN, 15));
        addPanel(panel, label, comboBox);

        return comboBox;
    }

    public JComboBox createLabelComboBox(JPanel panel, JLabel label, String[] comboStr){
        JComboBox comboBox = new JComboBox(comboStr);

        label.setFont(new Font("Arial", Font.PLAIN, 15));
        addPanel(panel, label, comboBox);

        return comboBox;
    }

    public void createFlowLayouts(JPanel... panels){
        for(JPanel panel : panels){
            panel =  new JPanel(new FlowLayout());
        }
    }

    public JPasswordField createPass(JPanel pass){
        JLabel passL = new JLabel("Password:");
        JPasswordField password = new JPasswordField();

        passL.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setPreferredSize(new Dimension(200,24));

        addPanel(pass, passL, password);

        return password;
    }

    public void defaultWindow(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("DEI Event");
        frame.setSize(width,height);
        frame.setVisible(true);
    }
}
