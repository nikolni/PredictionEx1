package dto.definition.property.definition.impl;


import dto.definition.property.definition.api.AbstractPropertyDefinitionDTO;
import dto.definition.property.definition.value.generator.api.ValueGenerator;
import dto.definition.rule.enums.Type;

public class IntegerPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Integer> {

    public IntegerPropertyDefinitionDTO(String uniqueName, ValueGenerator<Integer> valueGenerator) {
        super(uniqueName, Type.DECIMAL, valueGenerator);
    }

}
