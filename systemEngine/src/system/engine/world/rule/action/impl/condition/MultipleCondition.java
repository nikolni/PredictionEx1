package system.engine.world.rule.action.impl.condition;

import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.context.Context;

import java.util.List;

public class MultipleCondition extends Condition {
    private String logical;
    private List<Condition> conditionsCollection;

    public MultipleCondition(EntityDefinition entityDefinitionParam, String logicalParam,
                             List<Action> actionsCollectionParam, List<Condition> conditionsCollectionParam) {
        super(entityDefinitionParam, actionsCollectionParam);
        logical = logicalParam;
        conditionsCollection = conditionsCollectionParam;
    }

    @Override
    public void executeAction(Context context) {
        if (isConditionFulfilled(entityInstance)) {
            for (Action action : actionsCollection) {
                action.executeAction(entityInstance);
            }
        }
    }

    public boolean isConditionFulfilled(EntityInstance entityInstance) {
        boolean isConditionFulfilled = false;

        switch (logical) {
            case "or":
                for (Condition condition : conditionsCollection) {
                    isConditionFulfilled |= condition.isConditionFulfilled(entityInstance);
                }
                break;
            case "and":
                for (Condition condition : conditionsCollection) {
                    isConditionFulfilled &= condition.isConditionFulfilled(entityInstance);
                }
                break;
        }
        return isConditionFulfilled;
    }
}
