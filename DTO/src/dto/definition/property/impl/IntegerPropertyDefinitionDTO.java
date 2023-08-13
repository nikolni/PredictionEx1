package dto.definition.property.impl;


import dto.definition.property.api.AbstractPropertyDefinitionDTO;
import dto.definition.property.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;

public class IntegerPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Integer> {

    public IntegerPropertyDefinitionDTO(String uniqueName, ValueGenerator<Integer> valueGenerator) {
        super(uniqueName, Type.DECIMAL, valueGenerator);
    }

}
