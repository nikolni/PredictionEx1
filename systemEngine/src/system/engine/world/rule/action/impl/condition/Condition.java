package system.engine.world.rule.action.impl.condition;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.impl.Action;

import java.util.List;

public abstract class Condition extends Action {
    protected String singularity;
    protected List<Action> actionsCollection;

    public Condition(String typeParam, EntityDefinition entityDefinitionParam, List<Action> actionsCollectionParam) {
        super(typeParam, entityDefinitionParam);
        actionsCollection = actionsCollectionParam;
    }
}
