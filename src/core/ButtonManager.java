package core;

import commons.Enums;

public class ButtonManager {
    public static void performAction(Enums.ButtonAction buttonAction, int x, int y) throws Exception {
        switch ( buttonAction ) {
            case PLAY:
                GameLogic.initialize();
                GraphicManager.setScreen(buttonAction);
                break;

            case TILE:
                GameLogic.setRune(x, y);
                break;

            default:
                throw new Exception("Action not found!");
        }
    }
}
