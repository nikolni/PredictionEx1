package dto.definition.environment.variable.impl;

import dto.definition.environment.variable.api.EnvVariablesDefinitionDTOManager;
import dto.definition.property.api.PropertyDefinitionDTO;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.environment.impl.EnvVariablesInstanceManagerImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EnvVariableDefinitionDTOManagerImpl implements EnvVariablesDefinitionDTOManager {

    private final Map<String, PropertyDefinitionDTO> propNameToPropDefinitionDTO;

    public EnvVariableDefinitionDTOManagerImpl(Map<String, PropertyDefinitionDTO> propNameToPropDefinitionDTO) {
        this.propNameToPropDefinitionDTO = propNameToPropDefinitionDTO;
    }

    @Override
    public Collection<PropertyDefinitionDTO> getEnvVariables() {
        return propNameToPropDefinitionDTO.values();
    }
}
