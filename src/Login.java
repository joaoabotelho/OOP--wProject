import javax.swing.*;
import java.awt.*;

class Login extends Event{
    private JFrame frame;
    private JLabel warningL;
    private JPanel warningP, titleP, dataP, userP, passP, buttonP;
    private JTextField username;
    private JPasswordField password;
    private JButton login, register;

    public Login(){
        super();
        createPanels();

        // Title Panel
        manage.createTitle("Login", titleP);

        //Data Panel
        username = manage.createLabelTextField(userP, "Username:");
        password = manage.createPass(passP);

        manage.addPanel(dataP, userP, passP);

        // Button Panel
        login = new JButton("Login");
        register = new JButton("Register");
        manage.addPanel(buttonP, login, register);

        // Warning
        warningL = new JLabel("");
        warningP.add(warningL);

        login.addActionListener(e -> loginButtonAction());

        register.addActionListener(e -> registerButtonAction());

        manage.addFrame(frame, titleP, dataP, buttonP, warningP);
        manage.defaultWindow(frame, 400, 250, super.d);
    }

    private void registerButtonAction() {
        frame.dispose();
        new Register();
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(4,1));
        titleP = new JPanel(new BorderLayout());
        dataP =  new JPanel(new GridLayout(2,1));
        userP = new JPanel(new FlowLayout());
        buttonP = new JPanel(new FlowLayout());
        passP = new JPanel(new FlowLayout());
        warningP = new JPanel(new FlowLayout());
    }

    private void loginButtonAction(){
        String usr;
        String pass;

        usr = username.getText();
        pass = String.valueOf(password.getPassword());

        int indexPerson = checkLoginInfo(usr, pass);
        if(indexPerson != -1){
            frame.dispose();
            new Menu(indexPerson);
        } else {
            warningP.remove(warningL);
            warningL = manage.setWarning(frame, warningP, "Account not found. Please try again.");
        }
    }
}
