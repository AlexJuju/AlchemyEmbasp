package core;

public class GameLoop implements Runnable{
    private GameLogic gamelogic;

    public GameLoop(GameLogic gamelogic) {
        this.gamelogic = gamelogic;
    }

    @Override
    public void run() {
        while( gamelogic.isGameOn() ) {

        }
    }
}
