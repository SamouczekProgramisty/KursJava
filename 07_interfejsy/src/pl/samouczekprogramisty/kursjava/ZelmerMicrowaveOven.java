package pl.samouczekprogramisty.kursjava;

import java.util.Calendar;
import java.util.Date;

public class ZelmerMicrowaveOven implements MicrowaveOven {

    private int durationInSeconds = 90;
    private int power = 600;
    private Date start = null;

    private Clock clock;

    public ZelmerMicrowaveOven(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void start() {
        Calendar startCalendar = Calendar.getInstance();
        start = startCalendar.getTime();
    }

    @Override
    public String getName() {
        return MicrowaveOven.super.getName();
    }

    @Override
    public void setDuration(int durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public boolean isFinished() {
        if (start == null) {
            return false;
        }
        return clock.secondsElapsedSince(start) >= durationInSeconds;
    }

    public static void main(String[] args) {
        Clock clock = new BrokenClock();
        MicrowaveOven oven = new ZelmerMicrowaveOven(clock);
        System.out.println(oven.isFinished());
        oven.start();
        System.out.println(oven.isFinished());
    }
}
