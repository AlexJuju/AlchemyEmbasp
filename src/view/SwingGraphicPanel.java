package view;

import models.Cell;

import javax.swing.*;
import java.awt.*;

public class SwingGraphicPanel extends GraphicPanel {
    public SwingGraphicPanel() {
        JFrame pane = new JFrame();
        //pane.setUndecorated(true);
        pane.setVisible(true);
        pane.setSize(new Dimension(400, 400));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        pane.setLocation(dimension.width/2-pane.getSize().width/2, dimension.height/2-pane.getSize().height/2);
        pane.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void update(Cell[][] matrix) {

    }
}
