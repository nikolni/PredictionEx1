package system.engine.world.definition.entity.manager.api;


import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.execution.instance.enitty.api.EntityInstance;

import java.util.List;

public interface EntityDefinitionManager {
    void addEntityDefinition(EntityDefinition entityDefinition);
    List<EntityDefinition> getDefinitions();

}
