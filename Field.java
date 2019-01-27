// Vad Bertalan | Informatika | II. ev | vbim1780

import javax.swing.*;

public class Field {
    private JButton button;
    private boolean clickedAlready;
    private int index;

    public Field(JButton button, int index) {
        this.button = button;
        this.index = index;
        clickedAlready = false;
    }

    public JButton getButton() {
        return button;
    }

    public boolean isClickedAlready() {
        return clickedAlready;
    }

    public void setClickedAlready(boolean clickedAlready) {
        this.clickedAlready = clickedAlready;
    }

    public int getIndex() {
        return index;
    }
}
