package system.engine.world;

import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.definition.environment.variable.api.EnvVariablesDefinitionManager;

public class WorldDefinition {
    private EntityDefinitionManager entityDefinitionManager;
    private EnvVariablesDefinitionManager envVariablesDefinitionManager;

    public EntityDefinitionManager getEntityDefinitionManager() {
        return entityDefinitionManager;
    }

    public EnvVariablesDefinitionManager getEnvVariablesDefinitionManager() {
        return envVariablesDefinitionManager;
    }
}
