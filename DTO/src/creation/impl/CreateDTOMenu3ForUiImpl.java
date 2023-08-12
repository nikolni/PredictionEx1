package creation.impl;

import creation.api.CreateDTOMenu3ForUi;
import dto.api.DTOMenu3ForUi;
import dto.definition.property.api.PropertyDefinitionDTO;
import dto.definition.property.impl.BooleanPropertyDefinitionDTO;
import dto.definition.property.impl.FloatPropertyDefinitionDTO;
import dto.definition.property.impl.IntegerPropertyDefinitionDTO;
import dto.definition.property.impl.StringPropertyDefinitionDTO;
import dto.impl.DTOMenu3ForUiImpl;
import system.engine.api.SystemEngineAccess;
import system.engine.world.definition.property.api.PropertyDefinition;

import java.util.ArrayList;
import java.util.List;

public class CreateDTOMenu3ForUiImpl implements CreateDTOMenu3ForUi {
    @Override
    public DTOMenu3ForUi getDataForMenu3(SystemEngineAccess systemEngineAccess) {
        List<PropertyDefinitionDTO> environmentVars= new ArrayList<>();

        for(PropertyDefinition environmentVar : systemEngineAccess.getEnvironmentVarDefinitions()){
            environmentVars.add(createEnvironmentVarDTO(environmentVar));
        }
        return new DTOMenu3ForUiImpl(environmentVars);
    }

    private PropertyDefinitionDTO createEnvironmentVarDTO(PropertyDefinition environmentVar){
        switch (environmentVar.getType()){
            case DECIMAL:
                return new IntegerPropertyDefinitionDTO(environmentVar.getUniqueName(), environmentVar.getValueGenerator());
            case FLOAT:
                return new FloatPropertyDefinitionDTO(environmentVar.getUniqueName(), environmentVar.getValueGenerator());
            case STRING:
                return new StringPropertyDefinitionDTO(environmentVar.getUniqueName(), environmentVar.getValueGenerator());
            case BOOLEAN:
                return new BooleanPropertyDefinitionDTO(environmentVar.getUniqueName(), environmentVar.getValueGenerator());
        }
        return null;
    }
}
