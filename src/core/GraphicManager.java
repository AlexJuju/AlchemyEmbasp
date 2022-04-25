package core;

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

}
