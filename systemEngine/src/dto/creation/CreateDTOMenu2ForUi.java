package dto.creation;

import dto.api.DTODefinitionsForUi;
import dto.definition.entity.api.EntityDefinitionDTO;
import dto.definition.entity.impl.EntityDefinitionDTOImpl;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.definition.property.definition.impl.PropertyDefinitionDTOImpl;
import dto.definition.rule.activation.impl.ActivationDTOImpl;
import dto.definition.rule.api.RuleDTO;
import dto.definition.rule.impl.RuleDTOImpl;
import dto.definition.termination.condition.api.TerminationConditionsDTO;
import dto.definition.termination.condition.impl.TicksTerminationConditionsDTOImpl;
import dto.definition.termination.condition.impl.TimeTerminationConditionsDTOImpl;
import dto.definition.termination.condition.manager.api.TerminationConditionsDTOManager;
import dto.definition.termination.condition.manager.impl.TerminationConditionsDTOManagerImpl;
import dto.impl.DTODefinitionsForUiImpl;
import system.engine.world.api.WorldDefinition;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.api.TerminationCondition;
import system.engine.world.termination.condition.impl.TicksTerminationConditionImpl;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

import java.util.ArrayList;
import java.util.List;

public class CreateDTOMenu2ForUi {

    public DTODefinitionsForUi getDataForMenu2(WorldDefinition worldDefinition) {
        List<EntityDefinitionDTO> entitiesDTO = new ArrayList<>();
        List<RuleDTO> rulesDTO = new ArrayList<>();
        List<TerminationConditionsDTO> terminationConditionsDTO= new ArrayList<>();

        List<EntityDefinition> entities = worldDefinition.getEntityDefinitionManager().getDefinitions();
        for(EntityDefinition entityDefinition: entities){
            entitiesDTO.add(createEntityDefinitionDTO(entityDefinition));
        }

        List<Rule> rules = worldDefinition.getRuleDefinitionManager().getDefinitions();
        for(Rule rule: rules){
            rulesDTO.add(new RuleDTOImpl(rule.getName(), rule.getActionsNames(),
                    new ActivationDTOImpl(rule.getActivation().getTicks(), rule.getActivation().getProbability())));
        }

        TerminationConditionsManager terminationConditionsManager = worldDefinition.getTerminationConditionsManager();
        for(TerminationCondition terminationCondition : terminationConditionsManager.getTerminationConditionsList()){
            terminationConditionsDTO.add(createTerminationConditionsDTO(terminationCondition));
        }
        TerminationConditionsDTOManager terminationConditionsDTOManager = new TerminationConditionsDTOManagerImpl(terminationConditionsDTO);

        return new DTODefinitionsForUiImpl(entitiesDTO, rulesDTO, terminationConditionsDTOManager);
    }

    private EntityDefinitionDTO createEntityDefinitionDTO(EntityDefinition entityDefinition){
        List<PropertyDefinitionDTO> propertiesDTO = new ArrayList<>();
        for(PropertyDefinition propertyDefinition: entityDefinition.getProps()){
            propertiesDTO.add(createPropertyDefinitionDTO(propertyDefinition));
        }
        return new EntityDefinitionDTOImpl(entityDefinition.getUniqueName(), entityDefinition.getPopulation(), propertiesDTO);
    }

    private PropertyDefinitionDTO createPropertyDefinitionDTO(PropertyDefinition propertyDefinition){
        return  new PropertyDefinitionDTOImpl(propertyDefinition.getUniqueName(), propertyDefinition.getType().toString(),
                propertyDefinition.isRandomInitialized(), propertyDefinition.doesHaveRange(), propertyDefinition.getRange());
    }

    private TerminationConditionsDTO createTerminationConditionsDTO (TerminationCondition terminationCondition){
        if(terminationCondition instanceof TicksTerminationConditionImpl){
            return new TicksTerminationConditionsDTOImpl(terminationCondition.getTerminationCondition());
        }
        else{
            return new TimeTerminationConditionsDTOImpl(terminationCondition.getTerminationCondition());
        }
    }

}
