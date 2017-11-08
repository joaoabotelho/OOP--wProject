import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Register extends Main{
    private JFrame frame;
    private JPanel titleP, userP, passP, nameP, profileP, postP, subPostP, buttonP, warningP;
    private JLabel subPostL, warningL;
    private JTextField username, name;
    private JPasswordField password;
    private JComboBox profile, post, subPost;
    private JButton back, finish;

    public Register(){
        String[] profiles = {"------","Bohemian", "Cultural", "Sporty", "Economic"};
        String[] posts = {"------", "Employee", "Teacher", "Student"};
        createPanels();

        // Title Panel
        manage.createTitle("Create account", titleP);

        username = manage.createLabelTextField(userP, "Username:");
        password = manage.createPass(passP);

        // Name Panel
        name = manage.createLabelTextField(nameP, "Name:");

        // Profile Panel
        profile = manage.createLabelComboBox(profileP, "Profile:", profiles);

        // Post Panel
        post = manage.createLabelComboBox(postP, "Your Post in DEI:", posts);
        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox post = (JComboBox) e.getSource();
                postBoxAction(post);
            }
        });

        // SubPost Panel
        subPostL = new JLabel("------");
        subPost = manage.createLabelComboBox(subPostP, subPostL, new String[]{"------"});

        // Button Panel
        back = new JButton("Back");
        finish = new JButton("Finish");
        manage.addPanel(buttonP, back, finish);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login();
            }
        });

        finish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finishButtonAction();
            }
        });

        // Warning Panel
        warningL = new JLabel("");
        warningP.add(warningL);

        manage.addFrame(frame, titleP, userP, passP, nameP, profileP, postP, subPostP, buttonP, warningP);
        manage.defaultWindow(frame,400, 450);
    }

    private void postBoxAction(JComboBox box){
        String selected = (String)box.getSelectedItem();
        String[] subPosts;
        String str;

        subPostP.remove(subPostL);
        subPostP.remove(subPost);
        switch (selected){
            case "Employee":
                subPosts = new String[] {"----------", "Part-time", "Full-time"};
                str = "Schedule:";
                break;
            case "Teacher":
                subPosts = new String[] {"----------", "Adjuvant", "Affiliated", "Professor"};
                str = "Type:";
                break;
            case "Student":
                subPosts = new String[]{"----------", "LEI", "MEI", "MSI", "LDM", "MDM", "PDCTI"};
                str = "Course:";
                break;
            default:
                subPosts = new String[]{"----------"};
                str = "------";
                break;
        }
        subPostL = new JLabel(str);
        subPost = manage.createLabelComboBox(subPostP, subPostL, subPosts);
        frame.revalidate();
        frame.repaint();
    }

    private void finishButtonAction(){
        String user = username.getText();
        String pass = String.valueOf(password.getPassword());
        String name = this.name.getText();
        String profile = (String)this.profile.getSelectedItem();
        String post = (String)this.post.getSelectedItem();
        String subPost = (String)this.subPost.getSelectedItem();

        // Confirm if every parm is filled in UI
        boolean userBol = user.equals("");
        boolean passBol = pass.equals("");
        boolean nameBol = name.equals("");
        boolean profileBol = profile.equals("------");
        boolean postBol = post.equals("------");
        boolean subPostBol = subPost.equals("------") || subPost.equals("----------");
        boolean paramEmpty = userBol || passBol || nameBol || profileBol || postBol || subPostBol;

        // Confirm if username doesnt exist
        // Confirm if name is in DEI txt File

        if(paramEmpty){
            warningP.remove(warningL);
            warningL = manage.setWarning(frame, warningL, warningP, "Some data is empty");
        } else {
            //final: Add to list of People
            frame.dispose();
            new Login();
        }
    }

    private void createPanels(){
        frame = new JFrame();
        frame.setLayout(new GridLayout(9, 1));
        titleP = new JPanel(new BorderLayout());
        userP = new JPanel(new FlowLayout());
        passP = new JPanel(new FlowLayout());
        nameP = new JPanel(new FlowLayout());
        profileP = new JPanel(new FlowLayout());
        postP = new JPanel(new FlowLayout());
        subPostP = new JPanel(new FlowLayout());
        warningP = new JPanel(new FlowLayout());
        buttonP = new JPanel(new FlowLayout());
        // manage.createFlowLayouts(titleP, userP, passP, nameP, profileP, postP, subPostP, buttonP); DOESNT WORK
    }
}
