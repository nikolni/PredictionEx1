package system.engine.world.rule.action.impl.numeric.impl;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.api.AbstractAction;
import system.engine.world.rule.action.api.ActionType;
import system.engine.world.rule.action.expression.api.Expression;
import system.engine.world.rule.action.impl.numeric.api.NumericVerify;
import system.engine.world.rule.context.Context;
import system.engine.world.rule.enums.Type;
import system.engine.world.execution.instance.property.api.PropertyInstance;

import static system.engine.world.creation.impl.expression.ExpressionCreationImpl.craeteExpression;


public class IncreaseAction extends AbstractAction implements NumericVerify {
    private final String propertyName;
    private final String expressionStr;

    public IncreaseAction(EntityDefinition entityDefinitionParam, String propertyNameParam, String expressionStrParam) {
        super(ActionType.INCREASE, entityDefinitionParam);
        propertyName = propertyNameParam;
        expressionStr =expressionStrParam;
    }

    @Override
    public void executeAction(Context context) {
        PropertyInstance propertyInstance = (context.getPrimaryEntityInstance()).getPropertyByName(propertyName);
        Expression expression = craeteExpression(expressionStr, context.getPrimaryEntityInstance(), propertyName);
        Type type = propertyInstance.getPropertyDefinition().getType();

        if (!NumericVerify.verifyNumericPropertyType(propertyInstance)){
            throw new IllegalArgumentException("increase action can't operate on a none number property [" + propertyName);
        }
        if (!NumericVerify.verifyNumericExpressionValue(expression, context) |
                !NumericVerify.verifySuitableType(type,expression, context) ) {
            throw new IllegalArgumentException("can't cast expression value to type of property [" + propertyName);
        }

        switch (type) {
            case DECIMAL:
                Integer i1 = Type.DECIMAL.convert(propertyInstance.getValue());
                Integer i2 = (Integer)(expression.evaluateExpression(context));
                propertyInstance.setValue(i1 + i2);
                break;
            case FLOAT:
                Float f1 = Type.FLOAT.convert(propertyInstance.getValue());
                Float f2 = (Float)(expression.evaluateExpression(context));
                propertyInstance.setValue(f1 + f2);
                break;
        }
    }


}