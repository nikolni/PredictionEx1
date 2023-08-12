package ui;


import creation.impl.CreateDTOMenu2ForUiImpl;
import dto.api.DTOMenu2ForUi;
import dto.definition.entity.api.EntityDefinitionDTO;
import dto.definition.property.api.PropertyDefinitionDTO;
import dto.definition.rule.api.RuleDTO;
import dto.definition.termination.condition.api.TerminationConditionsDTO;
import dto.definition.termination.condition.impl.TicksTerminationConditionsDTOImpl;
import dto.definition.termination.condition.manager.api.TerminationConditionsDTOManager;
import system.engine.api.SystemEngineAccess;

import java.util.List;

public class Menu2 {
    public void showSimulationDetails(SystemEngineAccess systemEngineAccess){
        DTOMenu2ForUi dtoMenu2ForUi = new CreateDTOMenu2ForUiImpl().getDataForMenu2(systemEngineAccess);
        List<EntityDefinitionDTO> entities = dtoMenu2ForUi.getEntitiesDTO();
        List<RuleDTO> rules = dtoMenu2ForUi.getRulesDTO();
        TerminationConditionsDTOManager terminationConditionsDTOManager = dtoMenu2ForUi.getTerminationConditionsDTOManager();

        printEntitiesData(entities);
        printRulesData(rules);
        printTerminationConditionsData(terminationConditionsDTOManager);
    }

    private void printEntitiesData(List<EntityDefinitionDTO> entities){
        int countEntities = 0;
        int countProperties = 0;

        System.out.println("Entities:");
        for(EntityDefinitionDTO entityDefinitionDTO : entities){
            countEntities++;
            System.out.println("#" + countEntities + " name: " + entityDefinitionDTO.getUniqueName());
            System.out.println("  " + "population: " + entityDefinitionDTO.getPopulation());
            System.out.println("  " + "properties:");
            List<PropertyDefinitionDTO> properties = entityDefinitionDTO.getProps();
            printPropertiesData(properties);
        }
    }

    private void printPropertiesData(List<PropertyDefinitionDTO> properties){
        int countProperties = 0;

        for(PropertyDefinitionDTO propertyDefinitionDTO : properties){
            countProperties++;
            System.out.println("   #" + countProperties + " name: " + propertyDefinitionDTO.getUniqueName());
            System.out.println("     " + "type: " + propertyDefinitionDTO.getType());
            System.out.println("     " + "random initialize: " + propertyDefinitionDTO.isRandomInitialized());
            System.out.println("     " + (propertyDefinitionDTO.doesHaveRange() ? "range: from " +
                    propertyDefinitionDTO.getRange().get(0) + " to " + propertyDefinitionDTO.getRange().get(1) : "no range"));
        }
    }

    private void printRulesData(List<RuleDTO> rules){
        int countRules = 0;
        int countActions = 0;

        System.out.println("Rules:");
        for(RuleDTO ruleDTO : rules){
            countRules++;
            System.out.println("#" + countRules + " name: " + ruleDTO.getName());
            System.out.println("  " + "active at tick: " + ruleDTO.getActivation().getTicks() +
                    " and with probability of: " + ruleDTO.getActivation().getProbability());
            System.out.println("  " + "number of actions: " + ruleDTO.getNumOfActions());
            System.out.println("  " + "actions names:" + ruleDTO.getNumOfActions());
            countActions = 0;
            for(String actionName : ruleDTO.getActionsNames()){
                countActions++;
                System.out.println("  #" + countActions + " " + actionName);
            }
        }
    }

    private void printTerminationConditionsData(TerminationConditionsDTOManager terminationConditionsDTOManager){
        int countTerminationConditions = 0;

        System.out.println("Termination conditions:");
        for(TerminationConditionsDTO terminationConditionsDTO : terminationConditionsDTOManager.getTerminationConditionsDTOList()){
            System.out.println("#" + countTerminationConditions + (terminationConditionsDTO instanceof TicksTerminationConditionsDTOImpl?
                    "after " + terminationConditionsDTO.getTerminationCondition() + " seconds" : "after " +
                    terminationConditionsDTO.getTerminationCondition() + " ticks"));
        }
    }
}
