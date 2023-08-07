package system.engine.world.general.random.impl;

import java.util.Random;

public class StringRandomInitialize {
    private final static int maxRange  = 50;
    private Random random = new Random();
    private int randomLength = random.nextInt(maxRange);

    public String ExecuteRandomInitialize(){
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !?,_-().";
        StringBuilder sb = new StringBuilder(maxRange);

        for (int i = 0; i < maxRange; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
