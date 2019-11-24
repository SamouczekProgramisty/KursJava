package pl.samouczekprogramisty.kursjava.interfaces;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BrokenClock implements Clock, Serializable {
    @Override
    public long secondsElapsedSince(LocalDateTime date) {
        return 300;
    }
}
