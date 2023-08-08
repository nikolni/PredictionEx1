package system.engine.world.rule.action.impl.condition;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.rule.action.api.AbstractAction;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.action.api.ActionType;

import java.util.List;

public abstract class Condition extends AbstractAction {
    protected String singularity;
    protected List<Action> actionsCollection;

    public Condition(EntityDefinition entityDefinitionParam, List<Action> actionsCollectionParam) {
        super(ActionType.CONDITION, entityDefinitionParam);
        actionsCollection = actionsCollectionParam;
    }

    public abstract boolean isConditionFulfilled(EntityInstance entityInstance);
}
