package embasp;

public class DLVPlayer implements Runnable {
    @Override
    public void run() {
        while( true ) {
            ServiceManager.reloadGameFacts();
            ServiceManager.calculateAndMove();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
