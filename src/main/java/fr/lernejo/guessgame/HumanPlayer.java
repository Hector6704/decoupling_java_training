package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private final java.util.Scanner scanner = new java.util.Scanner(System.in);

    @Override
    public long askNextGuess() {
        return 0;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (!lowerOrGreater) {
            logger.log("The number to find is greater than your guess");
        } else {
            logger.log("The number to find is lower than your guess");
        }
    }
}
