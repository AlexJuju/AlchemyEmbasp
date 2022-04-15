package core;

public class GameLogic {
    private int width = 9;
    private int height = 8;
    private int[][] matrix = new int[height][width];
    private static GameLogic gamelogic;

    private GameLogic() {}

    public static void initialize() {
        gamelogic = new GameLogic();
        GameLoop gameloop = new GameLoop(GameLogic.gamelogic);

        Thread gameThread = new Thread(gameloop);
        gameThread.start();
    }

    public boolean isGameOn() {
        return true; //TODO: Completare.
    }

    private void update() {

    }
}
