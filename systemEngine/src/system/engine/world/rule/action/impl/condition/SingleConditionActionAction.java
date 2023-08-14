package system.engine.world.rule.action.impl.condition;

import system.engine.world.rule.action.impl.numeric.api.NumericVerify;
import system.engine.world.rule.context.Context;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.action.expression.api.Expression;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.enums.Type;

import static system.engine.world.creation.impl.expression.ExpressionCreationImpl.craeteExpression;

public class SingleConditionActionAction extends ConditionAction {

    private EntityDefinition entityDefinition;
    private final String propertyName;
    private final String expressionStr;
    private final String operator;

    public SingleConditionActionAction(EntityDefinition entityDefinitionParam1, EntityDefinition entityDefinitionParam2,
                                       String propertyNameParam, String operatorParam, String expressionParam) {
        super(entityDefinitionParam1);
        entityDefinition = entityDefinitionParam2;
        propertyName = propertyNameParam;
        operator = operatorParam;
        expressionStr =expressionParam;
    }


    @Override
    public void executeAction(Context context) {
        if (isConditionFulfilled(context)) {
            for (Action action : actionsCollection) {
                action.executeAction(context);
            }
        }
    }

    public boolean isConditionFulfilled(Context context) throws IllegalArgumentException{
        PropertyInstance propertyInstance = context.getPrimaryEntityInstance().getPropertyByName(propertyName);
        Expression expression = craeteExpression(expressionStr, context.getPrimaryEntityInstance(), propertyName);
        Object propertyValue = propertyInstance.getValue();
        Object expressionValue = expression.evaluateExpression(context);
        Type propertyType = propertyInstance.getPropertyDefinition().getType();

        if (!verifySuitableType(propertyType, expressionValue)) {
            throw new IllegalArgumentException("condition action can't operate with expression type different from type of property " + propertyName);
        }


        switch (operator) {
            case "=":
                return propertyValue ==  expressionValue;
            case "!=":
                return propertyValue !=  expressionValue;
            case "bt":
                return caseBT(propertyInstance, propertyValue, propertyType, expressionValue);
            case "lt":
                return caseLT(propertyInstance, propertyValue, propertyType, expressionValue);
        }
        return false;
    }


    private boolean caseBT(PropertyInstance propertyInstance, Object propertyValue,Type propertyType,
                           Object expressionValue) throws IllegalArgumentException {
        if (!NumericVerify.verifyNumericPropertyType(propertyInstance)) {
            throw new IllegalArgumentException("bt operator can't operate on a none number property " + propertyName);
        }

        switch (propertyType) {
            case DECIMAL:
                return (int) propertyValue > (int) expressionValue;
            case FLOAT:
                return (float) propertyValue > (float) expressionValue;
        }
        return false;
    }

    private boolean caseLT(PropertyInstance propertyInstance, Object propertyValue,Type propertyType,
                           Object expressionValue) throws IllegalArgumentException {
        if (!NumericVerify.verifyNumericPropertyType(propertyInstance)) {
            throw new IllegalArgumentException("lt operator can't operate on a none number property " + propertyName);
        }

        switch (propertyType) {
            case DECIMAL:
                return (int) propertyValue < (int) expressionValue;
            case FLOAT:
                return (float) propertyValue < (float) expressionValue;
        }
        return false;
    }

    private boolean verifySuitableType(Type propertyType, Object expressionVal) {
        switch (propertyType) {
            case DECIMAL:
                return (expressionVal instanceof Integer);
            case FLOAT:
                return (expressionVal instanceof Float | expressionVal instanceof Integer);
            case BOOLEAN:
                return (expressionVal instanceof Boolean | expressionVal instanceof String);
            case STRING:
                return (expressionVal instanceof String);
        }
        return false;
    }
}
