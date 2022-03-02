package com.eureka.persons.util;

import java.util.Random;

public final class NumberGenerator {
    private static final Random RAND = new Random();
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    private static Character randomCharacter() {
        final var all = UPPER.concat(UPPER.toLowerCase()).concat(DIGITS);
        return all.charAt(RAND.nextInt(all.length() - 1));
    }

    private NumberGenerator() {
        // prevent initialization fo this class
    }
}
