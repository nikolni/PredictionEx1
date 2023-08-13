package dto.impl;

import dto.api.DTOMenu3ForUiEVD;
import dto.definition.property.definition.api.PropertyDefinitionDTO;

import java.util.List;

public class DTOMenu3ForUiEVDImpl implements DTOMenu3ForUiEVD {

    private final List<PropertyDefinitionDTO> environmentVars;

    public DTOMenu3ForUiEVDImpl(List<PropertyDefinitionDTO> environmentVars){
        this.environmentVars = environmentVars;
    }

    @Override
    public List<PropertyDefinitionDTO> getEnvironmentVars() {
        return environmentVars;
    }
}
