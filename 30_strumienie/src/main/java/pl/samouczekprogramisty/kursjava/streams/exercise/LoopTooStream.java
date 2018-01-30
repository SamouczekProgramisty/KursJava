package pl.samouczekprogramisty.kursjava.streams.exercise;

import pl.samouczekprogramisty.kursjava.streams.BoardGame;

import java.util.Comparator;

public class LoopTooStream {

    public static void main(String[] args) {
        loopVersion();
        streamVersion();
    }

    private static void loopVersion() {
        double highestRanking = 0;
        BoardGame bestGame = null;
        for (BoardGame game : BoardGame.GAMES) {
            if (game.name.contains("a")) {
                if (game.rating > highestRanking) {
                    highestRanking = game.rating;
                    bestGame = game;
                }
            }
        }
        System.out.println(bestGame.name);
    }

    private static void streamVersion() {
        BoardGame bestGame = BoardGame.GAMES
                .stream()
                .filter(g -> g.name.contains("a"))
                .max(Comparator.comparingDouble(g1 -> g1.rating)).get();
        System.out.println(bestGame.name);
    }

}
