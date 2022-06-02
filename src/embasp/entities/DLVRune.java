package embasp.entities;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("rune")
public class DLVRune {
    @Param(0)
    private String shape;
    @Param(1)
    private String color;
    @Param(2)
    private String type;

    public DLVRune(String shape, String color, String type) {
        this.shape = shape;
        this.color = color;
        this.type = type;
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
