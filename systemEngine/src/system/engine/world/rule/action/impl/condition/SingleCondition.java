package system.engine.world.rule.action.impl.condition;

import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.action.expression.api.Expression;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.context.Context;

import java.util.List;

import static system.engine.world.creation.expression.ExpressionCreation.craeteExpression;

public class SingleCondition extends Condition{

    private EntityDefinition entityDefinition;
    private String propertyName;
    private String expressionStr;
    private String operator;

    public SingleCondition(EntityDefinition entityDefinitionParam, String propertyNameParam, String operatorParam,
                           List<Action> actionsCollectionParam, String expressionParam) {
        super(entityDefinitionParam, actionsCollectionParam);
        entityDefinition = super.getContextEntity();
        propertyName = propertyNameParam;
        operator = operatorParam;
        expressionStr =expressionParam;
    }


    @Override
    public void executeAction(Context context) {
        if (isConditionFulfilled(entityInstance)) {
            for (Action action : actionsCollection) {
                action.executeAction(entityInstance);
            }
        }
    }

    public boolean isConditionFulfilled(EntityInstance entityInstance){
        PropertyInstance propertyInstance = entityInstance.getPropertyByName(propertyName);
        Expression expression = craeteExpression(expressionStr, entityInstance, propertyName);
        Object propertyValue = propertyInstance.getValue();
        Object expressionValue = expression.evaluateExpression();

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
