package system.engine.world.execution.instance.enitty.manager.api;


import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.definition.entity.api.EntityDefinition;

import java.util.List;

public interface EntityInstanceManager {

    EntityInstance create(EntityDefinition entityDefinition);
    List<EntityInstance> getInstances();

    void killEntity(int id);
}
