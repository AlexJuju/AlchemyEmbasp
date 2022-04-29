package view;

import commons.Enums;
import core.SwingButtonListener;

import javax.swing.*;

public class SwingMenuPanel extends JPanel {

    private static SwingMenuPanel panel;

    private SwingMenuPanel() {
        this.add( new Button("CLICCA QUI PER GIOCARE", Enums.ButtonAction.PLAY, new SwingButtonListener()));
    }

    public static JPanel getPanel() {
        if (panel == null)
            panel = new SwingMenuPanel();

        return panel;
    }
}
