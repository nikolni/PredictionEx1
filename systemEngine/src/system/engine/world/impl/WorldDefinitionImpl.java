package system.engine.world.impl;

import system.engine.world.api.WorldDefinition;
import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.definition.environment.variable.api.EnvVariablesDefinitionManager;
import system.engine.world.rule.manager.api.RuleDefinitionManager;

public class WorldDefinitionImpl implements WorldDefinition {
    private EntityDefinitionManager entityDefinitionManager;
    private EnvVariablesDefinitionManager envVariablesDefinitionManager;
    private RuleDefinitionManager ruleDefinitionManager;

    public WorldDefinitionImpl(EntityDefinitionManager entityDefinitionManager,
                               EnvVariablesDefinitionManager envVariablesDefinitionManager,
                               RuleDefinitionManager ruleDefinitionManager){
        this.entityDefinitionManager = entityDefinitionManager;
        this.envVariablesDefinitionManager = envVariablesDefinitionManager;
        this.ruleDefinitionManager = ruleDefinitionManager;
    }

    public EntityDefinitionManager getEntityDefinitionManager() {
        return entityDefinitionManager;
    }

    public EnvVariablesDefinitionManager getEnvVariablesDefinitionManager() {
        return envVariablesDefinitionManager;
    }

    @Override
    public WorldInstance createWorldInstance() {
        return new WorldInstance(this);
    }
}
