package dto.definition.property.definition.impl;

import dto.definition.property.definition.api.AbstractPropertyDefinitionDTO;import dto.definition.property.definition.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;
public class BooleanPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Boolean> {
    public BooleanPropertyDefinitionDTO(String uniqueName, ValueGenerator<Boolean> valueGenerator) {
        super(uniqueName, Type.BOOLEAN, valueGenerator);
    }
}
