package core;

import models.Cell;

public class GameLogic {
    private static int width = 9;
    private static int height = 8;
    private Cell[][] matrix = new Cell[height][width];
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

    public void update() {

    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
