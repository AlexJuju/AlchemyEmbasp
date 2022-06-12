package embasp;

import commons.RuneType;
import embasp.entities.*;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class ServiceManager {
    private static DesktopHandler handler;
    private static InputProgram programrules;
    private static InputProgram gamestate;

    private ServiceManager () {}

    public static void initialize() {
        handler = new DesktopHandler(new DLV2DesktopService( _getDLVPath() ));
        programrules = new ASPInputProgram();
        programrules.addFilesPath("encodings/alchemyia");
        programrules.addFilesPath("encodings/alchemyia_weak");
        handler.addProgram(programrules);

        OptionDescriptor option = new OptionDescriptor("-n 0");
        handler.addOption(option);

        try {
            ASPMapper.getInstance().registerClass(DLVRune.class);
            ASPMapper.getInstance().registerClass(DLVPlace.class);
            ASPMapper.getInstance().registerClass(DLVPlacedRune.class);
            ASPMapper.getInstance().registerClass(DLVCleared.class);
            ASPMapper.getInstance().registerClass(DLVTrash.class);
        } catch (ObjectNotValidException | IllegalAnnotationException e) {
            e.printStackTrace();
        }
        gamestate = new ASPInputProgram();

        new Thread( new DLVPlayer() ).start();
    }

    public static void reloadGameFacts() {
        gamestate.clearAll();
        try {
            gamestate.addObjectsInput( ServiceController.getGameFacts() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        handler.addProgram(gamestate);
    }

    public static void calculateAndMove() {
        Output output = handler.startSync();
        AnswerSets answerSets = (AnswerSets) output;
        DLVPlace nextMove = null;
        if( !answerSets.getOptimalAnswerSets().isEmpty() ) {
            try {
                for (Object o : answerSets.getOptimalAnswerSets().get(0).getAtoms() /*a.getAtoms()*/) {
                    if (o instanceof DLVPlace) {
                        nextMove = (DLVPlace) o;
                        break;
                    }
                }
                if ( nextMove != null && nextMove.getType().toString().equals(RuneType.Type.STONE.getName().toLowerCase()) ) {
                    printAS(answerSets.getOptimalAnswerSets());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ServiceController.setPlayerMove(nextMove);
    }

    private static void printAS(List<AnswerSet> answerSets) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        for ( AnswerSet as: answerSets ) {
            for (Map.Entry<Integer, Integer> entry : as.getWeights().entrySet()) {
                System.out.println("Livello/peso " + entry.getKey() + ":" + entry.getValue().toString());
            }
            for ( Object o: as.getAtoms()) {
                if ( o instanceof DLVPlace ) {
                    System.out.println("Type: " + ((DLVPlace) o).getType() + " I: " + ((DLVPlace) o).getI() + " J: " + ((DLVPlace) o).getJ());
                }
            }
        }
    }

    //TODO: Cosa succede se se tutte le mosse sono possibili validi?

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
