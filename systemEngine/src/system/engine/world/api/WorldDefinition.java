package system.engine.world.api;

import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.definition.environment.variable.api.EnvVariablesDefinitionManager;
import system.engine.world.impl.WorldInstance;
import system.engine.world.rule.manager.api.RuleDefinitionManager;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

public interface WorldDefinition {
    WorldInstance createWorldInstance();

    EntityDefinitionManager getEntityDefinitionManager();

    EnvVariablesDefinitionManager getEnvVariablesDefinitionManager();
    RuleDefinitionManager getRuleDefinitionManager();

    TerminationConditionsManager getTerminationConditionsManager();
}
