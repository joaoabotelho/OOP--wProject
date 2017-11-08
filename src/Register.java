import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Register extends Main{
    private JFrame frame;
    private JPanel titleP, userP, passP, nameP, profileP, postP,  subPostP, buttonP;
    private JLabel profileL, postL, subPostL;
    private JTextField username, name;
    private JPasswordField password;
    private JComboBox profile, post, subPost;
    private JButton back, finish;

    public Register(){
        GUI_Management manage = new GUI_Management();
        createPanels();

        // Title Panel
        manage.create_title("Create account", titleP);

        // User Panel
        username = manage.createLabelTextFiel(userP, "Username:");
        password = manage.create_pass(passP);

        // Name Panel
        name = manage.createLabelTextFiel(nameP, "Name:");

        // Profiel Panel


        manage.add_frame(frame, titleP, userP, passP, nameP, profileP, postP, subPostP, buttonP);
        manage.defaultWindow(frame,400, 600);
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(8,1));
        titleP = new JPanel(new FlowLayout());
        userP = new JPanel(new FlowLayout());
        passP = new JPanel(new FlowLayout());
        nameP = new JPanel(new FlowLayout());
        profileP = new JPanel(new FlowLayout());
        postP = new JPanel(new FlowLayout());
        subPostP = new JPanel(new FlowLayout());
        buttonP = new JPanel(new BorderLayout());
    }
}
