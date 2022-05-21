package embasp;

import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class ServiceManager {
    private static DesktopService service;
    private static DesktopHandler handler;

    private ServiceManager () {}

    public static void initialize() {
        System.out.println("path: " + _getDLVPath());
        service = new DLV2DesktopService( _getDLVPath() );
    }

    private static String _getDLVPath() {
        String system = System.getProperty("os.name");
        System.out.println(system);
        if (system.contains("Windows")) {
            return "lib/dlv2.exe";
        }

        if (system.contains("Linux")) {
            return "lib/dlv2";
        }

        return "";
    }
}
