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

    private SwingGamePanel() {
        this.setLayout(new GridLayout(GameLogic.getHeight(), GameLogic.getWidth(), 1, 1));
        for(int i = 0; i < GameLogic.getHeight(); i++)
            for (int j = 0; j < GameLogic.getWidth(); j++) {
                bMatrix[i][j] = new Button(" h " + i + " w " + j, Enums.ButtonAction.TILE, new SwingButtonListener());
                this.add(bMatrix[i][j]);
            }

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
