package core;

import commons.Enums;

public class ButtonManager {
    public static void performAction(Enums.ButtonAction buttonAction) throws Exception {
        switch ( buttonAction ) {
            case PLAY:
                GameLogic.initialize();
                GraphicManager.setScreen(buttonAction);
                break;
            default:
                throw new Exception("Action not found!");
        }
    }
}
