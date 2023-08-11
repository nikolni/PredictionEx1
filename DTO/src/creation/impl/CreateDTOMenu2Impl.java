package creation.impl;

import creation.api.CreateDTOMenu2;
import dto.api.DTOMenu2;
import dto.impl.DTOMenu2Impl;
import dto.mapping.api.DataMenu2ForDTO;
import dto.mapping.impl.DataMenu2ForDTOMenu2Impl;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.TerminationConditions;

import java.util.List;

public class CreateDTOMenu2Impl implements CreateDTOMenu2 {
    @Override
    public DTOMenu2 getDataForMenu2() {

        DataMenu2ForDTO dataMenu2ForDTO = new DataMenu2ForDTOMenu2Impl();   //systemEngineDTOInterface
        List<EntityDefinition> entities = dataMenu2ForDTO.getEntitiesDefinitionData();
        List<Rule> rules = dataMenu2ForDTO.getRulesData();
        TerminationConditions TerminationConditions = dataMenu2ForDTO.getTerminationConditions();
        return new DTOMenu2Impl(entities, rules, TerminationConditions);
    }
}
