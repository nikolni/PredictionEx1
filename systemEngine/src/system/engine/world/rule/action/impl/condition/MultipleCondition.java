package system.engine.world.rule.action.impl.condition;

import system.engine.world.rule.action.impl.Action;
import system.engine.world.definition.entity.api.EntityDefinition;

import java.util.List;

public class MultipleCondition extends Condition{
    private String logical;
    private List<SingleCondition> singleConditionsCollection;

    public MultipleCondition(String typeParam, EntityDefinition entityDefinitionParam, List<Action> actionsCollectionParam,
                             String logicalParam, List<SingleCondition> singleConditionsCollectionParam) {
        super(typeParam, entityDefinitionParam, actionsCollectionParam);
        logical = logicalParam;
        singleConditionsCollection = singleConditionsCollectionParam;
    }

    @Override
    public void executeAction() {
        if(isConditionFulfilled()){
            for(Action action: actionsCollection){
                action.executeAction();
            }
        }

    }

    public boolean isConditionFulfilled(){
        boolean isConditionFulfilled =false;

        switch (logical){
            case "or":
                for(SingleCondition singleCondition: singleConditionsCollection){
                    isConditionFulfilled |= singleCondition.isConditionFulfilled();
                }
                break;
            case "and":
                for(SingleCondition singleCondition: singleConditionsCollection){
                    isConditionFulfilled &= singleCondition.isConditionFulfilled();
                }
                break;
        }
        return isConditionFulfilled;
    }
}
