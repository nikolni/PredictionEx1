package dto.definition.rule.activation.api;

import system.engine.world.tick.Tick;

public interface ActivationDTO {
    int getTicks();
    float getProbability();
}
