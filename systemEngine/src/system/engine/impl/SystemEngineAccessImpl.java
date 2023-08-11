
package system.engine.impl;

import system.engine.api.SystemEngineAccess;
import system.engine.world.api.WorldDefinition;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.impl.WorldInstance;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SystemEngineAccessImpl implements SystemEngineAccess {

    private WorldDefinition worldDefinition;

    public SystemEngineAccessImpl(WorldDefinition worldDefinition){
        this.worldDefinition = worldDefinition;
    }


    @Override
    public List<EntityDefinition> getEntitiesDefinitionData(){
        return worldDefinition.getEntityDefinitionManager().getDefinitions();
    }

    @Override
    public List<Rule> getRulesData(){
       return worldDefinition.getRuleDefinitionManager().getDefinitions();
    }


    @Override
    public TerminationConditionsManager getTerminationConditionsManager(){
        return worldDefinition.getTerminationConditionsManager();
    }

    @Override
    public Collection<PropertyDefinition> getEnvironmentVar(){
        return worldDefinition.getEnvVariablesDefinitionManager().getEnvVariables();
    }
}