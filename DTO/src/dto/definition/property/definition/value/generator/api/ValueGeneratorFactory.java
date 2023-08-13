package dto.definition.property.definition.value.generator.api;


import dto.definition.property.definition.value.generator.impl.init.InitValueGenerator;
import dto.definition.property.definition.value.generator.impl.random.impl.bool.RandomBooleanValueGenerator;
import dto.definition.property.definition.value.generator.impl.random.impl.numeric.RandomFloatGenerator;
import dto.definition.property.definition.value.generator.impl.random.impl.string.RandomStringGenerator;
import dto.definition.property.definition.value.generator.impl.random.impl.numeric.RandomIntegerGenerator;

public interface ValueGeneratorFactory {

    static <T> ValueGenerator<T> createFixed(T value) {
        return new InitValueGenerator<>(value);
    }

    static ValueGenerator<Boolean> createRandomBoolean() {
        return new RandomBooleanValueGenerator();
    }

    static ValueGenerator<Integer> createRandomInteger(Integer from, Integer to) {
        return new RandomIntegerGenerator(from, to);
    }

    static ValueGenerator<Float> createRandomFloat(Float from, Float to) {
        return new RandomFloatGenerator(from, to);
    }

    static ValueGenerator<String> createRandomString() {
        return new RandomStringGenerator();
    }
}
