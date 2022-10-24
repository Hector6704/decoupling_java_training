package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private int numberToGuess;
    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = (int) numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess) {
            return true;
        }
        player.respond(guess < numberToGuess);
        return false;
    }

    public void loopUntilPlayerSucceed(long maxTry) {
        long startTime = System.currentTimeMillis();
        int i;
        for (i = 0; i < maxTry; i++) {
            if (nextRound()) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        if (i == maxTry) {
            logger.log("You failed to guess the number in " + maxTry + " tries");
        }
        else {
            logger.log("You guessed the number in " + (endTime - startTime)/1000 + " seconds and " + (i + 1) + " tries");
        }
    }
}
