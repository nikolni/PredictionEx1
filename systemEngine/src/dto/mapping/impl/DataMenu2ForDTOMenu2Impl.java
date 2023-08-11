package dto.mapping.impl;

import dto.mapping.api.DataMenu2ForDTO;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.TerminationConditions;

import java.util.List;

public class DataMenu2ForDTOMenu2Impl implements DataMenu2ForDTO {
    @Override
    public List<EntityDefinition> getEntitiesDefinitionData() {
        return null;
    }
    @Override
    public List<Rule> getRulesData() {
        return null;
    }

    @Override
    public TerminationConditions getTerminationConditions() {
        return null;
    }

    public PropertyDefinition getPropertyDefinitionData() {
        return null;
    }
    public Action getActionData() {
        return null;
    }
}
