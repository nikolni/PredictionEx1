package system.engine.world.rule.action.impl;

import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.rule.action.api.ActionCommon;

public abstract class Action implements ActionCommon {

    protected String type = "";   // לא צריך כי מייצרים ךפי זה את סוג הפעולה
    protected EntityDefinition entityDefinition;
    public Action(String typeParam, EntityDefinition entityDefinitionParam){
        type = typeParam;
        entityDefinition = entityDefinitionParam;
    }
}