package system.engine.world.api;

import system.engine.world.impl.WorldInstance;

public interface WorldDefinition {
    WorldInstance createWorldInstance();
}
