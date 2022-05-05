package view;

import commons.Enums;
import core.GameLogic;
import core.SwingButtonListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SwingGamePanel extends JPanel {

    private static SwingGamePanel panel;
    private Button bMatrix[][] = new Button[GameLogic.getHeight()][GameLogic.getWidth()];
    private Button trash;

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

//        this.add(new JLabel("Benvenuto al gioco c:"));
//        File file = new File("src"+File.separator+"resources" + File.separator + "LeoRed.png");
//        Image icona = null;
//        try {
//            icona = ImageIO.read(file);
//        } catch (IOException e) {	e.printStackTrace();	}
//        JButton bottone = new JButton("", new ImageIcon(icona));
//        bottone.setBackground(Color.ORANGE);
//        this.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
//        this.setLayout( new GridLayout(5, 1, 15, 15) );
//        this.add(bottone);
//        this.setLayout();
    }

    public static JPanel getPanel() {
        if (panel == null)
            panel = new SwingGamePanel();

        return panel;
    }
}
