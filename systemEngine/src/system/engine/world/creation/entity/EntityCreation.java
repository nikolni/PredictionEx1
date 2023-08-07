package system.engine.world.creation.entity;

import system.engine.world.definition.entity.api.EntityDefinition;

import java.util.Map;

public class EntityCreation {

    public static EntityDefinition createEntity(String entityNameParam, int numberOfInstancesParam, Map<String, PropertyDefinition> propertiesCollectionParam ) {
        return new EntityDefinition(entityNameParam, numberOfInstancesParam, propertiesCollectionParam);
    }
}
