package dto.definition.property.definition.value.generator.impl.random.api;



import dto.definition.property.definition.value.generator.api.ValueGenerator;

import java.util.Random;

public abstract class AbstractRandomValueGenerator<T> implements ValueGenerator<T> {
    protected final Random random;

    protected AbstractRandomValueGenerator() {
        random = new Random();
    }
}
