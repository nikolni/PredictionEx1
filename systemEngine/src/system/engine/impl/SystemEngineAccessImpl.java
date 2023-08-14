
package system.engine.impl;

import dto.api.*;
import dto.creation.CreateDTOMenu2ForUi;
import dto.creation.CreateDTOMenu3EVDForUi;
import dto.creation.CreateDTOMenu3EVIForUi;
import system.engine.api.SystemEngineAccess;
import system.engine.run.simulation.api.RunSimulation;
import system.engine.run.simulation.impl.RunSimulationImpl;
import system.engine.world.api.WorldDefinition;
import system.engine.world.api.WorldInstance;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.definition.value.generator.impl.init.InitValueGenerator;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.environment.impl.EnvVariablesInstanceManagerImpl;
import system.engine.world.execution.instance.property.api.PropertyInstance;

import java.util.*;

public class SystemEngineAccessImpl implements SystemEngineAccess {

    private final WorldDefinition worldDefinition;
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

    @Override
    public DTOMenu3ForUiTC runSimulation(){    //on last index at world instances list
        int simulationID = worldInstances.size() - 1;
        String terminationCondition;

        RunSimulation runSimulationInstance = new RunSimulationImpl();
        terminationCondition = runSimulationInstance.runSimulationOnLastWorldInstance(worldDefinition,
                worldInstances.get(simulationID) ,envVariablesInstanceManager);

        return simulationID;
    }
}
