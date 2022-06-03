package embasp.entities;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import it.unical.mat.embasp.languages.asp.SymbolicConstant;

@Id("place")
public class DLVPlace {
    @Param(0)
    private int i;
    @Param(1)
    private int j;
    @Param(2)
    private SymbolicConstant shape;
    @Param(3)
    private SymbolicConstant color;
    @Param(4)
    private SymbolicConstant type;

    public DLVPlace(int i, int j, SymbolicConstant shape, SymbolicConstant color, SymbolicConstant type) {
        this.i = i;
        this.j = j;
        this.shape = shape;
        this.color = color;
        this.type = type;
    }

    public DLVPlace() {
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
