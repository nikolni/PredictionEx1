package system.engine.world.definition.entity.manager.impl;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.execution.instance.enitty.impl.EntityInstanceImpl;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.execution.instance.property.impl.PropertyInstanceImpl;

import java.util.ArrayList;
import java.util.List;

public class EntityDefinitionManagerImpl implements EntityDefinitionManager {
    private List<EntityDefinition> definitions;

    public EntityDefinitionManagerImpl() {
        definitions = new ArrayList<>();
    }

    @Override
    public void addEntityDefinition(EntityDefinition entityDefinition) {
        definitions.add(entityDefinition);
    }

    @Override
    public List<EntityDefinition> getDefinitions() {
        return definitions;
    }

}
