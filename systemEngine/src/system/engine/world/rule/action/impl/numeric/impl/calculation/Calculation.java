package system.engine.world.rule.action.impl.numeric.impl.calculation;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.api.AbstractAction;
import system.engine.world.rule.action.api.ActionType;
import system.engine.world.rule.action.impl.numeric.api.NumericVerify;

public abstract class Calculation extends AbstractAction implements NumericVerify {

    protected String resultPropName;
    protected String expressionStrArg1;
    protected String expressionStrArg2;

    public Calculation(EntityDefinition entityDefinitionParam, String propertyNameParam, String expressionStrParam1, String expressionStrParam2){
        super(ActionType.CALCULATION, entityDefinitionParam);
        resultPropName = propertyNameParam;
        expressionStrArg1= expressionStrParam1;
        expressionStrArg2= expressionStrParam2;
    }
}
