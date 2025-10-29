package Main;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener{
    private final int row = 6;
    private final int col = 7;
    private final int cell_size = 100;
    private boolean winLine = false;
    private boolean animate = false;
    private Timer timer;
    private int yVelocity = 20;
    private int y = 100;
    private int[][] board;
    private int freeCol = 0;
    private int choice = 0;
    // Adding all buttons responding to the columns
    private JButton button_1 = new JButton("↓");
    private JButton button_2 = new JButton("↓");
    private JButton button_3 = new JButton("↓");
    private JButton button_4 = new JButton("↓");
    private JButton button_5 = new JButton("↓");
    private JButton button_6 = new JButton("↓");
    private JButton button_7 = new JButton("↓");
    //Replay button
    private JButton replay = new JButton("Replay");

    Game play = new Game();

    public Panel() {
        this.setPreferredSize(new Dimension(700, 800));
        this.setBackground(Color.YELLOW);
        this.setLayout(null);
        timer = new Timer(20, this);
        timer.start();

        // Setting all buttons
        button_1.setFont(new Font("Arial", Font.BOLD, 20));
        button_1.setBounds(3, 3, 94, 94);
        button_1.setBackground(Color.BLUE); button_1.setForeground(Color.WHITE); button_1.setOpaque(true); button_1.setBorderPainted(false);

        button_2.setFont(new Font("Arial", Font.BOLD, 20));
        button_2.setBounds(103, 3, 94, 94);
        button_2.setBackground(Color.BLUE); button_2.setForeground(Color.WHITE); button_2.setOpaque(true); button_2.setBorderPainted(false);

        button_3.setFont(new Font("Arial", Font.BOLD, 20));
        button_3.setBounds(203, 3, 94, 94);
        button_3.setBackground(Color.BLUE); button_3.setForeground(Color.WHITE); button_3.setOpaque(true); button_3.setBorderPainted(false);

        button_4.setFont(new Font("Arial", Font.BOLD, 20));
        button_4.setBounds(303, 3, 94, 94);
        button_4.setBackground(Color.BLUE); button_4.setForeground(Color.WHITE); button_4.setOpaque(true); button_4.setBorderPainted(false);

        button_5.setFont(new Font("Arial", Font.BOLD, 20));
        button_5.setBounds(403, 3, 94, 94);
        button_5.setBackground(Color.BLUE); button_5.setForeground(Color.WHITE); button_5.setOpaque(true); button_5.setBorderPainted(false);

        button_6.setFont(new Font("Arial", Font.BOLD, 20));
        button_6.setBounds(503, 3, 94, 94);
        button_6.setBackground(Color.BLUE); button_6.setForeground(Color.WHITE); button_6.setOpaque(true); button_6.setBorderPainted(false);

        button_7.setFont(new Font("Arial", Font.BOLD, 20));
        button_7.setBounds(603, 3, 94, 94);
        button_7.setBackground(Color.BLUE); button_7.setForeground(Color.WHITE); button_7.setOpaque(true); button_7.setBorderPainted(false);

        replay.setFont(new Font("Arial", Font.BOLD, 20));
        replay.setBounds(300, 720, 100, 60);
        replay.setBackground(Color.BLUE); replay.setForeground(Color.WHITE); replay.setOpaque(true); replay.setBorderPainted(false);

        this.add(button_1); this.add(button_2); this.add(button_3); this.add(button_4); this.add(button_5); this.add(button_6); this.add(button_7); this.add(replay);

        // All actions listeners for the buttons
        button_1.addActionListener(e -> {
            if (play.validInput(1)) {
                choice = 1;
                freeCol = play.getFreeCol(1);
                animate = true;
                disableButtons();
            }
        });

        button_2.addActionListener(e -> {
            if (play.validInput(2)) {
                choice = 2;
                freeCol = play.getFreeCol(2);
                animate = true;
                disableButtons();
            }
        });

        button_3.addActionListener(e -> {
            if (play.validInput(3)) {
                choice = 3;
                freeCol = play.getFreeCol(3);
                animate = true;
                disableButtons();
            }
        });

        button_4.addActionListener(e -> {
            if (play.validInput(4)) {
                choice = 4;
                freeCol = play.getFreeCol(4);
                animate = true;
                disableButtons();
            }
        });

        button_5.addActionListener(e -> {
            if (play.validInput(5)) {
                choice = 5;
                freeCol = play.getFreeCol(5);
                animate = true;
                disableButtons();
            }
        });

        button_6.addActionListener(e -> {
            if (play.validInput(6)) {
                choice = 6;
                freeCol = play.getFreeCol(6);
                animate = true;
                disableButtons();
            }
        });

        button_7.addActionListener(e -> {
            if (play.validInput(7)) {
                choice = 7;
                freeCol = play.getFreeCol(7);
                animate = true;
                disableButtons();
            }
        });

        replay.addActionListener(e -> {
            play.reset();
            repaint();
            winLine = false;
            enableButtons();
        });
    }

    protected void paintComponent(Graphics g) {
        this.board = play.getState();
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Makes the circles look better
        g2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY); // Makes the circles look better

        g2D.setColor(Color.BLUE);
        g2D.fillRect(0, 0, 700, 100);

        for (int i = 0; i < col; i++) {
            g2D.setColor(Color.BLACK);
            g2D.setStroke(new BasicStroke(3));
            g2D.drawLine(i*cell_size, 0, i*cell_size, 700);
        }

        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(698, 0, 698, 700);

        for (int i = 2; i < row + 2; i++) {
            g2D.setColor(Color.BLACK);
            g2D.setStroke(new BasicStroke(3));
            g2D.drawLine(0, i*cell_size, 700, i*cell_size);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 0) {
                    g2D.setColor(Color.BLUE);
                    g2D.fillOval(j * cell_size + (cell_size - 80) / 2, (i * cell_size + (cell_size - 80) / 2) + 100, 80, 80);
                } else if (board[i][j] == 1){
                    g2D.setColor(Color.RED);
                    g2D.fillOval(j * cell_size + (cell_size - 80) / 2, (i * cell_size + (cell_size - 80) / 2) + 100, 80, 80);
                } else {
                    g2D.setColor(Color.BLACK);
                    g2D.fillOval(j * cell_size + (cell_size - 80) / 2, (i * cell_size + (cell_size - 80) / 2) + 100, 80, 80);
                }
            }
        }

        if (animate) {
            if (play.getPlayer()) {
                g2D.setColor(Color.RED);
                g2D.fillOval((choice - 1) * cell_size + (cell_size - 80) / 2, (y + (cell_size - 80) / 2) + 100, 80, 80);
            } else {
               g2D.setColor(Color.BLACK);
               g2D.fillOval((choice - 1) * cell_size + (cell_size - 80) / 2, (y + (cell_size - 80) / 2) + 100, 80, 80); 
            }
        }

        if (winLine) {
            int x1 = play.getx1() * cell_size + cell_size / 2;
            int y1 = play.gety1() * cell_size + 100 + cell_size / 2;
            int x2 = play.getx2() * cell_size + cell_size / 2;
            int y2 = play.gety2() * cell_size + 100 + cell_size / 2;
            g2D.setColor(Color.GREEN);
            g2D.drawLine(x1, y1, x2, y2);
        }
    }

    // Function to disable all buttons once someone wins
    private void disableButtons() {
        button_1.setEnabled(false);
        button_2.setEnabled(false);
        button_3.setEnabled(false);
        button_4.setEnabled(false);
        button_5.setEnabled(false);
        button_6.setEnabled(false);
        button_7.setEnabled(false);
    }

    private void enableButtons() {
        button_1.setEnabled(true);
        button_2.setEnabled(true);
        button_3.setEnabled(true);
        button_4.setEnabled(true);
        button_5.setEnabled(true);
        button_6.setEnabled(true);
        button_7.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (animate) {
            y += yVelocity;
            repaint();

            if (y >= (freeCol*cell_size)) {
                y = (freeCol+cell_size);
                animate = false;

                if (choice >= 1 && choice <= 7) {
                    play.playerInput(choice);
                }

                enableButtons();

                if (play.winCheck()) {
                    disableButtons();
                    winLine = true;
                } else if (play.drawCheck()) {
                    disableButtons();
                }

                repaint();
                y = 0;
            }
        }
     }
}
