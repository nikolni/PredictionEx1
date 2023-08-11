package system.engine.world.rule.activation.api;

public interface Activation {
    boolean isActive(int tickNumber);
    int getTicks();
    float getProbability();
}
