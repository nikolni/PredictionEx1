package dto.definition.property.impl;


import dto.definition.property.api.AbstractPropertyDefinitionDTO;
import system.engine.world.definition.value.generator.api.ValueGenerator;
import system.engine.world.rule.enums.Type;

public class IntegerPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<Integer> {

    public IntegerPropertyDefinitionDTO(String uniqueName, ValueGenerator<Integer> valueGenerator) {
        super(uniqueName, Type.DECIMAL, valueGenerator);
    }

}
