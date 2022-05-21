package core;

import commons.Enums;
import commons.RuneType;
import models.Cell;
import models.Rune;

import java.util.Arrays;

public class GameLogic {
    private static final int width = 9;
    private static final int height = 8;
    private static Cell[][] matrix = new Cell[height][width];
    private static int[] contRows = new int[height];
    private static int[] contCols = new int[width];
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

        currentRune = null;
        _generateRune();
        try {
            GraphicManager.setRune(currentRune);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            GraphicManager.refreshTrash(trash, currentRune);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static void _generateRune() {
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

    private static boolean _canPlaceRune(int i, int j) {
        if (matrix[i][j].getRune() != null)
            return false;

        if ( currentRune.getType() == RuneType.Type.STONE )
            return true;

        int missingSide = 0;

        if (i-1 >= 0 && matrix[i-1][j].getRune() != null) {
            if (!_compatiblesRunes(matrix[i-1][j].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (i+1 < height && matrix[i+1][j].getRune() != null) {
            if(!_compatiblesRunes(matrix[i+1][j].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (j-1 >= 0 && matrix[i][j-1].getRune() != null) {
            if (!_compatiblesRunes(matrix[i][j-1].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (j+1 < width && matrix[i][j+1].getRune() != null) {
            if(!_compatiblesRunes(matrix[i][j+1].getRune(), currentRune))
                return false;
        } else missingSide++;

        if (missingSide >= 4)
            return false;

        return true;
    }

    private static boolean _compatiblesRunes(Rune runeOne, Rune runeTwo) {
        if ( runeOne.getType() == RuneType.Type.STONE || runeTwo.getType() == RuneType.Type.STONE)
            return true;
        if ( runeOne.getColor() == runeTwo.getColor() )
            return true;
        if ( runeOne.getShape() == runeTwo.getShape() )
            return true;
        return false;
    }

    private static void _gameOver() {
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

    private static void _increaseCont(int row, int col) {
        contRows[row]++;
        contCols[col]++;
        boolean clearRow = contRows[row] >= width;
        boolean clearCol = contCols[col] >= height;

        if( clearRow )
            _clearRow(row);

        if( clearCol )
            _clearCol(col);
    }

    private static void _clearRow(int row) {
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

    private static void _clearCol(int col) {
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

    public static void setRune(int i, int j) {
        if(_canPlaceRune(i, j)){
            matrix[i][j].setRune(currentRune);
            if(!matrix[i][j].isCleared()) {
                matrix[i][j].setCleared(true);
                clearedCont++;
                if(clearedCont >= height*width)
                    _gameOver();
            }
            _generateRune();
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

            _increaseCont(i, j);
        }
    }

    public static void dropRune() {
        trash++;
        if( trash >= 4 )
            _gameOver();
        else {
            _generateRune();
            try {
                GraphicManager.refreshTrash(trash, currentRune);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Cell[][] getMatrix() {
        return matrix;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static Rune getCurrentRune() {
        return currentRune;
    }

    public static int getTrash() {
        return trash;
    }

    public static int getClearedCont() {
        return clearedCont;
    }

}
