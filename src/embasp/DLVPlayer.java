package embasp;

public class DLVPlayer implements Runnable {
    @Override
    public void run() {
        while( true ) {
            ServiceManager.reloadGameFacts();
            ServiceManager.calculateAndMove();
        }
    }
}
