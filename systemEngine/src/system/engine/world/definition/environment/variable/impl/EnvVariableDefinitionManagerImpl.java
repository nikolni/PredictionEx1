package system.engine.world.definition.environment.variable.impl;

import system.engine.world.definition.environment.variable.api.EnvVariablesDefinitionManager;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.environment.impl.EnvVariablesInstanceManagerImpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnvVariableDefinitionManagerImpl implements EnvVariablesDefinitionManager {

    private final Map<String, PropertyDefinition> propNameToPropDefinition;

    public EnvVariableDefinitionManagerImpl() {
        propNameToPropDefinition = new HashMap<>();
    }

    @Override
    public void addEnvironmentVariable(PropertyDefinition propertyDefinition) {
        propNameToPropDefinition.put(propertyDefinition.getUniqueName(), propertyDefinition);
    }

    @Override
    public EnvVariablesInstanceManager createEnvironmentVarInstanceManager() {
        return new EnvVariablesInstanceManagerImpl(this);
    }

    @Override
    public Collection<PropertyDefinition> getEnvVariables() {
        return propNameToPropDefinition.values();
    }
}
