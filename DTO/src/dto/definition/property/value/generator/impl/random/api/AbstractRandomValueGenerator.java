package dto.definition.property.value.generator.impl.random.api;



import dto.definition.property.value.generator.api.ValueGenerator;

import java.util.Random;

public abstract class AbstractRandomValueGenerator<T> implements ValueGenerator<T> {
    protected final Random random;

    protected AbstractRandomValueGenerator() {
        random = new Random();
    }
}
