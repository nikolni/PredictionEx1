package dto.mapping.impl;

import dto.mapping.api.DataMenu2ForDTO;
import system.engine.api.SystemEngineAccess;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

import java.util.List;

public class DataMenu2ForDTOMenu2Impl implements DataMenu2ForDTO {
    @Override
    public List<EntityDefinition> getEntitiesDefinitionData(SystemEngineAccess systemEngineAccess) {
        return systemEngineAccess.getEntitiesDefinitionData();
    }
    @Override
    public List<Rule> getRulesData(SystemEngineAccess systemEngineAccess) {
        return systemEngineAccess.getRulesData();
    }

    @Override
    public TerminationConditionsManager getTerminationConditionsManager(SystemEngineAccess systemEngineAccess) {
        return systemEngineAccess.getTerminationConditionsManager();
    }
}
