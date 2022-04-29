package view;

import commons.Enums;
import models.Cell;

public abstract class GraphicPanel {
    public abstract void update(Cell[][] matrix);

    public abstract void changeScreen(Enums.ButtonAction buttonAction);
}
