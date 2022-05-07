package view;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;

public class SwingGameLayerPanel extends LayerUI<JComponent> {

    private static Image currentRune;
    private static int cursor_x;
    private static int cursor_y;

    SwingGameLayerPanel ( Image rune ) {
        currentRune = rune;
    }

    public static void setCurrentRune(Image rune) {
        currentRune = rune;
    }

    public void changeCoordinates(int x, int y) {
        cursor_x = x;
        cursor_y = y;
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        g.drawImage(currentRune, cursor_x, cursor_y, null);
    }
}
