package core;

import commons.Enums;
import models.Cell;
import view.GraphicPanel;
import view.SwingGraphicPanel;



public class GraphicManager {
    private static GraphicPanel panel;

    public enum PanelType{SWING}

    public static void newWindow(PanelType type) throws Exception {
        if(panel != null) {
            throw new Exception("Cannot initialize new panel type.");
        }

        switch(type){
            case SWING:
                panel = new SwingGraphicPanel();
                break;

            default:
                throw new Exception("Invalid type.");

        }
    }

    public static void refreshWindow(Cell cell, int i, int j) throws Exception {
        if(panel == null) {
            throw new Exception("Panel not initialized");
        }
        panel.update(cell, i, j);
    }

    public static void setScreen(Enums.ButtonAction buttonAction) {
        panel.changeScreen(buttonAction);
    }
}
