package view;

import commons.Enums;
import core.SwingButtonListener;

import javax.swing.*;

public class SwingMenuPanel extends JPanel {

    private static SwingMenuPanel panel;

    private SwingMenuPanel() {
        this.add( new Button("CLICCA QUI PER GIOCARE", Enums.ButtonAction.PLAY, new SwingButtonListener(), -1, -1));
        this.add( new Button("CLICCA QUI PER FAR GIOCARE L'IA", Enums.ButtonAction.AUTOPLAY, new SwingButtonListener(), -1, -1));
    }

    public static JPanel getPanel() {
        if (panel == null)
            panel = new SwingMenuPanel();

        return panel;
    }
}
