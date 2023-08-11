package system.engine.world.rule.action.expression.impl;

import system.engine.world.rule.context.Context;
import system.engine.world.rule.enums.Type;
import system.engine.world.definition.value.generator.impl.random.impl.numeric.RandomFloatGenerator;
import system.engine.world.definition.value.generator.impl.random.impl.numeric.RandomIntegerGenerator;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.action.expression.api.AbstractExpressionImpl;

import java.util.Arrays;
import java.util.List;


public class ExpFuncName extends AbstractExpressionImpl {

    private final List<String> functionArgs;
    private final String propertyName;

    public ExpFuncName(String expressionStrParam, EntityInstance entityInstanceParam, String propertyNameParam, String... strings) {
        super(expressionStrParam, entityInstanceParam);
        functionArgs = Arrays.asList(strings);
        propertyName = propertyNameParam;
    }

    @Override
    public Object evaluateExpression(Context context) {
        switch (expressionStr) {
            case "environment":
                return environment(context.getEnvironmentVariable(functionArgs.get(0)));
            case "random":
                return random(functionArgs.get(0));
        }
        return null;
    }

    private Object environment(PropertyInstance environmentVariable) {
        return environmentVariable.getValue();
    }

    private Object random(String num) {
        int number = Integer.parseInt(num);   //throws
        PropertyInstance propertyInstance = entityInstance.getPropertyByName(propertyName);
        Type type = propertyInstance.getPropertyDefinition().getType();

        switch (type) {
            case DECIMAL:
                return (new RandomIntegerGenerator(0, number)).generateValue();
            case FLOAT:
                return (new RandomFloatGenerator((float) 0, (float) number)).generateValue();
        }

        return null;
    }

    /*private Object evaluate(String propertyName) {
        return property.getPropertyTypeValue().getSecond();
    }

    private float percent(Expression num, Expression percent) {
        float percentage;
        if(num instanceof ExpFreeValue && percent instanceof ExpFreeValue) {
            percentage = (((float)(percent.evaluateExpression())) * 100) /((float) num.evaluateExpression());
            return percentage;
        }
        else{

        }
    }

    private Object ticks(EnvironmentVariable) {

    }*/
}