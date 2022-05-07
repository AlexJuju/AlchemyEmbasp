package view;

import commons.Enums;
import core.GameLogic;
import core.ImageHandler;
import core.SwingButtonListener;
import core.SwingMouseMotionListener;
import models.Cell;
import models.Rune;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SwingGamePanel extends JPanel {

    private static SwingGamePanel panel;
    private static Button bMatrix[][] = new Button[GameLogic.getHeight()][GameLogic.getWidth()];
    private static Button trash;
    private static SwingGameLayerPanel layerPanel;

    private SwingGamePanel(Image rune) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel tilesPane = new JPanel();
        tilesPane.setLayout(new GridLayout(GameLogic.getHeight(), GameLogic.getWidth()));
        MouseAdapter redispatcher = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt)
            {
                dispatchMouseEvent(evt);
            }
            @Override
            public void mouseExited(MouseEvent evt)
            {
                dispatchMouseEvent(evt);
            }
            @Override
            public void mouseMoved(MouseEvent evt)
            {
                dispatchMouseEvent(evt);
            }
            @Override
            public void mousePressed(MouseEvent evt)
            {
                dispatchMouseEvent(evt);
            }
            private void dispatchMouseEvent(MouseEvent evt)
            {
                Container parent = evt.getComponent().getParent();
                parent.dispatchEvent(SwingUtilities.convertMouseEvent(evt.getComponent(), evt, parent));
            }
        };
        for(int i = 0; i < GameLogic.getHeight(); i++)
            for (int j = 0; j < GameLogic.getWidth(); j++) {
                bMatrix[i][j] = new Button("", Enums.ButtonAction.TILE, new SwingButtonListener(), i, j);
                bMatrix[i][j].setPreferredSize(new Dimension(80,80));
//                bMatrix[i][j].setFocusPainted(false);
                bMatrix[i][j].setContentAreaFilled(false);
                bMatrix[i][j].addMouseListener(redispatcher);
                bMatrix[i][j].addMouseMotionListener(redispatcher);
                tilesPane.add(bMatrix[i][j]);
            }

        tilesPane.addMouseListener(redispatcher);
        tilesPane.addMouseMotionListener(redispatcher);

        mainPanel.add(tilesPane, BorderLayout.CENTER);

        trash = new Button("Dropped runes here!", Enums.ButtonAction.DROP, new SwingButtonListener(), -1, -1);
        trash.setPreferredSize(new Dimension(100,100));
        trash.setContentAreaFilled(false);
        JPanel sidebar = new JPanel();
        sidebar.add(trash);
        mainPanel.add(sidebar, BorderLayout.LINE_START);
        mainPanel.addMouseListener(redispatcher);
        mainPanel.addMouseMotionListener(redispatcher);

        layerPanel = new SwingGameLayerPanel(rune);
        JLayer<JComponent> layer = new JLayer<JComponent>(mainPanel, layerPanel);
        layer.addMouseListener(redispatcher);
        layer.addMouseMotionListener(redispatcher);
        this.add(layer);
        this.addMouseMotionListener(new SwingMouseMotionListener());
    }

    public static JPanel getPanel(Image currentRune) {
        if (panel == null)
            panel = new SwingGamePanel(currentRune);

        return panel;
    }

    public static void update(Cell logicCell, int i, int j) {
        if ( bMatrix[i][j] != null ) {
            if (logicCell.isCleared()) {
                bMatrix[i][j].setBackground(Color.ORANGE);
                bMatrix[i][j].setOpaque(true);
            }
            if (logicCell.getRune() != null) {
                bMatrix[i][j].setIcon(new ImageIcon( ImageHandler.getRuneImg(logicCell.getRune()) ));
            } else {
                bMatrix[i][j].setIcon(null);
            }
        }
    }

    public void changeCursor(int x, int y) {
        layerPanel.changeCoordinates(x, y);
        this.repaint();
    }

    public void changeCurrentRune(Rune rune) {
        layerPanel.setCurrentRune(ImageHandler.getRuneImg(rune));
        this.repaint();
    }
}
