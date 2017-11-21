import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Login extends Main{
    private JFrame frame;
    private JLabel warningL;
    private JPanel warningP, titleP, dataP, userP, passP, buttonP;
    private JTextField username;
    private JPasswordField password;
    private JButton login, register;

    public Login(){
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

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonAction();}
        });

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerButtonAction();
            }
        });

        manage.addFrame(frame, titleP, dataP, buttonP, warningP);
        manage.defaultWindow(frame, 400, 250);
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
        //manage.createFlowLayouts(buttonP, passP, userP, warningP); DOESNT WORK
    }

    private void loginButtonAction(){
        String usr;
        char[] pass;

        usr = username.getText();
        pass = password.getPassword();

        if(searchUser(usr, pass) == true){

        } else {
            warningP.remove(warningL);
            warningL = manage.setWarning(frame, warningL, warningP, "Account not found. Please try again.");
        }
    }

    private boolean searchUser(String username, char[] password){
        int arraysize = event.people.size();
        String temp_username;
        char[] temp_password;
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
