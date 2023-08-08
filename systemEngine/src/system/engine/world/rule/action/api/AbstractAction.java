package system.engine.world.rule.action.api;


import system.engine.world.definition.entity.api.EntityDefinition;

public abstract class AbstractAction implements Action {

    private final ActionType actionType;
    private final EntityDefinition entityDefinition;

    protected AbstractAction(ActionType actionType, EntityDefinition entityDefinition) {
        this.actionType = actionType;
        this.entityDefinition = entityDefinition;
    }

    @Override
    public ActionType getActionType() {
        return actionType;
    }

    @Override
    public EntityDefinition getContextEntity() {
        return entityDefinition;
    }
}
