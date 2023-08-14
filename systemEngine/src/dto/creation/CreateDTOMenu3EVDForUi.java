package dto.creation;

import dto.api.DTOMenu3ForUiEVD;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.definition.property.definition.impl.PropertyDefinitionDTOImpl;
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
        return  new PropertyDefinitionDTOImpl(environmentVar.getUniqueName(), environmentVar.getType().toString(),
                environmentVar.isRandomInitialized(), environmentVar.doesHaveRange(), environmentVar.getRange());
    }
}
