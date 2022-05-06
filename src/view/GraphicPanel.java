package view;

import commons.Enums;
import models.Cell;

public abstract class GraphicPanel {
    public abstract void update(Cell cell, int i, int j);

    public abstract void changeScreen(Enums.ButtonAction buttonAction);
}
