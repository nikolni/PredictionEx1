package system.engine.world.execution.instance.enitty.api;


import system.engine.world.execution.instance.property.api.PropertyInstance;

public interface EntityInstance {
    int getId();
    PropertyInstance getPropertyByName(String name);
    void addPropertyInstance(PropertyInstance propertyInstance);
}
