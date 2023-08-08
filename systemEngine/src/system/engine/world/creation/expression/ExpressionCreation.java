package system.engine.world.creation.expression;

import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.rule.action.expression.api.Expression;
import system.engine.world.rule.action.expression.impl.ExpFreeValue;
import system.engine.world.rule.action.expression.impl.ExpFuncName;
import system.engine.world.rule.action.expression.impl.ExpPropName;
import system.engine.world.rule.action.expression.api.AbstractExpressionImpl;
import system.engine.world.definition.entity.api.EntityDefinition;

public class ExpressionCreation {

    public static Expression craeteExpression(String expressionStr, EntityInstance entityInstance, String propertyName) {
        String[] numAction = {"increase", "decrease","calculation", "divide", "ticks"};
        String[] boolAction = {"environment", "random","evaluate", "percent", "ticks"};
        String[] stringAction = {"environment", "random","evaluate", "percent", "ticks"};
        String argument = null;
        Expression expression = null;

        if((expression = createFuncExpression(expressionStr , entityInstance, propertyName)) == null){
            if((expression = createPropExpression(expressionStr, entityInstance, propertyName)) == null){
                //free value errors
                expression = new ExpFreeValue(expressionStr, entityInstance);
            }

        }
        return expression;
    }

    public static Expression createFuncExpression(String expressionStr, EntityInstance entityInstance, String propertyName) {
        String[] allowedPrefixes = {"environment", "random","evaluate", "percent", "ticks"};
        String funcNameStr = null;
        String argument = null;
        Expression expression = null;

        for (String prefix : allowedPrefixes) {
            if (expressionStr.startsWith(prefix + "(") && expressionStr.endsWith(")")) {
                funcNameStr = prefix;
                argument = expressionStr.substring(prefix.length() + 1, expressionStr.length() - 1);
                expression = new ExpFuncName(funcNameStr, entityInstance, propertyName, argument);
                break;
            }
        }
        return expression;
    }

    public static Expression createPropExpression(String expressionAtr, EntityInstance entityInstance, String propertyName) {
        String property = expressionAtr;
        Expression expression = null;

        if(entityInstance.getPropertyByName(propertyName) != null){
            expression = new ExpPropName(property, entityInstance, propertyName);
        }
        return expression;
    }
}
