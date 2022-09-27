package fr.lernejo.guessname;

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

    public void loopUntilPlayerSucceed() {
        while (!nextRound()) {
            player.respond(numberToGuess > player.askNextGuess());
        }
    }
}
