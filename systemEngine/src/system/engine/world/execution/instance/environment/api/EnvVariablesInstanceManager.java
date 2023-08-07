package system.engine.world.execution.instance.environment.api;


import system.engine.world.execution.instance.property.api.PropertyInstance;

public interface EnvVariablesInstanceManager {
    PropertyInstance getProperty(String name);
    void addPropertyInstance(PropertyInstance propertyInstance);
}
