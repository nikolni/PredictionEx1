package system.engine.world.rule.action.expression.impl;

import system.engine.world.general.random.RandomInitialize;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.environment.variable.EnvironmentVariable;

import java.util.Arrays;
import java.util.List;

import static system.engine.world.WorldInstance.getSingleEnvironmentVariableFromString;


public class ExpFuncName extends Expression {

    private List<String> functionArgs;
    private PropertyDefinition property;

    public ExpFuncName(String expressionStrParam, EntityDefinition entityDefinitionParam, PropertyDefinition propertyParam, String... strings) {
        super(expressionStrParam, entityDefinitionParam);
        functionArgs = Arrays.asList(strings);
        property = propertyParam;
    }

    @Override
    public Object evaluateExpression() {
        switch (expressionStr) {
            case "environment":
                return environment(getSingleEnvironmentVariableFromString(functionArgs.get(0)));
            case "random":
                return random(Integer.parseInt(functionArgs.get(0)));
        }
        return null;
    }

    private Object environment(EnvironmentVariable environmentVariable) {
        return environmentVariable.getEnvironmentVariableTypeValue().getSecond();
    }

    private Object random(int num) {
        RandomInitialize randomInitialize=new RandomInitialize();

        switch (property.getPropertyTypeValue().getType()) {   //enum???
            case INT:
                return randomInitialize.intRandomInitialize(num);
            case FLOAT:
                return randomInitialize.floatRandomInitialize(num);
            default:
                //errors
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