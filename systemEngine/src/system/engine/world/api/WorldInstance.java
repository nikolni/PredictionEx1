package system.engine.world.api;

import system.engine.world.execution.instance.enitty.manager.api.EntityInstanceManager;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.rule.manager.api.RuleDefinitionManager;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

public interface WorldInstance {
    EntityInstanceManager getEntityInstanceManager();

    //RuleDefinitionManager getRuleDefinitionManager();

    //TerminationConditionsManager getTerminationConditionsManager();
}
