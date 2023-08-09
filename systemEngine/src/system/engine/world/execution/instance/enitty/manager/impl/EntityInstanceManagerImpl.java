package system.engine.world.execution.instance.enitty.manager.impl;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.execution.instance.enitty.impl.EntityInstanceImpl;
import system.engine.world.execution.instance.enitty.manager.api.EntityInstanceManager;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.execution.instance.property.impl.PropertyInstanceImpl;


import java.util.ArrayList;
import java.util.List;

public class EntityInstanceManagerImpl implements EntityInstanceManager {
    private int count;   //all instances of all entities
    private List<EntityInstance> instances;

    public EntityInstanceManagerImpl(EntityDefinitionManager entityDefinitionManager) {
        count = 0;
        instances = new ArrayList<>();
        for (EntityDefinition entityDefinition: entityDefinitionManager.getDefinitions()){
            create(entityDefinition);
        }
    }

    @Override
    public EntityInstance create(EntityDefinition entityDefinition) {

        count++;
        EntityInstance newEntityInstance = new EntityInstanceImpl(entityDefinition, count);
        instances.add(newEntityInstance);

        for (PropertyDefinition propertyDefinition : entityDefinition.getProps()) {
            Object value = propertyDefinition.generateValue();
            PropertyInstance newPropertyInstance = new PropertyInstanceImpl(propertyDefinition, value);
            newEntityInstance.addPropertyInstance(newPropertyInstance);
        }

        return newEntityInstance;
    }

    @Override
    public List<EntityInstance> getInstances() {
        return instances;
    }

    @Override
    public void killEntity(int id) {
        // some implementation...
    }
}
