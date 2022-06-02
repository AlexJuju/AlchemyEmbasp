package embasp.entities;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("placedRune")
public class DLVPlacedRune {
    @Param(0)
    private int i;
    @Param(1)
    private int j;
    @Param(2)
    private String shape;
    @Param(3)
    private String color;
    @Param(4)
    private String type;

    public DLVPlacedRune(int i, int j, String shape, String color, String type) {
        this.i = i;
        this.j = j;
        this.shape = shape;
        this.color = color;
        this.type = type;

        System.out.println("i: " + i + " j: " + j + " shape: " + shape + " color: " + color + " type: " + type);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
