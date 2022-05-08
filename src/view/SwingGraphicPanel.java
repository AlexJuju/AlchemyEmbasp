package view;

import commons.Enums;
import core.ImageHandler;
import models.Cell;
import models.Rune;

import javax.swing.*;
import java.awt.*;

public class SwingGraphicPanel extends GraphicPanel {

    private JFrame pane = new JFrame();
    private JPanel mainPanel = new JPanel();
    private static Rune currentRune;
    private static int trash;

    public SwingGraphicPanel() {
        //pane.setUndecorated(true);
        pane.setVisible(true);
        pane.setSize(new Dimension(960, 800));
        //pane.setResizable(false);
        this.changePanel(SwingMenuPanel.getPanel());
        pane.add(mainPanel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        pane.setLocation(dimension.width/2-pane.getSize().width/2, dimension.height/2-pane.getSize().height/2);
        pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(Cell cell, int i, int j) {
        SwingGamePanel.update(cell, i, j);
    }

    @Override
    public void changeScreen(Enums.ButtonAction buttonAction) {
        switch (buttonAction) {
            case PLAY:
                this.changePanel(SwingGamePanel.getPanel());
                break;
        }
    }

    @Override
    public void changeCurrentRune(Rune rune) {
        this.currentRune = rune;
        SwingGamePanel panel = (SwingGamePanel) SwingGamePanel.getPanel();
        panel.changeCurrentRune(rune);
    }

    @Override
    public void setTrash(int trash) {
        this.trash = trash;
        SwingGamePanel panel = (SwingGamePanel) SwingGamePanel.getPanel();
        panel.setTrash(trash);
    }

    public static Rune getCurrentRune() {
        return currentRune;
    }

    public static int getTrash() {
        return trash;
    }

    void changePanel(JPanel panel) {
        this.mainPanel.removeAll();
        this.mainPanel.add(panel);
        this.pane.revalidate();
        this.mainPanel.repaint();
    }
}
