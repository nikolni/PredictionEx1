package system.engine.world.rule.activation.impl;

import system.engine.world.rule.activation.api.Activation;
import system.engine.world.tick.Tick;

public class ActivationImpl implements Activation {
    private Tick ticks = new Tick(1);
    private float probability = 1;

    public ActivationImpl(Tick ticksParam, float probabilityParam){
        ticks= ticksParam;
        probability = probabilityParam;
    }
    public Tick getTicks() {
        return ticks;
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
        return false;
    }
}
