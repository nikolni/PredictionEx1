package dto.definition.property.impl;

import dto.definition.property.api.AbstractPropertyDefinitionDTO;
import system.engine.world.definition.value.generator.api.ValueGenerator;
import system.engine.world.rule.enums.Type;

public class BooleanPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Boolean> {
    public BooleanPropertyDefinitionDTO(String uniqueName, ValueGenerator<Boolean> valueGenerator) {
        super(uniqueName, Type.BOOLEAN, valueGenerator);
    }
}
