
package system.engine.impl;

import dto.api.DTOMenu3ForSE;
import system.engine.api.SystemEngineAccess;
import system.engine.world.api.WorldDefinition;
import system.engine.world.api.WorldInstance;
import system.engine.world.definition.entity.api.EntityDefinition;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.definition.value.generator.impl.init.InitValueGenerator;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.environment.impl.EnvVariablesInstanceManagerImpl;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.impl.WorldInstanceImpl;
import system.engine.world.rule.api.Rule;
import system.engine.world.termination.condition.manager.api.TerminationConditionsManager;

import java.util.*;

public class SystemEngineAccessImpl implements SystemEngineAccess {

    private WorldDefinition worldDefinition;
    private List< WorldInstance> worldInstances;
    private EnvVariablesInstanceManager envVariablesInstanceManager;


    public SystemEngineAccessImpl(WorldDefinition worldDefinition) {
        this.worldDefinition = worldDefinition;
        this.worldInstances = new ArrayList<>();
    }


    @Override
    public List<EntityDefinition> getEntitiesDefinitionData() {
        return worldDefinition.getEntityDefinitionManager().getDefinitions();
    }

    @Override
    public List<Rule> getRulesData() {
        return worldDefinition.getRuleDefinitionManager().getDefinitions();
    }


    @Override
    public TerminationConditionsManager getTerminationConditionsManager() {
        return worldDefinition.getTerminationConditionsManager();
    }

    @Override
    public Collection<PropertyDefinition> getEnvironmentVarDefinitions() {
        return worldDefinition.getEnvVariablesDefinitionManager().getEnvVariables();
    }

    @Override
    public List<PropertyInstance> getEnvironmentVarInstances() {
        return envVariablesInstanceManager.getEnvVarsList();
    }

    @Override
    public void updateEnvironmentVarDefinition(DTOMenu3ForSE dtoMenu3ForSE) {
        int index = 0;

        List<Object> initValues = dtoMenu3ForSE.getEnvironmentVarInitValues();
        for (PropertyDefinition propertyDefinition : worldDefinition.getEnvVariablesDefinitionManager().getEnvVariables()) {
            if (initValues.get(index) != null) {
                propertyDefinition.setValueGenerator(new InitValueGenerator(initValues.get(index)));
            }
            index++;
        }
        createEnvVarInstanceManager();
    }

    private void createEnvVarInstanceManager(){
        envVariablesInstanceManager= new EnvVariablesInstanceManagerImpl(worldDefinition.getEnvVariablesDefinitionManager());

    }
    @Override
    public void addWorldInstance(){
        worldInstances.add(worldDefinition.createWorldInstance(worldInstances.size() + 1));
    }



}
