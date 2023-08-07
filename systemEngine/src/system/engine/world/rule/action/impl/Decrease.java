package system.engine.world.rule.action.impl;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.expression.impl.Expression;

public class Decrease extends Action {

    private PropertyDefinition property;
    private Expression expression;

    public Decrease(String typeParam, EntityDefinition entityDefinitionParam, String propertyNameParam, Expression expressionParam) {
        super(typeParam, entityDefinitionParam);
        property = entityDefinition.getSinglePropertyFromString(propertyNameParam);
        expression = expressionParam; //??
    }

    @Override
    public void executeAction() {
        PropertyDefinition.PropertyTypeValue propertyTypeValue = property.getPropertyTypeValue();

        switch (propertyTypeValue.getType()) {   //enum???
            case INT:
                propertyTypeValue.setValue((int)propertyTypeValue.getValue() - Integer.parseInt(expression.getExpressionStr()));
                break;
            case FLOAT:
                propertyTypeValue.setValue((float)propertyTypeValue.getValue() - Float.parseFloat(expression.getExpressionStr()) );
                break;
        }
    }
}
