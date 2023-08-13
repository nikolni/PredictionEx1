package dto.creation;

import dto.api.DTOMenu3ForUiEVD;
import dto.api.DTOMenu3ForUiEVI;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.definition.property.definition.impl.BooleanPropertyDefinitionDTO;
import dto.definition.property.definition.impl.FloatPropertyDefinitionDTO;
import dto.definition.property.definition.impl.IntegerPropertyDefinitionDTO;
import dto.definition.property.definition.impl.StringPropertyDefinitionDTO;
import dto.definition.property.definition.value.generator.api.ValueGenerator;
import dto.definition.property.instance.api.PropertyInstanceDTO;
import dto.definition.property.instance.impl.PropertyInstanceDTOImpl;
import dto.impl.DTOMenu3ForUiEVDImpl;
import dto.impl.DTOMenu3ForUiEVIImpl;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.property.api.PropertyInstance;

import java.util.ArrayList;
import java.util.List;

public class CreateDTOMenu3EVIForUi {


    public DTOMenu3ForUiEVI getDataForMenu3(EnvVariablesInstanceManager envVariablesInstanceManager) {
        List<PropertyInstanceDTO> environmentVars= new ArrayList<>();

        for(PropertyInstance environmentVar : envVariablesInstanceManager.getEnvVarsList()){
            environmentVars.add(createEnvironmentVarDTO(environmentVar));
        }
        return new DTOMenu3ForUiEVIImpl(environmentVars);
    }

    private PropertyInstanceDTO createEnvironmentVarDTO(PropertyInstance environmentVar){
        PropertyDefinitionDTO propertyDefinitionDTO = createEnvironmentVarDTO (environmentVar.getPropertyDefinition());
        return new PropertyInstanceDTOImpl(propertyDefinitionDTO, environmentVar.getValue());
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
