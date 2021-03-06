package core;

import commons.Enums;
import embasp.ServiceManager;

public class ButtonManager {
    public static void performAction(Enums.ButtonAction buttonAction, int x, int y) throws Exception {
        switch ( buttonAction ) {
            case PLAY:
                GameLogic.initialize();
                GraphicManager.setScreen(buttonAction);
                break;

            case AUTOPLAY:
                GameLogic.initialize();
                GraphicManager.setScreen(Enums.ButtonAction.PLAY);
                ServiceManager.initialize();
                break;

            case TILE:
                GameLogic.setRune(x, y);
                break;

            case DROP:
                GameLogic.dropRune();
                break;

            case MAIN:
                GraphicManager.setScreen(buttonAction);
                break;

            default:
                throw new Exception("Action not found!");
        }
    }
}
