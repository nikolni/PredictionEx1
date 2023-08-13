package dto.definition.property.impl;

import dto.definition.property.api.AbstractPropertyDefinitionDTO;import dto.definition.property.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;
public class BooleanPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Boolean> {
    public BooleanPropertyDefinitionDTO(String uniqueName, ValueGenerator<Boolean> valueGenerator) {
        super(uniqueName, Type.BOOLEAN, valueGenerator);
    }
}
