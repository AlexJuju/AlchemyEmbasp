package embasp;

import core.GameLogic;
import embasp.entities.DLVPlace;
import embasp.entities.DLVPlacedRune;
import embasp.entities.DLVRune;

import java.util.HashSet;
import java.util.Set;

public class ServiceController {

    public static Set<Object> getGameFacts () {

        HashSet<Object> coll = new HashSet<>();

        //Runa da piazzare
        coll.add( new DLVRune(
                GameLogic.getCurrentRune().getShape().getName().toLowerCase(),
                GameLogic.getCurrentRune().getColor().getName().toLowerCase(),
                GameLogic.getCurrentRune().getType().getName().toLowerCase()
        ));

        //Rune sul campo
        for (int i = 0; i < GameLogic.getHeight(); i++) {
            for (int j = 0; j < GameLogic.getWidth(); j++) {
                coll.add( new DLVPlacedRune( i, j,
                        GameLogic.getMatrix()[i][j].getRune().getShape().getName().toLowerCase(),
                        GameLogic.getMatrix()[i][j].getRune().getColor().getName().toLowerCase(),
                        GameLogic.getMatrix()[i][j].getRune().getType().getName().toLowerCase()
                ));
            }
        }

        return coll;
    }

    public static void setPlayerMove(DLVPlace place) {
        if (place == null) {
            GameLogic.dropRune();
            return;
        }

        GameLogic.setRune( place.getI(), place.getJ());
    }
}
