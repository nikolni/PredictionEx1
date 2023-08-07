package system.engine.world.general.random.impl;

import java.util.Random;

public class FloatRandomInitialize {
    private Random random = new Random();


    public float ExecuteRandomInitialize(float maxRange){
        return random.nextFloat() * maxRange;
    }
}
