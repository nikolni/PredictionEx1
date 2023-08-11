package dto.mapping.api;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.TerminationConditions;

import java.util.List;

public interface DataMenu2ForDTO {
    List<EntityDefinition> getEntitiesDefinitionData();
    List<Rule> getRulesData();
    TerminationConditions getTerminationConditions();
}
