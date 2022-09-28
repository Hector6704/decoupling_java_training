package fr.lernejo.guessgame;

public class ComputerPlayer implements  Player {
    private int min = 0;
    private int max = 100;
    private int guess = 50;

    @Override
    public long askNextGuess() {
        return guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            min = guess;
        } else {
            max = guess;
        }
        guess = (max + min) / 2;
    }
}
