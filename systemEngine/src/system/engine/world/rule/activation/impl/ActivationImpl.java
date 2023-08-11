package system.engine.world.rule.activation.impl;

import system.engine.world.rule.activation.api.Activation;
import system.engine.world.tick.Tick;

public class ActivationImpl implements Activation {
    private Tick ticks = new Tick();
    private float probability = 1;

    public int getTicks() {
        return ticks.getTick();
    }

    public void setTicks(Tick ticks) {
        this.ticks = ticks;
    }

    public float getProbability() {
        return probability;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    @Override
    public boolean isActive(int tickNumber) {

        int myTick = 0;
        while(myTick < tickNumber) {
            myTick+= ticks.getTick();
            if(myTick == tickNumber){
                return true;
            }
        }
        return false;
    }
}
