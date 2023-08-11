package dto.mapping.api;

import system.engine.api.SystemEngineAccess;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

import java.util.List;

public interface DataMenu2ForDTO {
    List<EntityDefinition> getEntitiesDefinitionData(SystemEngineAccess systemEngineAccess);
    List<Rule> getRulesData(SystemEngineAccess systemEngineAccess);
    TerminationConditionsManager getTerminationConditionsManager(SystemEngineAccess systemEngineAccess);
}
