import core.GraphicManager;
import embasp.ServiceManager;

public class Main {
    public static void main(String[] args) {
        try {
            GraphicManager.newWindow(GraphicManager.PanelType.SWING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}