package pl.samouczekprogramisty.kursjava.interfaces;

import java.time.LocalDateTime;

public interface Clock {
    long secondsElapsedSince(LocalDateTime date);
}
