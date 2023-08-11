package dto.api;

import dto.impl.DTOMenu2Impl;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.api.Rule;
import system.engine.world.rule.manager.api.RuleDefinitionManager;
import system.engine.world.termination.condition.TerminationConditions;

import java.util.List;

public interface DTOMenu2 {

    public List<EntityDefinition> getEntities();
    public List<Rule> getRules();
    public TerminationConditions getTerminationConditions();

}
