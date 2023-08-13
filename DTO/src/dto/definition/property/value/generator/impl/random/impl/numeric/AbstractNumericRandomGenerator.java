package dto.definition.property.value.generator.impl.random.impl.numeric;


import dto.definition.property.value.generator.impl.random.api.AbstractRandomValueGenerator;

public abstract class AbstractNumericRandomGenerator<T> extends AbstractRandomValueGenerator<T> {

    protected final T from;
    protected final T to;

    protected AbstractNumericRandomGenerator(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public T getFrom(){return from;}
    public T getTO(){return to;}

}
