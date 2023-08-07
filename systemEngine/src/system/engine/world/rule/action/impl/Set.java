package system.engine.world.rule.action.impl;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.expression.impl.Expression;

public class Set extends Action {
        private PropertyDefinition property;
        private Expression expression;

    public Set(String typeParam, EntityDefinition entityDefinitionParam, String propertyNameParam, Expression expressionParam) {
            super(typeParam, entityDefinitionParam);
            property = entityDefinition.getSinglePropertyFromString(propertyNameParam);
            expression =expressionParam; //??
        }

        @Override
        public void executeAction() {
            PropertyDefinition.PropertyTypeValue propertyTypeValue = property.getPropertyTypeValue();
            propertyTypeValue.setValue((expression.evaluateExpression()));
            //errors






            }
        }

}
