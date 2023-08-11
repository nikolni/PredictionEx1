package dto.definition.property.api;

import system.engine.world.definition.value.generator.api.ValueGenerator;
import system.engine.world.definition.value.generator.impl.random.api.AbstractRandomValueGenerator;
import system.engine.world.definition.value.generator.impl.random.impl.numeric.AbstractNumericRandomGenerator;
import system.engine.world.rule.enums.Type;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPropertyDefinitionDTO<T> implements PropertyDefinitionDTO {

    private final String uniqueName;
    private final Type propertyType;
    private final ValueGenerator<T> valueGenerator;

    public AbstractPropertyDefinitionDTO(String uniqueName, Type propertyType, ValueGenerator<T> valueGenerator) {
        this.uniqueName = uniqueName;
        this.propertyType = propertyType;
        this.valueGenerator = valueGenerator;
    }

    @Override
    public String getUniqueName() {
        return uniqueName;
    }

    @Override
    public Type getType() {
        return propertyType;
    }

    @Override
    public Boolean isRandomInitialized(){
        return this.valueGenerator instanceof AbstractRandomValueGenerator;
    }

    @Override
    public List<Object> getRange(){
        List<Object> rangeArray = new ArrayList<>();
        if(this.valueGenerator instanceof AbstractNumericRandomGenerator){
            AbstractNumericRandomGenerator NumericRandomGenerator =(AbstractNumericRandomGenerator) valueGenerator;
            rangeArray.add(NumericRandomGenerator.getFrom());
            rangeArray.add(NumericRandomGenerator.getTO());
        }
        return rangeArray;
    }

}
