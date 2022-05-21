package core;

import commons.Enums;
import commons.RuneType;
import models.Cell;
import models.Rune;

import java.util.Arrays;

public class GameLogic {
    private static int width = 9;
    private static int height = 8;
    private static Cell[][] matrix = new Cell[height][width];
    private static int contRows[] = new int[height];
    private static int contCols[] = new int[width];
    private static Rune currentRune;
    private static int trash;
    private static int clearedCont;

    private GameLogic() {}

    public static void initialize() {
        for(int i = 0; i < height; i++)
            for(int j = 0; j < width; j++)
                matrix[i][j] = new Cell();

        trash = 0;
        clearedCont = 0;

        Arrays.fill(contRows, 0);
        Arrays.fill(contCols, 0);

        generateRune();
        try {
            GraphicManager.setRune(currentRune);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateRune() {
        RuneType.Type type;
        RuneType.Shape shape = null;
        RuneType.Color color = null;

        if( currentRune == null )
            type = RuneType.Type.STONE;
        else
             type = RuneType.Type.getRandomType();

        if (type != RuneType.Type.STONE) {
            shape = RuneType.Shape.getRandomShape();
            color = RuneType.Color.getRandomColor();
        }
        currentRune = new Rune(shape, color, type);
    }

    public static void setRune(int i, int j) {
        if(canPlaceRune(i, j)){
            matrix[i][j].setRune(currentRune);
            if(!matrix[i][j].isCleared()) {
                matrix[i][j].setCleared(true);
                clearedCont++;
                if(clearedCont >= height*width)
                    gameOver();
            }
            generateRune();
            try {
                GraphicManager.refreshWindow(matrix[i][j], i, j, currentRune);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (trash > 0) {
                trash--;
                try {
                    GraphicManager.refreshTrash(trash, currentRune);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            increaseCont(i, j);
        }
    }

    private static boolean canPlaceRune(int i, int j) {
        if (matrix[i][j].getRune() != null)
            return false;

        if ( currentRune.getType() == RuneType.Type.STONE )
            return true;

        int missingSide = 0;

        if (i-1 >= 0 && matrix[i-1][j].getRune() != null) {
            if (!compatiblesRunes(matrix[i-1][j].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (i+1 < height && matrix[i+1][j].getRune() != null) {
            if(!compatiblesRunes(matrix[i+1][j].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (j-1 >= 0 && matrix[i][j-1].getRune() != null) {
            if (!compatiblesRunes(matrix[i][j-1].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (j+1 < width && matrix[i][j+1].getRune() != null) {
            if(!compatiblesRunes(matrix[i][j+1].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (missingSide >= 4)
            return false;

        return true;
    }

    private static boolean compatiblesRunes (Rune runeOne, Rune runeTwo) {
        if ( runeOne.getType() == RuneType.Type.STONE || runeTwo.getType() == RuneType.Type.STONE)
            return true;
        if ( runeOne.getColor() == runeTwo.getColor() )
            return true;
        if ( runeOne.getShape() == runeTwo.getShape() )
            return true;
        return false;
    }

    public static void dropRune() {
        trash++;
        if( trash >= 4 )
            gameOver();
        else {
            generateRune();
            try {
                GraphicManager.refreshTrash(trash, currentRune);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void gameOver() {
        if( trash >= 4 ) {
            try {
                GraphicManager.endGame(Enums.ButtonAction.LOSE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if( clearedCont >= height*width ) {
            try {
                GraphicManager.endGame(Enums.ButtonAction.WIN);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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

    private static void increaseCont(int row, int col) {
        contRows[row]++;
        contCols[col]++;
        boolean clearRow = contRows[row] >= width;
        boolean clearCol = contCols[col] >= height;

        if( clearRow )
            clearRow(row);

        if( clearCol )
            clearCol(col);
    }

    private static void clearRow(int row) {
        for(int j = 0; j < width; j++) {
            if( matrix[row][j].getRune() != null ) {
                matrix[row][j].setRune(null);
                if(contCols[j] <= 0)
                    System.out.println("Errore contatore per colonna: " + j);
                contCols[j]--;
                try {
                    GraphicManager.refreshWindow(matrix[row][j], row, j, currentRune);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        contRows[row] = 0;
        trash = 0;
        try {
            GraphicManager.refreshTrash(trash, currentRune);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void clearCol(int col) {
        for(int i = 0; i < height; i++) {
            if( matrix[i][col].getRune() != null ) {
                matrix[i][col].setRune(null);
                if(contRows[i] <= 0)
                    System.out.println("Errore contatore per riga: " + i);
                contRows[i]--;
                try {
                    GraphicManager.refreshWindow(matrix[i][col], i, col, currentRune);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        contCols[col] = 0;
        trash = 0;
        try {
            GraphicManager.refreshTrash(trash, currentRune);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
