package system.engine.world.rule.action.impl;

import system.engine.world.definition.entity.api.EntityDefinition;

public class Kill extends Action {

    public Kill(String typeParam, EntityDefinition entityDefinitionParam) {
        super(typeParam, entityDefinitionParam);
    }

    @Override
    public void executeAction() {
        entityDefinition =null;
    }
}
