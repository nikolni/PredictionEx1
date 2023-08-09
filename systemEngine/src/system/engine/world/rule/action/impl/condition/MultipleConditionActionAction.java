package system.engine.world.rule.action.impl.condition;

import system.engine.world.rule.context.Context;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.api.Action;

import java.util.ArrayList;
import java.util.List;

public class MultipleConditionActionAction extends ConditionAction {
    private String logical;
    private List<ConditionAction> conditionsCollection;

    public MultipleConditionActionAction(EntityDefinition entityDefinitionParam, String logicalParam) {
        super(entityDefinitionParam);
        logical = logicalParam;
        conditionsCollection = new ArrayList<>();
    }

    @Override
    public void executeAction(Context context) {
        if (isConditionFulfilled(context)) {
            for (Action action : actionsCollection) {
                action.executeAction(context);
            }
        }
    }

    public boolean isConditionFulfilled(Context context) {
        boolean isConditionFulfilled = false;

        switch (logical) {
            case "or":
                for (ConditionAction conditionAction : conditionsCollection) {
                    isConditionFulfilled |= conditionAction.isConditionFulfilled(context);
                }
                break;
            case "and":
                for (ConditionAction conditionAction : conditionsCollection) {
                    isConditionFulfilled &= conditionAction.isConditionFulfilled(context);
                }
                break;
        }
        return isConditionFulfilled;
    }

    public void addConditionToConditionsCollection(ConditionAction conditionAction){
        conditionsCollection.add(conditionAction);
    }
}
