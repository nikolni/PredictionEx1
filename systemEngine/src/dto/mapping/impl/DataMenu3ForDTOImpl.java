package dto.mapping.impl;

import dto.mapping.api.DataMenu3ForDTO;
import system.engine.api.SystemEngineAccess;
import system.engine.world.definition.property.api.PropertyDefinition;

import java.util.Collection;

public class DataMenu3ForDTOImpl implements DataMenu3ForDTO {
    @Override
    public Collection<PropertyDefinition> getEnvironmentVars(SystemEngineAccess systemEngineAccess) {
        return systemEngineAccess.getEnvironmentVarDefinitions();
    }
}
