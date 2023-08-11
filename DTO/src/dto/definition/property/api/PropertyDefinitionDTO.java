package dto.definition.property.api;

import system.engine.world.rule.enums.Type;

import java.sql.Array;
import java.util.List;

public interface PropertyDefinitionDTO {
    String getUniqueName();
    Type getType();
    List<Object> getRange();
    Boolean isRandomInitialized();
}