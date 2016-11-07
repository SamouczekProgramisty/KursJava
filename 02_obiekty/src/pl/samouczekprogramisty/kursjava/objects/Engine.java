package pl.samouczekprogramisty.kursjava.objects;

public class Engine {

    private boolean started;
    private Cogwheel cogwheel;

    public Engine(Cogwheel cogwheel) {
        this.cogwheel = cogwheel;
    }

    public void start() {
        started = initiateStartingSequence();
    }

    private boolean initiateStartingSequence() {
        // comment
        return true;
    }

    public void stop() {
        started = false;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
}
