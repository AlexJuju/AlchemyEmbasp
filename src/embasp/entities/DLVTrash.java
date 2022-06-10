package embasp.entities;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("trash")
public class DLVTrash {
    @Param(0)
    private int trash;

    public DLVTrash(int trash) {
        this.trash = trash;
    }

    public int getTrash() {
        return trash;
    }

    public void setTrash(int trash) {
        this.trash = trash;
    }
}
