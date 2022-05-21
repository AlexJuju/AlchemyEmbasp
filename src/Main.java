import core.GraphicManager;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class Main {
    public static void main(String[] args) {

        DesktopService service = new DLV2DesktopService("lib/dlv2.exe");
//        DesktopService service = new DLV2DesktopService("lib/dlv2");

        try {
            GraphicManager.newWindow(GraphicManager.PanelType.SWING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}