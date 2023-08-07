package system.engine.world.general.random.impl;

import java.util.Random;

public class IntRandomInitialize {
    private Random random = new Random();


    public int ExecuteRandomInitialize(int maxRange){
        return random.nextInt(maxRange);
    }

}
