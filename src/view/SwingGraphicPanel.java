package view;

import commons.Enums;
import models.Cell;

import javax.swing.*;
import java.awt.*;

public class SwingGraphicPanel extends GraphicPanel {

    private JFrame pane = new JFrame();
    private JPanel mainPanel = new JPanel();

    public SwingGraphicPanel() {
        //pane.setUndecorated(true);
        pane.setVisible(true);
        pane.setSize(new Dimension(960, 800));
        this.changePanel(SwingMenuPanel.getPanel());
        pane.add(mainPanel);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        pane.setLocation(dimension.width/2-pane.getSize().width/2, dimension.height/2-pane.getSize().height/2);
        pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(Cell[][] matrix) {

    }

    @Override
    public void changeScreen(Enums.ButtonAction buttonAction) {
        switch (buttonAction) {
            case PLAY:
                this.changePanel(SwingGamePanel.getPanel());
                break;
        }
    }

    void changePanel(JPanel panel) {
        this.mainPanel.removeAll();
        this.mainPanel.add(panel);
        this.pane.revalidate();
        this.mainPanel.repaint();
        System.out.println("cambiato");
    }
}
