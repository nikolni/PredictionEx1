package dto.definition.property.impl;

import dto.definition.property.api.AbstractPropertyDefinitionDTO;
import dto.definition.property.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;

public class FloatPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Float> {

    public FloatPropertyDefinitionDTO(String uniqueName, ValueGenerator<Float> valueGenerator) {
        super(uniqueName, Type.FLOAT, valueGenerator);
    }
}
