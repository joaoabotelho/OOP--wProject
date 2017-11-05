import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel title_panel, data_panel, user_panel, pass_panel, button_panel;
    private JLabel title, username_label, password_label;
    private JTextField username;
    private JPasswordField password;
    private JButton login, register;

    public Login(){
        this.setLayout(new GridLayout(3,1));
        title_panel = new JPanel(new BorderLayout());
        data_panel = new JPanel(new GridLayout(2,1));
        button_panel = new JPanel(new FlowLayout());
        pass_panel = new JPanel(new FlowLayout());
        user_panel = new JPanel(new FlowLayout());

        // Title Panel
        title = new JLabel("DEI Event");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title_panel.add(title, BorderLayout.CENTER);

        //Data Panel
        username_label = new JLabel("Username:");
        password_label = new JLabel("Password:");
        username = new JTextField();
        password = new JPasswordField();

        username_label.setFont(new Font("Arial", Font.PLAIN, 15));
        password_label.setFont(new Font("Arial", Font.PLAIN, 15));

        username.setPreferredSize(new Dimension(200,24));
        password.setPreferredSize(new Dimension(200,24));
        user_panel.add(username_label);
        user_panel.add(username);
        pass_panel.add(password_label);
        pass_panel.add(password);
        data_panel.add(user_panel);
        data_panel.add(pass_panel);

        // Button Panel
        login = new JButton("Login");
        register = new JButton("Register");
        button_panel.add(login);
        button_panel.add(register);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usr, pass;

                usr = username.getText();
                pass = String.valueOf(password.getPassword());


                System.out.println(usr + " lalalalla " + pass);
            }
        });

        this.add(title_panel);
        this.add(data_panel);
        this.add(button_panel);
    }
}
