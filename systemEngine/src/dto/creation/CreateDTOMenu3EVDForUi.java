package dto.creation;

import dto.api.DTOMenu3ForUiEVD;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.definition.property.definition.impl.BooleanPropertyDefinitionDTO;
import dto.definition.property.definition.impl.FloatPropertyDefinitionDTO;
import dto.definition.property.definition.impl.IntegerPropertyDefinitionDTO;
import dto.definition.property.definition.impl.StringPropertyDefinitionDTO;
import dto.definition.property.definition.value.generator.api.ValueGenerator;
import dto.impl.DTOMenu3ForUiEVDImpl;
import system.engine.world.api.WorldDefinition;
import system.engine.world.definition.property.api.PropertyDefinition;

import java.util.ArrayList;
import java.util.List;

public class CreateDTOMenu3EVDForUi {

    public DTOMenu3ForUiEVD getDataForMenu3(WorldDefinition worldDefinition) {
        List<PropertyDefinitionDTO> environmentVars= new ArrayList<>();

        for(PropertyDefinition environmentVar : worldDefinition.getEnvVariablesDefinitionManager().getEnvVariables()){
            environmentVars.add(createEnvironmentVarDTO(environmentVar));
        }
        return new DTOMenu3ForUiEVDImpl(environmentVars);
    }

    private PropertyDefinitionDTO createEnvironmentVarDTO(PropertyDefinition environmentVar){
        switch (environmentVar.getType()){
            case DECIMAL:
                return new IntegerPropertyDefinitionDTO(environmentVar.getUniqueName(), (ValueGenerator<Integer>) environmentVar.getValueGenerator());
            case FLOAT:
                return new FloatPropertyDefinitionDTO(environmentVar.getUniqueName(), (ValueGenerator<Float>) environmentVar.getValueGenerator());
            case STRING:
                return new StringPropertyDefinitionDTO(environmentVar.getUniqueName(), (ValueGenerator<String>) environmentVar.getValueGenerator());
            case BOOLEAN:
                return new BooleanPropertyDefinitionDTO(environmentVar.getUniqueName(), (ValueGenerator<Boolean>) environmentVar.getValueGenerator());
        }
        return null;
    }
}
