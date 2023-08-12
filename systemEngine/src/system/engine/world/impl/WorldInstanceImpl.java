package system.engine.world.impl;

import system.engine.world.api.WorldInstance;
import system.engine.world.execution.instance.enitty.manager.api.EntityInstanceManager;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.rule.manager.api.RuleDefinitionManager;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

public class WorldInstanceImpl implements WorldInstance {
    int id;  //index in world instances list
    private EntityInstanceManager entityInstanceManager;
    //private final RuleDefinitionManager ruleDefinitionManager;
    //private final TerminationConditionsManager terminationConditionsManager;

    public WorldInstanceImpl(WorldDefinitionImpl worldDefinitionImpl, int id){
        this.id = id;
        this.entityInstanceManager = worldDefinitionImpl.getEntityDefinitionManager().createEntityInstanceManager();
        //this.ruleDefinitionManager = worldDefinitionImpl.getRuleDefinitionManager();
        //this.terminationConditionsManager = worldDefinitionImpl.getTerminationConditionsManager();
    }

    @Override
    public EntityInstanceManager getEntityInstanceManager() {
        return entityInstanceManager;
    }


    @Override
    /*public RuleDefinitionManager getRuleDefinitionManager() {
        return ruleDefinitionManager;
    }

    @Override
    public TerminationConditionsManager getTerminationConditionsManager() {
        return terminationConditionsManager;*/
    }
}

