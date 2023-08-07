package system.engine.world.definition.property.api;

import system.engine.world.definition.value.generator.api.ValueGenerator;
import system.engine.world.rule.enums.Type;

public abstract class AbstractPropertyDefinition<T> implements PropertyDefinition {

    private final String uniqueName;
    private final Type propertyType;
    private final ValueGenerator<T> valueGenerator;

    public AbstractPropertyDefinition(String uniqueName, Type propertyType, ValueGenerator<T> valueGenerator) {
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
    public T generateValue() {
        return valueGenerator.generateValue();
    }
}
