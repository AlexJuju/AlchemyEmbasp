package view;

import commons.Enums;
import models.Cell;
import models.Rune;

public abstract class GraphicPanel {
    public abstract void update(Cell cell, int i, int j);

    public abstract void changeScreen(Enums.ButtonAction buttonAction);

    public abstract void changeCurrentRune(Rune rune);

    public abstract void setTrash(int trash);
}
