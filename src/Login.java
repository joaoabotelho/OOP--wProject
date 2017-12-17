import javax.swing.*; import java.awt.*;

class Login extends GUI_Management{
    private JPanel dataP;
    private JTextField username;
    private JPasswordField password;

    Login(Event event){
        createPanels();
        super.event = event;

        // Title Panel
        createTitle("Login", titleP);

        //Data Panel
        username = createLabelTextField(userP, "Username:");
        password = createPass(passP);

        addPanel(dataP, userP, passP);

        // Button Panel
        JButton login = new JButton("Login");
        JButton register = new JButton("Register");
        addPanel(buttonP, login, register);

        // Warning
        warningL = new JLabel("");
        warningP.add(warningL);

        login.addActionListener(e -> loginButtonAction());

        register.addActionListener(e -> registerButtonAction());

        addFrame(frame, titleP, dataP, buttonP, warningP);
        defaultWindow(frame, 400, 250, super.event.d);
    }
/**
     * Action when register button is pressed
     */
    private void registerButtonAction() {
        frame.dispose();
        new Register(super.event);
    }

    /**
     * Create frame with all login components
     */
    private void createPanels() {
        frame = new JFrame();
        frame.setLayout(new GridLayout(4,1));
        titleP = new JPanel(new BorderLayout());
        dataP =  new JPanel(new GridLayout(2,1));
        userP = new JPanel(new FlowLayout());
        buttonP = new JPanel(new FlowLayout());
        passP = new JPanel(new FlowLayout());
        warningP = new JPanel(new FlowLayout());
    }

    /**
     * Action when login button is pressed
     */
    private void loginButtonAction(){
        String usr;
        String pass;

        usr = username.getText();
        pass = String.valueOf(password.getPassword());

        int indexPerson = super.event.checkLoginInfo(usr, pass);
        if(indexPerson != -1){
            frame.dispose();
            new Menu(super.event, indexPerson);
        } else {
            warningP.remove(warningL);
            warningL = setWarning(frame, warningP, "Account not found. Please try again.");
        }
    }
}
