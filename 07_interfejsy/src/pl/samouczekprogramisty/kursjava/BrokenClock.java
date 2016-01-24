package pl.samouczekprogramisty.kursjava;

import java.io.Serializable;
import java.util.Date;

public class BrokenClock implements Clock, Serializable {
    @Override
    public long secondsElapsedSince(Date date) {
        return 300;
    }
}
