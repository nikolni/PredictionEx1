package system.engine.world.creation.impl.rule.action;

import system.engine.world.creation.api.ActionCreation;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.action.impl.KillAction;
import system.engine.world.rule.action.impl.SetAction;
import system.engine.world.rule.action.impl.condition.ConditionAction;
import system.engine.world.rule.action.impl.condition.MultipleConditionActionAction;
import system.engine.world.rule.action.impl.condition.SingleConditionActionAction;
import system.engine.world.rule.action.impl.numeric.impl.DecreaseAction;
import system.engine.world.rule.action.impl.numeric.impl.IncreaseAction;
import system.engine.world.rule.action.impl.numeric.impl.calculation.DivideAction;
import system.engine.world.rule.action.impl.numeric.impl.calculation.MultiplyAction;

import java.util.Arrays;
import java.util.List;

public class ActionCreationImpl implements ActionCreation {

    /*public Action createAction(String actionType, EntityDefinitionManager entityDefinitionManager,
                                      String entityDefinitionName, String... strings){
        List<String> constactorArgs = Arrays.asList(strings);
        EntityDefinition entityDefinition= entityDefinitionManager.getEntityDefinitionByName(entityDefinitionName);

        switch (actionType){
            case "increase":
                String propertyName1 = constactorArgs.get(0);
                String expressionStr1 = constactorArgs.get(1);
                return createActionIncrease(entityDefinition, propertyName1, expressionStr1);
            case "decrease":
                String propertyName2 = constactorArgs.get(0);
                String expressionStr2 = constactorArgs.get(1);
                return createActionDecrease(entityDefinition, propertyName2, expressionStr2);
            case "calculation":   //if calculation, string of type calculation will send in strings, index 0
                return createActionCalculation(entityDefinition, constactorArgs);
            case "condition":   //if calculation, string of type condition will send in strings, index 0
                return createActionCondition(entityDefinition,entityDefinitionManager, constactorArgs);
            case "set":
                String propertyName3 = constactorArgs.get(0);
                String expressionStr3 = constactorArgs.get(1);
                return createActionSet(entityDefinition, propertyName3, expressionStr3);
            case "kill":
                return createActionKill(entityDefinition);

        }
        return null;
    }*/

    public Action createActionIncrease(EntityDefinition entityDefinition, String propertyName, String expressionStr){
        return new IncreaseAction(entityDefinition, propertyName, expressionStr);
    }

    public Action createActionDecrease(EntityDefinition entityDefinition, String propertyName, String expressionStr){
        return new DecreaseAction(entityDefinition, propertyName, expressionStr);
    }

    /*public Action createActionCalculation(EntityDefinition entityDefinition,List<String> constactorArgs) {
        String resultPropertyName = constactorArgs.get(1);
        String expressionArg1 = constactorArgs.get(2);
        String expressionArg2 = constactorArgs.get(3);

        switch (constactorArgs.get(0)) {
            case "divide":
                return createActionCalculationDivide(entityDefinition, resultPropertyName, expressionArg1, expressionArg2);
            case "multiply":
                return createActionCalculationMultiply(entityDefinition, resultPropertyName, expressionArg1, expressionArg2);
        }
        return null;
    }*/

    public Action createActionCalculationDivide(EntityDefinition entityDefinition, String resultPropertyName,
                String expressionStr1,String expressionStr2 ){
        return new DivideAction(entityDefinition, resultPropertyName, expressionStr1, expressionStr2);
    }

    public Action createActionCalculationMultiply(EntityDefinition entityDefinition, String resultPropertyName,
                String expressionStr1,String expressionStr2){
        return new MultiplyAction(entityDefinition, resultPropertyName, expressionStr1, expressionStr2);
    }

    /*public Action createActionCondition(EntityDefinitionManager entityDefinitionManager,EntityDefinition mainEntityDefinition, List<String> conditionParams) {
        switch (conditionParams.get(0)) {
            case "single":
                return createActionConditionSingle(entityDefinitionManager, mainEntityDefinition,conditionParams.get(1),conditionParams.get(2),conditionParams.get(3),conditionParams.get(4));
            case "multiple":
                MultipleConditionActionAction multipleConditionAction=createActionConditionMultiple(mainEntityDefinition,conditionParams.get(5));
                multipleConditionAction.addConditionToConditionsCollection();
        }
        return null;
    }

    public SingleConditionActionAction createActionConditionSingle(EntityDefinitionManager entityDefinitionManager, EntityDefinition mainEntityDefinition, String entityDefinition2, String propertyName,
                                                       String operator, String expressionStr){
        EntityDefinition secEntityDefinition = entityDefinitionManager.getEntityDefinitionByName(entityDefinition2);
        return new SingleConditionActionAction(mainEntityDefinition, secEntityDefinition, propertyName, operator, expressionStr);
    }

    public MultipleConditionActionAction createActionConditionMultiple(EntityDefinition mainEntityDefinition, String logical){
            return new MultipleConditionActionAction(mainEntityDefinition, logical);
    }*/

    public Action createActionSet(EntityDefinition entityDefinition, String propertyName, String expressionStr){
        return new SetAction(entityDefinition, propertyName, expressionStr);
    }

    public Action createActionKill(EntityDefinition entityDefinition){
        return new KillAction(entityDefinition);
    }
}
