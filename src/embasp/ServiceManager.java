package embasp;

import embasp.entities.DLVPlace;
import embasp.entities.DLVPlacedRune;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.platforms.desktop.DesktopService;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

public class ServiceManager {
    private static DesktopService service;
    private static DesktopHandler handler;
    private static InputProgram programrules;
    private static InputProgram gamestate;

    private ServiceManager () {}

    public static void initialize() {
        service = new DLV2DesktopService( _getDLVPath() );
        handler = new DesktopHandler(service);
        programrules = new ASPInputProgram();
        programrules.addFilesPath("encodings/alchemyia");
        handler.addProgram(programrules);

//        OptionDescriptor option = new OptionDescriptor("-n 0");
//        handler.addOption(option);

        try {
            ASPMapper.getInstance().registerClass(DLVPlace.class);
            ASPMapper.getInstance().registerClass(DLVPlacedRune.class);
        } catch (ObjectNotValidException | IllegalAnnotationException e) {
            e.printStackTrace();
        }
        gamestate = new ASPInputProgram();
    }

    public static void reloadGameFacts () {
        gamestate.clearAll();
        try {
            gamestate.addObjectsInput( ServiceController.getGameFacts() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        handler.addProgram(gamestate);
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
