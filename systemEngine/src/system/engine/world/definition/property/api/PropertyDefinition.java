package system.engine.world.definition.property.api;

import system.engine.world.rule.enums.Type;

public interface PropertyDefinition {
    String getUniqueName();
    Type getType();
    Object generateValue();
}