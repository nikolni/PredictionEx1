package system.engine.world.rule.action.impl.numeric.api;

import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.action.expression.api.Expression;
import system.engine.world.rule.enums.Type;

public interface NumericVerify {
    default boolean verifyNumericPropertyType(PropertyInstance propertyValue) {
        return
                Type.DECIMAL.equals(propertyValue.getPropertyDefinition().getType()) || Type.FLOAT.equals(propertyValue.getPropertyDefinition().getType());
    }

    default boolean verifyNumericExpressionValue(Expression expression) {
        return ((expression.evaluateExpression()) instanceof Integer) | ((expression.evaluateExpression()) instanceof Float);
    }
}
