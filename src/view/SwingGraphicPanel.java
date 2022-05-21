package view;

import commons.Enums;
import core.SwingButtonListener;
import models.Cell;
import models.Rune;

import javax.swing.*;
import java.awt.*;

public class SwingGraphicPanel extends GraphicPanel {

    private JFrame pane = new JFrame();
    private JPanel mainPanel = new JPanel();
    private JDialog popup;
    private static Rune currentRune;
    private static int trash;

    public SwingGraphicPanel() {
        pane.setVisible(true);
        pane.setSize(new Dimension(960, 800));
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
    public void changeScreen(Enums.ButtonAction buttonAction) throws Exception {
        switch (buttonAction) {
            case PLAY:
                SwingGamePanel.initialize();
                this.changePanel(SwingGamePanel.getPanel());
                break;

            case LOSE:
                showEndingPopUp("Hai perso!");
                break;

            case WIN:
                showEndingPopUp("Hai vinto!");
                break;

            case MAIN:
                this.changePanel(SwingMenuPanel.getPanel());
                this.closePopUp();
                break;

            default:
                throw new Exception("Action not found!");
        }
    }

    private void showEndingPopUp(String text) {
        popup = new JDialog(pane, text);
        popup.setLayout( new GridLayout(2,1) );

        JLabel label = new JLabel(text);
        popup.add(label);

        Button button = new Button("OK", Enums.ButtonAction.MAIN, new SwingButtonListener(), -1, -1);
        popup.add(button);

        popup.setSize(100, 100);
        popup.setLocationRelativeTo(pane);
        popup.setVisible(true);
    }

    private void closePopUp() {
        if( popup != null )
            popup.dispose();
    }

    @Override
    public void changeCurrentRune(Rune rune) {
        this.currentRune = rune;
        SwingGamePanel panel = (SwingGamePanel) SwingGamePanel.getPanel();
        panel.changeCurrentRune();
    }

    @Override
    public void setTrash(int trash) {
        this.trash = trash;
        SwingGamePanel panel = (SwingGamePanel) SwingGamePanel.getPanel();
        panel.setTrash();
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
