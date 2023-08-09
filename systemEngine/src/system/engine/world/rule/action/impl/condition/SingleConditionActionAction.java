package system.engine.world.rule.action.impl.condition;

import system.engine.world.rule.context.Context;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.action.expression.api.Expression;
import system.engine.world.definition.entity.api.EntityDefinition;

import static system.engine.world.creation.impl.expression.ExpressionCreationImpl.craeteExpression;

public class SingleConditionActionAction extends ConditionAction {

    private EntityDefinition entityDefinition;
    private String propertyName;
    private String expressionStr;
    private String operator;

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

    public boolean isConditionFulfilled(Context context){
        PropertyInstance propertyInstance = context.getPrimaryEntityInstance().getPropertyByName(propertyName);
        Expression expression = craeteExpression(expressionStr, context.getPrimaryEntityInstance(), propertyName);
        Object propertyValue = propertyInstance.getValue();
        Object expressionValue = expression.evaluateExpression(context);

        switch (operator) {
            case "=":
                return propertyValue ==  expressionValue;
            case "!=":
                return propertyValue !=  expressionValue;
            case "bt":
                return (float)propertyValue >  (float)expressionValue ;
            case "lt":
                return (float)propertyValue <  (float)expressionValue ;
            default:
                //errors
        }
        return false;
    }
}
