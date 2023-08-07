package system.engine.world.rule.action.impl.calculation;

import system.engine.world.rule.action.expression.impl.Expression;
import system.engine.world.definition.entity.api.EntityDefinition;

public class Multiply extends Calculation {
    public Multiply(String typeParam, EntityDefinition entityDefinitionParam, String propertyNameParam, Expression arg1Param, Expression arg2Param){
        super(typeParam, entityDefinitionParam, propertyNameParam, arg1Param, arg2Param);
    }

    @Override
    public void executeAction() {
        switch (resultProp.getPropertyTypeValue().getType()) {   //enum???
            case INT:
                resultProp.getPropertyTypeValue().setValue((int)((float)(arg1.evaluateExpression())*(float)(arg1.evaluateExpression())));
            break;
            case FLOAT:
                resultProp.getPropertyTypeValue().setValue(((float)(arg1.evaluateExpression())*(float)(arg1.evaluateExpression())));
            break;
            default:
                //errors
        }
    }
}
