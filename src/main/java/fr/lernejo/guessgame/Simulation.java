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
            logger.log("You guessed the number");
            return true;
        }
        player.respond(guess < numberToGuess);
        logger.log("You guessed wrong");
        return false;
    }

    public void loopUntilPlayerSucceed(int maxTry) {
        long startTime = System.currentTimeMillis();
        int i = 0;
        for (i = 0; i < maxTry; i++) {
            if (nextRound()) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        logger.log(String.format("You took %d:%d.%d to find the number and you %s the number before the maxTry", (endTime - startTime) / 60000, (endTime - startTime) / 1000 % 60, (endTime - startTime) % 1000, i < maxTry ? "found" : "didn't find"));
    }
}
