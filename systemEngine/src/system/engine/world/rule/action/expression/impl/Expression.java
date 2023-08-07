package system.engine.world.rule.action.expression.impl;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.expression.api.ExpressionCommon;

public abstract class Expression implements ExpressionCommon {
    protected String expressionStr="";
    protected EntityDefinition entityDefinition;

    public Expression(String expressionStrParam, EntityDefinition entityDefinitionParam){
        expressionStr = expressionStrParam;
        entityDefinition = entityDefinitionParam;
    }

    public String getExpressionStr(){
        return expressionStr;
    }


}





