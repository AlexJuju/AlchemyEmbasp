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
                GraphicManager.refreshWindow(gamelogic.getMatrix());
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100/6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
        }
    }
}
