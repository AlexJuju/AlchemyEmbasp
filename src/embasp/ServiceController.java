package embasp;

import commons.RuneType;
import core.GameLogic;
import embasp.entities.*;
import it.unical.mat.embasp.languages.asp.SymbolicConstant;

import java.util.HashSet;
import java.util.Set;

public class ServiceController {

    public static Set<Object> getGameFacts () {

        HashSet<Object> facts = new HashSet<>();

        //Runa da piazzare
        String shape, color, type;
        type = GameLogic.getCurrentRune().getType().getName().toLowerCase();
        if (GameLogic.getCurrentRune().getType() == RuneType.Type.STONE)
            shape = color = "a";
        else {
            shape = GameLogic.getCurrentRune().getShape().getName().toLowerCase();
            color = GameLogic.getCurrentRune().getColor().getName().toLowerCase();
        }

        facts.add( new DLVRune( new SymbolicConstant(shape), new SymbolicConstant(color), new SymbolicConstant(type) ));

        //Rune sul campo
        for (int i = 0; i < GameLogic.getHeight(); i++) {
            for (int j = 0; j < GameLogic.getWidth(); j++) {
                if (GameLogic.getMatrix()[i][j].getRune() != null) {

                    type = GameLogic.getMatrix()[i][j].getRune().getType().getName().toLowerCase();
                    if (GameLogic.getMatrix()[i][j].getRune().getType() == RuneType.Type.STONE)
                        shape = color = "a";
                    else {
                        shape = GameLogic.getMatrix()[i][j].getRune().getShape().getName().toLowerCase();
                        color = GameLogic.getMatrix()[i][j].getRune().getColor().getName().toLowerCase();
                    }

                    facts.add(new DLVPlacedRune(i, j,
                            new SymbolicConstant(shape),
                            new SymbolicConstant(color),
                            new SymbolicConstant(type)
                    ));
                }
                if ( GameLogic.getMatrix()[i][j].isCleared() )
                    facts.add( new DLVCleared(i, j));
            }
        }

        facts.add( new DLVTrash(GameLogic.getTrash()) );

        return facts;
    }

    public static void setPlayerMove(DLVPlace place) {
        if (place == null) {
            GameLogic.dropRune();
            return;
        }

        GameLogic.setRune( place.getI(), place.getJ());
    }
}
