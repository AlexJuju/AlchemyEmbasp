package core;

public class GameLoop implements Runnable{
    private GameLogic gamelogic;


    public GameLoop(GameLogic gamelogic) {
        this.gamelogic = gamelogic;
    }

    @Override
    public void run() {
        while( gamelogic.isGameOn() ) {
            gamelogic.update();

            try {
                Thread.sleep(100/6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
        }
    }
}
