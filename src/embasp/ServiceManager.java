package embasp;

import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class ServiceManager {
    private static DesktopService service;
    private static DesktopHandler handler;
    private static InputProgram program;

    private ServiceManager () {}

    public static void initialize() {
        service = new DLV2DesktopService( _getDLVPath() );
        handler = new DesktopHandler(service);
        program = new ASPInputProgram();
        program.addFilesPath("encodings/alchemyia");
        handler.addProgram(program);

//        OptionDescriptor option = new OptionDescriptor("-n 0");
//        handler.addOption(option);
    }

    private static String _getDLVPath() {
        String system = System.getProperty("os.name");
        if (system.contains("Windows")) {
            return "lib/dlv2.exe";
        }
        if (system.contains("Linux")) {
            return "lib/dlv2";
        }
        return "";
    }
}
