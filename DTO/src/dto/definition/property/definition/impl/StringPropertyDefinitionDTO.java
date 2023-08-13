package dto.definition.property.definition.impl;


import dto.definition.property.definition.api.AbstractPropertyDefinitionDTO;
import dto.definition.property.definition.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;

public class StringPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<String> {

    public StringPropertyDefinitionDTO(String uniqueName, ValueGenerator<String> valueGenerator) {
        super(uniqueName, Type.STRING, valueGenerator);
    }
}