package system.engine.api;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

import java.util.Collection;
import java.util.List;
public interface SystemEngineAccess {

    List<EntityDefinition> getEntitiesDefinitionData();
    List<Rule> getRulesData();
    TerminationConditionsManager getTerminationConditionsManager();

    Collection<PropertyDefinition> getEnvironmentVar();


}
