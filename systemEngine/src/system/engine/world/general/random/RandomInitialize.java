package system.engine.world.general.random;

import java.util.Random;

public class RandomInitialize {
    private Random random = new Random();
    private final static int maxRange  = 50;

    private int randomLength = random.nextInt(maxRange);
    public Boolean boolRandomInitialize(){
        return random.nextBoolean();
    }

    public int intRandomInitialize(int maxRange){
        return random.nextInt(maxRange);
    }

    public float floatRandomInitialize(float maxRange){
        return random.nextFloat() * maxRange;
    }



    public String stringRandomInitialize(){
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 !?,_-().";
        StringBuilder sb = new StringBuilder(maxRange);

        for (int i = 0; i < maxRange; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}
