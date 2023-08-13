package dto.definition.property.definition.impl;

import dto.definition.property.definition.api.AbstractPropertyDefinitionDTO;
import dto.definition.property.definition.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;

public class FloatPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Float> {

    public FloatPropertyDefinitionDTO(String uniqueName, ValueGenerator<Float> valueGenerator) {
        super(uniqueName, Type.FLOAT, valueGenerator);
    }
}
