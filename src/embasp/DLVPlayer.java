package embasp;

import core.GameLogic;

public class DLVPlayer implements Runnable {
    @Override
    public void run() {
        while( GameLogic.getClearedCont() < GameLogic.getWidth()*GameLogic.getHeight() && GameLogic.getTrash() < 4 ) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ServiceManager.reloadGameFacts();
            ServiceManager.calculateAndMove();
        }
    }
}
