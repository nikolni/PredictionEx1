package dto.definition.property.api;

import system.engine.world.rule.enums.Type;

import java.util.List;

public interface PropertyDefinitionDTO {
    String getUniqueName();
    Type getType();

    Boolean doesHaveRange();
    List<Object> getRange();
    Boolean isRandomInitialized();
}