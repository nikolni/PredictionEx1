package system.engine.world.rule.action.impl.condition;

import system.engine.world.rule.action.expression.impl.Expression;
import system.engine.world.rule.action.impl.Action;
import system.engine.world.definition.entity.api.EntityDefinition;

import java.util.List;

public class SingleCondition extends Condition{

    private EntityDefinition entityDefinition;
    private PropertyDefinition property;
    private String operator;
    private Expression expression;

    public SingleCondition(String typeParam, EntityDefinition entityDefinitionParam, String propertyNameParam, String operatorParam,
                           List<Action> actionsCollectionParam, Expression expressionParam) {
        super(typeParam, entityDefinitionParam, actionsCollectionParam);
        entityDefinition = super.entityDefinition;
        property = property = entityDefinition.getSinglePropertyFromString(propertyNameParam);
        operator = operatorParam;
        expression =expressionParam;
    }


    @Override
    public void executeAction() {
        if(isConditionFulfilled()){
            for(Action action: actionsCollection){
                action.executeAction();
            }
        }


    }

    public boolean isConditionFulfilled(){
        Object propertyValue = property.getPropertyTypeValue().getSecond();
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
