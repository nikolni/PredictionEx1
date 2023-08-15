package system.engine.world.creation.api;

import system.engine.world.definition.entity.manager.api.EntityDefinitionManager;
import system.engine.world.rule.action.api.Action;

public interface ActionCreation {
    Action createAction(String actionType, EntityDefinitionManager entityDefinitionManager,
                        String entityDefinitionName, String... strings);
}
