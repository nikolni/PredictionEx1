package system.engine.world.rule.action.impl.calculation;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.expression.impl.Expression;
import system.engine.world.rule.action.impl.Action;

public abstract class Calculation extends Action {

    protected PropertyDefinition resultProp;
    protected Expression arg1;
    protected Expression arg2;

    public Calculation(String typeParam, EntityDefinition entityDefinitionParam, String propertyNameParam, Expression arg1Param, Expression arg2Param){
        super(typeParam, entityDefinitionParam);
        resultProp = entityDefinition.getSinglePropertyFromString(propertyNameParam);
        arg1= arg1Param;
        arg2= arg2Param;
    }


}
