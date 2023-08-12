package dto.impl;

import dto.api.DTOMenu3ForUi;
import dto.definition.property.api.PropertyDefinitionDTO;

import java.util.List;

public class DTOMenu3ForUiImpl implements DTOMenu3ForUi {

    private final List<PropertyDefinitionDTO> environmentVars;

    public DTOMenu3ForUiImpl(List<PropertyDefinitionDTO> environmentVars){
        this.environmentVars = environmentVars;
    }

    @Override
    public List<PropertyDefinitionDTO> getEnvironmentVars() {
        return environmentVars;
    }
}
