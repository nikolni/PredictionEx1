
package system.engine.impl;

import dto.api.DTOMenu2ForUi;
import dto.api.DTOMenu3ForSE;
import dto.api.DTOMenu3ForUiEVD;
import dto.api.DTOMenu3ForUiEVI;
import dto.creation.CreateDTOMenu2ForUi;
import dto.creation.CreateDTOMenu3EVDForUi;
import dto.creation.CreateDTOMenu3EVIForUi;
import dto.impl.DTOMenu3ForUiEVIImpl;
import system.engine.api.SystemEngineAccess;
import system.engine.world.api.WorldDefinition;
import system.engine.world.api.WorldInstance;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.definition.value.generator.impl.init.InitValueGenerator;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.execution.instance.enitty.manager.api.EntityInstanceManager;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.environment.impl.EnvVariablesInstanceManagerImpl;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.api.Rule;

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
    public DTOMenu2ForUi getDataForMenu2FromSE() {
        return new CreateDTOMenu2ForUi().getDataForMenu2(worldDefinition);
    }

    @Override
    public DTOMenu3ForUiEVD getEVDForMenu3FromSE() {
        return new CreateDTOMenu3EVDForUi().getDataForMenu3(worldDefinition);
    }

    @Override
    public DTOMenu3ForUiEVI getEVIForMenu3FromSE() {
        return new CreateDTOMenu3EVIForUi().getDataForMenu3(envVariablesInstanceManager);
    }

    @Override
    public int getNumOfTicksToRun() {
        return worldDefinition.getTerminationConditionsManager().getTerminationConditionsList().get(0).getTerminationCondition();
    }

    @Override
    public int getNumOfSecondsToRun() {
        return worldDefinition.getTerminationConditionsManager().getTerminationConditionsList().get(1).getTerminationCondition();
    }

    @Override
    public List<Rule> getActiveRules(int tickNumber) {
        List<Rule> activeRules = new ArrayList<>();

        for(Rule rule : worldDefinition.getRuleDefinitionManager().getDefinitions()){
            if(rule.getActivation().isActive(tickNumber)){
                activeRules.add(rule);
            }
        }
        return activeRules;
    }

    @Override
    public List<EntityInstance> getAllInstancesOfLastWorldInstance() {
        return worldInstances.get(worldInstances.size() - 1).getEntityInstanceManager().getInstances();
    }

    @Override
    public EntityInstanceManager getEntityInstanceManagerOfLastWorldInstance() {
        return worldInstances.get(worldInstances.size() - 1).getEntityInstanceManager();
    }

    @Override
    public EnvVariablesInstanceManager getEnvVariablesInstanceManager() {
        return envVariablesInstanceManager;
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
