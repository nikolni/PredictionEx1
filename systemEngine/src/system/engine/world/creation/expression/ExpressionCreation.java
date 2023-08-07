package system.engine.world.creation.expression;

import system.engine.world.rule.action.expression.impl.ExpFreeValue;
import system.engine.world.rule.action.expression.impl.ExpFuncName;
import system.engine.world.rule.action.expression.impl.ExpPropName;
import system.engine.world.rule.action.expression.impl.Expression;
import system.engine.world.definition.entity.api.EntityDefinition;

public class ExpressionCreation {

    public static Expression craeteExpression(String actionType, String input, EntityDefinition entityDefinition, PropertyDefinition property) {
        String[] numAction = {"increase", "decrease","calculation", "divide", "ticks"};
        String[] boolAction = {"environment", "random","evaluate", "percent", "ticks"};
        String[] stringAction = {"environment", "random","evaluate", "percent", "ticks"};
        String argument = null;
        Expression expression = null;

        if((expression = createFuncExpression(input , entityDefinition, property)) == null){
            if((expression = createPropExpression(input, entityDefinition)) == null){
                //free value errors
                expression = new ExpFreeValue(input, entityDefinition);
            }

        }
        return expression;
    }

    public static Expression createFuncExpression(String input, EntityDefinition entityDefinition, PropertyDefinition property) {
        String[] allowedPrefixes = {"environment", "random","evaluate", "percent", "ticks"};
        String expressionStr = null;
        String argument = null;
        Expression expression = null;

        for (String prefix : allowedPrefixes) {
            if (input.startsWith(prefix + "(") && input.endsWith(")")) {
                expressionStr = prefix;
                argument = input.substring(prefix.length() + 1, input.length() - 1);
                expression = new ExpFuncName(prefix, entityDefinition, property, argument);
                break;
            }
        }
        return expression;
    }

    public static Expression createPropExpression(String input, EntityDefinition entityDefinition) {
        String expressionStr = input;
        Expression expression = null;

        if(entityDefinition.getSinglePropertyFromString(expressionStr) != null){
            expression = new ExpPropName(expressionStr, entityDefinition);
        }
        return expression;
    }


}
