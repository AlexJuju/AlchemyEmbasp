package core;

import view.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Button source = null;
        if ( e.getSource() instanceof Button ) {
            source = (Button) e.getSource();
        }

        if (source != null) {
            try {
                ButtonManager.performAction(source.getButtonAction());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}