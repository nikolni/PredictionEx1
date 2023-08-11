package dto.definition.property.impl;


import dto.definition.property.api.AbstractPropertyDefinitionDTO;
import system.engine.world.definition.value.generator.api.ValueGenerator;
import system.engine.world.rule.enums.Type;

public class StringPropertyDefinitionDTO extends AbstractPropertyDefinitionDTO<String> {

    public StringPropertyDefinitionDTO(String uniqueName, ValueGenerator<String> valueGenerator) {
        super(uniqueName, Type.STRING, valueGenerator);
    }
}