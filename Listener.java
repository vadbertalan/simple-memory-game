// Vad Bertalan | Informatika | II. ev | vbim1780

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Listener extends MouseAdapter {
    Field field;

    public Listener(Field field) {
        this.field = field;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        GameController gameController = GameController.getInstance();
        if (gameController.isGuessingStarted()) {
            if (gameController.getButtonNumberToRemember() == 0) {
                return;
            }
            if (gameController.getFields().get(field.getIndex()).isClickedAlready()) {
                field.getButton().setBackground(Color.GREEN);
                field.getButton().setEnabled(false);
                gameController.incrementCorrectlyGuessedNumber();
                gameController.updateScoreGUI();
            }
            else {
                field.getButton().setBackground(Color.RED);
                field.getButton().setEnabled(false);
            }
            gameController.decrementButtonNumberToRemember();
        }
        else {
            new Thread(() -> {
                if (gameController.getClickedButtonNo() >= gameController.getButtonNumberToRemember() || gameController.getFields().get(field.getIndex()).isClickedAlready()) {
                    return;
                }

                JButton hostButton = field.getButton();

                field.setClickedAlready(true);

                gameController.incrementClickedButtonNo();

                // extracting it into a variable, because other threads might change its value, while this thread sleeps
                int clickedButtons = gameController.getClickedButtonNo();

                hostButton.setBackground(Color.PINK);
                hostButton.setEnabled(false);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                hostButton.setBackground(null);
                hostButton.setEnabled(true);

                if (clickedButtons == gameController.getButtonNumberToRemember()) {
                    gameController.setGuessingStarted();
                }
            }).start();
        }
    }
}
