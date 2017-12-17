import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GUI_Management {
    protected JFrame frame;
    protected JPanel titleP, userP, passP, buttonP, warningP;
    protected JLabel warningL;
    protected Event event;

    /**
     * Renders Panel with several components
     * @param panel Panel to be rendered
     * @param comps components to be displayed inside panel
     */
    void addPanel(JPanel panel, Component... comps) {
        for (Component comp : comps) {
            panel.add(comp);
        }
    }

    /**
     * Renders frame with several components
     * @param frame frame to be rendered
     * @param comps components to be displayed inside frame
     */
    void addFrame(JFrame frame, Component... comps) {
        for (Component comp : comps) {
            frame.add(comp);
        }
    }

    /**
     * Renders title
     * @param title title to be rendered
     * @param titleP panel to put title
     */
    void createTitle(String title, JPanel titleP) {
        JLabel titleL = new JLabel(title);

        titleL.setHorizontalAlignment(SwingConstants.CENTER);
        titleL.setFont(new Font("Arial", Font.BOLD, 24));
        titleP.add(titleL, BorderLayout.CENTER);
    }

    /**
     * Create label with text field
     * @param panel panel to put label and text field
     * @param str string to be displayed inside label
     * @return text field
     */
    JTextField createLabelTextField(JPanel panel, String str) {
        JLabel label = new JLabel(str, SwingConstants.RIGHT);
        JTextField tField = new JTextField();

        label.setFont(new Font("Arial", Font.PLAIN, 15));
        tField.setPreferredSize(new Dimension(200, 24));

        addPanel(panel, label, tField);
        return tField;
    }

    /**
     * Creates a window that saves to obeject files when closed
     * @param frame frame used to display components
     * @param width width of frame
     * @param height height of frame
     * @param data data to be saved in case of closing window
     */
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

    /**
     * Creates a warming in a given frame
     * @param frame frame to put warning
     * @param warningP waning to be displayed
     * @param str message
     * @return label with warning
     */
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

    /**
     * Creates a textfield and hides text
     * @param pass panel to put password
     * @return JPasswordField
     */
    JPasswordField createPass(JPanel pass) {
        JLabel passL = new JLabel("Password:");
        JPasswordField password = new JPasswordField();

        passL.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setPreferredSize(new Dimension(200, 24));

        addPanel(pass, passL, password);

        return password;
    }
}
