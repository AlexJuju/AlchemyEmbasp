package core;

import commons.Enums;
import models.Cell;
import models.Rune;
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

    public static void refreshWindow(Cell cell, int i, int j, Rune generatedRune) throws Exception {
        if(panel == null) {
            throw new Exception("Panel not initialized");
        }
        panel.changeCurrentRune(generatedRune);
        panel.update(cell, i, j);
    }

    public static void refreshTrash(int trash, Rune currentRune) throws Exception {
        if(panel == null) {
            throw new Exception("Panel not initialized");
        }
        panel.changeCurrentRune(currentRune);
        panel.setTrash(trash);
    }

    public static void setRune(Rune generatedRune) throws Exception {
        if (panel == null) {
            throw new Exception("Panel not initialized");
        }
        panel.changeCurrentRune(generatedRune);
    }

    public static void setScreen(Enums.ButtonAction buttonAction) throws Exception {
        panel.changeScreen(buttonAction);
    }

    public static void endGame(Enums.ButtonAction state) throws Exception {
        setScreen(state);
    }
}
