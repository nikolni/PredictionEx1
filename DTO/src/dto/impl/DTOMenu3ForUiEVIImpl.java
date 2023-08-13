package dto.impl;

import dto.api.DTOMenu3ForUiEVI;
import dto.definition.property.instance.api.PropertyInstanceDTO;

import java.util.List;

public class DTOMenu3ForUiEVIImpl implements DTOMenu3ForUiEVI {
    private final List<PropertyInstanceDTO> environmentVars;

    public DTOMenu3ForUiEVIImpl(List<PropertyInstanceDTO> environmentVars){
        this.environmentVars = environmentVars;
    }

    @Override
    public List<PropertyInstanceDTO> getEnvironmentVars() {
        return environmentVars;
    }
}
