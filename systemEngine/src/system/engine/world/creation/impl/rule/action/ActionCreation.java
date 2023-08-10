package system.engine.world.creation.impl.rule.action;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.action.impl.KillAction;
import system.engine.world.rule.action.impl.SetAction;
import system.engine.world.rule.action.impl.condition.MultipleConditionActionAction;
import system.engine.world.rule.action.impl.condition.SingleConditionActionAction;
import system.engine.world.rule.action.impl.numeric.impl.DecreaseAction;
import system.engine.world.rule.action.impl.numeric.impl.IncreaseAction;
import system.engine.world.rule.action.impl.numeric.impl.calculation.DivideAction;
import system.engine.world.rule.action.impl.numeric.impl.calculation.MultiplyAction;

import java.util.Arrays;
import java.util.List;

public class ActionCreation {

    public static Action createAction(String actionType, EntityDefinitionManager entityDefinitionManager,
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
    }

    private static Action createActionIncrease(EntityDefinition entityDefinition, String propertyName, String expressionStr){
        return new IncreaseAction(entityDefinition, propertyName, expressionStr);
    }

    private static Action createActionDecrease(EntityDefinition entityDefinition, String propertyName, String expressionStr){
        return new DecreaseAction(entityDefinition, propertyName, expressionStr);
    }

    private static Action createActionCalculation(EntityDefinition entityDefinition,List<String> constactorArgs) {
        String resultPropertyName = constactorArgs.get(1);
        String expressionArg1 = constactorArgs.get(2);
        String expressionArg2 = constactorArgs.get(2);

        switch (constactorArgs.get(0)) {
            case "divide":
                return createActionCalculationDivide(entityDefinition, resultPropertyName, expressionArg1, expressionArg2);
            case "multiply":
                return createActionCalculationMultiply(entityDefinition, resultPropertyName, expressionArg1, expressionArg2);
        }
        return null;
    }

    private static Action createActionCalculationDivide(EntityDefinition entityDefinition, String resultPropertyName,
                String expressionStr1,String expressionStr2 ){
        return new DivideAction(entityDefinition, resultPropertyName, expressionStr1, expressionStr2);
    }

    private static Action createActionCalculationMultiply(EntityDefinition entityDefinition, String resultPropertyName,
                String expressionStr1,String expressionStr2){
        return new MultiplyAction(entityDefinition, resultPropertyName, expressionStr1, expressionStr2);
    }

    private static Action createActionCondition(EntityDefinition entityDefinition1,EntityDefinitionManager entityDefinitionManager, List<String> constactorArgs) {
        switch (constactorArgs.get(0)) {
            case "single":
                EntityDefinition entityDefinition2 = entityDefinitionManager.getEntityDefinitionByName(constactorArgs.get(1));
                String propertyName = constactorArgs.get(2);
                String operator = constactorArgs.get(3);
                String expressionStr = constactorArgs.get(4);
                return createActionConditionSingle(entityDefinition1, entityDefinition2, propertyName, operator, expressionStr);
            case "multiple":
                String logical = constactorArgs.get(1);
                return createActionConditionMultiple(entityDefinition1, logical);
        }
        return null;
    }

    private static Action createActionConditionSingle(EntityDefinition entityDefinition1, EntityDefinition entityDefinition2, String propertyName,
                                                      String operator, String expressionStr){
            return new SingleConditionActionAction(entityDefinition1, entityDefinition2, propertyName, operator, expressionStr);
    }

    private static Action createActionConditionMultiple(EntityDefinition entityDefinition, String logical){
            return new MultipleConditionActionAction(entityDefinition, logical);
    }

    private static Action createActionSet(EntityDefinition entityDefinition, String propertyName, String expressionStr){
        return new SetAction(entityDefinition, propertyName, expressionStr);
    }

    private static Action createActionKill(EntityDefinition entityDefinition){
        return new KillAction(entityDefinition);
    }
}
