package dto.definition.property.impl;

import dto.definition.property.api.AbstractPropertyDefinitionDTO;
import system.engine.world.definition.value.generator.api.ValueGenerator;
import system.engine.world.rule.enums.Type;

public class FloatPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Float> {

    public FloatPropertyDefinitionDTO(String uniqueName, ValueGenerator<Float> valueGenerator) {
        super(uniqueName, Type.FLOAT, valueGenerator);
    }
}
