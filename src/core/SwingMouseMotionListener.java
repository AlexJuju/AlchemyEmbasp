package core;

import view.SwingGamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class SwingMouseMotionListener implements MouseMotionListener {
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ( e.getSource() != null ) {
            SwingGamePanel panel = (SwingGamePanel) SwingGamePanel.getPanel();
            panel.changeCursor(e.getX()-32, e.getY()-32);
        }
    }
}
