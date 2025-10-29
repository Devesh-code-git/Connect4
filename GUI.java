package Main;
import javax.swing.*;

public class GUI extends JFrame{
    ImageIcon logo = new ImageIcon("logo.png");
    Panel panel;

    public GUI() {
        panel = new Panel();

        this.setVisible(true);
        this.setTitle("Connect4");

        this.add(panel);
        this.pack();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(logo.getImage());
        this.setLocationRelativeTo(null);
    }
}
