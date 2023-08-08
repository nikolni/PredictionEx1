package system.engine.world.definition.value.generator.api;


import system.engine.world.definition.value.generator.impl.init.InitValueGenerator;
import system.engine.world.definition.value.generator.impl.random.impl.bool.RandomBooleanValueGenerator;
import system.engine.world.definition.value.generator.impl.random.impl.numeric.RandomFloatGenerator;
import system.engine.world.definition.value.generator.impl.random.impl.numeric.RandomIntegerGenerator;
import system.engine.world.definition.value.generator.impl.random.impl.string.RandomStringGenerator;

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
