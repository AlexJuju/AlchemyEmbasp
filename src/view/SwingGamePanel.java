package view;

import commons.Enums;
import core.GameLogic;
import core.ImageHandler;
import core.SwingButtonListener;
import models.Cell;

import javax.swing.*;
import java.awt.*;

public class SwingGamePanel extends JPanel {

    private static SwingGamePanel panel;
    private static Button bMatrix[][] = new Button[GameLogic.getHeight()][GameLogic.getWidth()];
    private static Button trash;

    private SwingGamePanel() {
        this.setLayout(new BorderLayout());

        JPanel tilesPane = new JPanel();
        tilesPane.setLayout(new GridLayout(GameLogic.getHeight(), GameLogic.getWidth()));
        for(int i = 0; i < GameLogic.getHeight(); i++)
            for (int j = 0; j < GameLogic.getWidth(); j++) {
                bMatrix[i][j] = new Button(" h " + i + " w " + j, Enums.ButtonAction.TILE, new SwingButtonListener());
                bMatrix[i][j].setPreferredSize(new Dimension(80,80));
//                bMatrix[i][j].setFocusPainted(false);
                bMatrix[i][j].setContentAreaFilled(false);
                tilesPane.add(bMatrix[i][j]);
            }

        this.add(tilesPane, BorderLayout.CENTER);

        this.trash = new Button("Dropped runes here!", Enums.ButtonAction.DROP, new SwingButtonListener());
        this.trash.setPreferredSize(new Dimension(100,100));
        this.trash.setContentAreaFilled(false);
        JPanel sidebar = new JPanel();
        sidebar.add(this.trash);
        this.add(sidebar, BorderLayout.LINE_START);
    }

    public static JPanel getPanel() {
        if (panel == null)
            panel = new SwingGamePanel();

        return panel;
    }
}
