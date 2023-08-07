package system.engine.world.execution.instance.environment.impl;


import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.property.api.PropertyInstance;

import java.util.HashMap;
import java.util.Map;

public class EnvVariablesInstanceManagerImpl implements EnvVariablesInstanceManager {

    private final Map<String, PropertyInstance> envVariables;

    public EnvVariablesInstanceManagerImpl() {
        envVariables = new HashMap<>();
    }

    @Override
    public PropertyInstance getProperty(String name) {
        if (!envVariables.containsKey(name)) {
            throw new IllegalArgumentException("Can't find env variable with name " + name);
        }
        return envVariables.get(name);
    }

    @Override
    public void addPropertyInstance(PropertyInstance propertyInstance) {
        envVariables.put(propertyInstance.getPropertyDefinition().getUniqueName(), propertyInstance);
    }
}
