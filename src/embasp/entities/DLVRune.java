package embasp.entities;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import it.unical.mat.embasp.languages.asp.SymbolicConstant;

@Id("rune")
public class DLVRune {
    @Param(0)
    private SymbolicConstant shape;
    @Param(1)
    private SymbolicConstant color;
    @Param(2)
    private SymbolicConstant type;

    public DLVRune(SymbolicConstant shape, SymbolicConstant color, SymbolicConstant type) {
        this.shape = shape;
        this.color = color;
        this.type = type;
    }

    public SymbolicConstant getShape() {
        return shape;
    }

    public void setShape(SymbolicConstant shape) {
        this.shape = shape;
    }

    public SymbolicConstant getColor() {
        return color;
    }

    public void setColor(SymbolicConstant color) {
        this.color = color;
    }

    public SymbolicConstant getType() {
        return type;
    }

    public void setType(SymbolicConstant type) {
        this.type = type;
    }
}
