package dto.mapping.api;

import system.engine.api.SystemEngineAccess;
import system.engine.world.definition.property.api.PropertyDefinition;

import java.util.Collection;
import java.util.List;

public interface DataMenu3ForDTO {
    Collection<PropertyDefinition> getEnvironmentVars(SystemEngineAccess systemEngineAccess);
}
