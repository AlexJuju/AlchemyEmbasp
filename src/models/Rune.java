package models;

import commons.RuneType;

public class Rune {
    private RuneType.Shape shape;
    private RuneType.Color color;
    private RuneType.Type type;

    public Rune(RuneType.Shape shape, RuneType.Color color, RuneType.Type type) {
        this.shape = shape;
        this.color = color;
        this.type = type;
    }

    public RuneType.Shape getShape() {
        return shape;
    }

    public RuneType.Color getColor() {
        return color;
    }

    public RuneType.Type getType() {
        return type;
    }
}
