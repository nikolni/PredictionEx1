package system.engine.world.rule.action.expression.impl;

import system.engine.world.definition.entity.api.EntityDefinition;

public class ExpFreeValue extends Expression{

    public ExpFreeValue(String expressionStrParam, EntityDefinition entityDefinitionParam) {
        super(expressionStrParam, entityDefinitionParam);
    }

    @Override
    public Object evaluateExpression() {
        return (Object) expressionStr;
    }
}
