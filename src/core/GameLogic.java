package core;

import commons.RuneType;
import models.Cell;
import models.Rune;

import java.util.Arrays;

public class GameLogic {
    private static int width = 9;
    private static int height = 8;
    private static Cell[][] matrix = new Cell[height][width];
    private static GameLogic gamelogic;
    private static int contRows[] = new int[height];
    private static int contCols[] = new int[width];
    private static Rune currentRune;

    private GameLogic() {}

    public static void initialize() {
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
                matrix[i][j] = new Cell();

        gamelogic = new GameLogic();
        GameLoop gameloop = new GameLoop(GameLogic.gamelogic);

        Thread gameThread = new Thread(gameloop);
        gameThread.start();

        Arrays.fill(contRows, 0);
        Arrays.fill(contCols, 0);

        generateRune();
    }

    private static void generateRune() {
        RuneType.Type type;
        RuneType.Shape shape = null;
        RuneType.Color color = null;

        if( currentRune == null )
            type = RuneType.Type.STONE;
        else
            type = RuneType.Type.NORMAL; //RuneType.Type.getRandomType();

        if (type != RuneType.Type.STONE) {
            shape = RuneType.Shape.getRandomShape();
            color = RuneType.Color.getRandomColor();
        }
        currentRune = new Rune(shape, color, type);
    }

    public static void setRune(int i, int j) {
        if(matrix[i][j].getRune() == null){
            matrix[i][j].setRune(currentRune);
            matrix[i][j].setCleared(true);
            generateRune();
            try {
                GraphicManager.refreshWindow(matrix[i][j], i, j, currentRune);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    private static boolean increaseCont(int row, int col) {
        boolean check = true;
        contRows[row]++;
        if( contRows[row] >= width )
            check = false;

        contCols[col]++;
        if( contCols[col] >= height )
            check = false;

        return check;
    }
}
