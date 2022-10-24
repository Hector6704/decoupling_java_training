package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Possible commands are : -interactive or -auto <number>");
        }
        else if (args[0].equalsIgnoreCase("-interactive")) {
            Player player = new HumanPlayer();
            Simulation sim = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            sim.initialize(randomNumber);
            sim.loopUntilPlayerSucceed((int) Long.MAX_VALUE);
        }
        else if (args[0].equalsIgnoreCase("-auto") && isNumeric(args[1])) {
            Player player = new ComputerPlayer();
            Simulation sim = new Simulation(player);
            sim.initialize(Integer.parseInt(args[1]));
            sim.loopUntilPlayerSucceed(1000);
        }
        else {
            System.out.println("Possible commands are : -interactive or -auto <number>");
        }
    }

    public static Boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
