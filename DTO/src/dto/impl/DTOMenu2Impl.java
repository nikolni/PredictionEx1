package dto.impl;

import dto.api.DTOMenu2;
import dto.mapping.api.DataMenu2ForDTO;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.api.Rule;
import system.engine.world.rule.manager.api.RuleDefinitionManager;
import system.engine.world.termination.condition.TerminationConditions;

import java.util.List;

public class DTOMenu2Impl implements DTOMenu2 {

        private List<EntityDefinition> entities;
        private List<Rule> rules;
        private TerminationConditions terminationConditions;


        public DTOMenu2Impl(List<EntityDefinition> entities, List<Rule> rules,
                            TerminationConditions terminationConditions){
                this.entities =entities;
                this.rules =rules;
                this.terminationConditions =terminationConditions;
        }

        public List<EntityDefinition> getEntities() {
                return entities;

        }

        public List<Rule> getRules() {
                return rules;
        }

        public TerminationConditions getTerminationConditions() {
                return terminationConditions;
        }
}
