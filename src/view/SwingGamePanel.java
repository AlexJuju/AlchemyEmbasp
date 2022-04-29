package view;

import javax.swing.*;

public class SwingGamePanel extends JPanel {

    private static SwingGamePanel panel;

    private SwingGamePanel() {
        this.add(new JLabel("Benvenuto al gioco c:"));
    }

    public static JPanel getPanel() {
        if (panel == null)
            panel = new SwingGamePanel();

        return panel;
    }
}
