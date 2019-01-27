// Vad Bertalan | Informatika | II. ev | vbim1780

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    JLabel scoreLabel;

    public void updateScore(String score) {
        scoreLabel.setText(score);
    }

    public Frame() {
        GameController gameController = GameController.getInstance();
        gameController.setFrame(this);
        int n = gameController.getN();

        setBounds(400, 100, 800, 800);
        Container contentPane = getContentPane();

        JPanel upperPanel = new JPanel(new GridLayout(n, n));
        JPanel lowerPanel = new JPanel();

        scoreLabel = new JLabel("score will be disp here");
        lowerPanel.add(scoreLabel);

        for (int i = 0; i < n * n; i++) {
            JButton button = new JButton(i + "");
            Field field = new Field(button, i);

            button.addMouseListener(new Listener(field));

            upperPanel.add(button);
            gameController.addField(field);
        }

        contentPane.add(upperPanel);
        contentPane.add(lowerPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}
