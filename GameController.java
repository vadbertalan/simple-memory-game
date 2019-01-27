// Vad Bertalan | Informatika | II. ev | vbim1780

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/*
    Singleton class, so that everyone operates with the same instance of this class.
 */
public class GameController {
    private static GameController instanceGameController;

    public static GameController getInstance() {
        if (instanceGameController == null) {
            instanceGameController = new GameController();
        }
        return instanceGameController;
    }

    private Frame frame;

    private Integer buttonNumberToRemember = 5;
    private int clickedButtonNo = 0;
    private int correctlyGuessedNumber = 0;
    private int n = 4;
    private List<Field> fields;

    private boolean guessingStarted = false;

    private GameController() {
        fields = new ArrayList<>();
    }

    public boolean isGuessingStarted() {
        return guessingStarted;
    }

    public void setGuessingStarted() {
        guessingStarted = true;
        frame.updateScore("Guessing is ON!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        guessingStarted = false;
        JOptionPane.showMessageDialog(frame, "your score: " + correctlyGuessedNumber + " / 5", "Score", JOptionPane.INFORMATION_MESSAGE);
        initGame();
    }

    private void initGame() {
        correctlyGuessedNumber = 0;
        clickedButtonNo = 0;
        buttonNumberToRemember = 5;
        frame.updateScore("score will be disp here");
        for (Field field : fields) {
            JButton button = field.getButton();
            field.setClickedAlready(false);
            button.setEnabled(true);
            button.setBackground(null);
        }
    }

    public void incrementCorrectlyGuessedNumber() {
        correctlyGuessedNumber++;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public List<Field> getFields() {
        return fields;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    public Frame getFrame() {
        return frame;
    }

    public void decrementButtonNumberToRemember() {
        buttonNumberToRemember--;
    }

    public Integer getButtonNumberToRemember() {
        return buttonNumberToRemember;
    }

    public void setButtonNumberToRemember(int buttonNumberToRemember) {
        this.buttonNumberToRemember = buttonNumberToRemember;
    }

    public int getClickedButtonNo() {
        return clickedButtonNo;
    }

    public void incrementClickedButtonNo() {
        clickedButtonNo++;
    }

    public void updateScoreGUI() {
        String score = correctlyGuessedNumber + " / 5";
        frame.updateScore(score);
    }
}
