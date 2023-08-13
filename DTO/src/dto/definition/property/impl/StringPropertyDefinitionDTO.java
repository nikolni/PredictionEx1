package dto.definition.property.impl;


import dto.definition.property.api.AbstractPropertyDefinitionDTO;
import dto.definition.property.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;

public class StringPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<String> {

    public StringPropertyDefinitionDTO(String uniqueName, ValueGenerator<String> valueGenerator) {
        super(uniqueName, Type.STRING, valueGenerator);
    }
}