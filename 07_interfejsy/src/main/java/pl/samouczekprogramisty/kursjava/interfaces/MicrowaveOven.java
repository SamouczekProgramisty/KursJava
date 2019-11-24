package pl.samouczekprogramisty.kursjava.interfaces;

import java.time.Duration;

public interface MicrowaveOven {

    void start();

    void setDuration(int durationInSeconds);

    boolean isFinished();

    void setPower(int power);

    default String getName() {
        return "MicrovaweOwen";
    }

    default Duration getRecommendedDefrostTime(double foodWeightInGrams) {
        double frostRate = 0.8;
        int power = 300;
        return getRecommendedTime(power, frostRate, foodWeightInGrams);
    }

    default Duration getRecommendedWarmingUpTime(double foodWeightInGrams) {
        double frostRate = 0.2;
        int power = 700;
        return getRecommendedTime(power, frostRate, foodWeightInGrams);
    }

    private Duration getRecommendedTime(int power, double frostRate, double foodWeightInGrams) {
        double durationInMinutes = foodWeightInGrams / ((1 - frostRate) * power);
        long durationInSeconds = (long) (durationInMinutes * 60);
        return Duration.ofSeconds(durationInSeconds);
    }
}

