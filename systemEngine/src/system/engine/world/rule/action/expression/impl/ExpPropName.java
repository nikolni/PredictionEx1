package system.engine.world.rule.action.expression.impl;

import system.engine.world.definition.entity.api.EntityDefinition;

public class ExpPropName extends Expression {

    private PropertyDefinition propertyArg;
    public ExpPropName(String expressionStrParam, EntityDefinition entityDefinitionParam) {
        super(expressionStrParam, entityDefinitionParam);
        propertyArg= entityDefinition.getSinglePropertyFromString(expressionStrParam);
    }

    @Override
    public Object evaluateExpression() {
        return propertyArg.getPropertyTypeValue().getSecond();
    }
}
