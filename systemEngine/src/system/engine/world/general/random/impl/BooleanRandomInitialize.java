package system.engine.world.general.random.impl;

import java.util.Random;

public class BooleanRandomInitialize {
    private Random random = new Random();

    public Boolean ExecuteRandomInitialize(){
        return random.nextBoolean();
    }
}
