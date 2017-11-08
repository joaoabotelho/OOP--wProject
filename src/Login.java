import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login extends Main{
    private JFrame frame;
    private JPanel warningP, titleP, dataP, userP, passP, buttonP;
    private JTextField username;
    private JPasswordField password;
    private JButton login, register;

    public Login(int state){
        GUI_Management manage = new GUI_Management();
        createPanels();

        // Title Panel
        manage.create_title("Login", titleP);

        //Data Panel
        username = manage.createLabelTextFiel(userP, "Username:");
        password = manage.create_pass(passP);

        manage.add_panel(dataP, userP, passP);

        // Button Panel
        login = new JButton("Login");
        register = new JButton("Register");
        manage.add_panel(buttonP, login, register);

        //Warning Panel
        if(state != 0) {
            setLoginError();
        }

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonAction(frame);}
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerButtonAction(frame);
            }
        });

        manage.add_frame(frame, titleP, dataP, buttonP, warningP);
        manage.defaultWindow(frame, 400, 400);
    }

    private void setLoginError(){
        JLabel warning = new JLabel("Account not found. Please try again.");

        warning.setFont(new Font("Arial", Font.BOLD, 10));
        warning.setHorizontalAlignment(SwingConstants.CENTER);
        warningP.add(warning);
    }

    private void registerButtonAction(JFrame frame) {
        frame.dispose();
        new Register();
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(4,1));
        titleP = new JPanel(new BorderLayout());
        dataP =  new JPanel(new GridLayout(2,1));
        buttonP = new JPanel(new FlowLayout());
        passP = new JPanel(new FlowLayout());
        userP = new JPanel(new FlowLayout());
        warningP = new JPanel(new FlowLayout());
    }

    private void loginButtonAction(JFrame frame){
        String usr, pass;

        usr = username.getText();
        pass = String.valueOf(password.getPassword());

        if(searchUser(usr, pass) == true){

        } else {
            frame.dispose();
            new Login(1);
        }
    }

    private boolean searchUser(String username, String password){
        int arraysize = event.people.size();
        String temp_username, temp_password;
        boolean account_state = false;

        // MUST DO Binary Search.
        for(int i = 0; i < arraysize; i++){
            temp_username = event.people.get(i).getUsername();
            temp_password = event.people.get(i).getPassword();

            if(temp_username == username && temp_password == password){
                account_state = true;
            }
        }

        return account_state;
    }
}
