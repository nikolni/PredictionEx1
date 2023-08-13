
package system.engine.impl;

import dto.api.DTOMenu2ForUi;
import dto.api.DTOMenu3ForSE;
import dto.api.DTOMenu3ForUi;
import dto.creation.CreateDTOMenu2ForUi;
import dto.creation.CreateDTOMenu3ForUi;
import system.engine.api.SystemEngineAccess;
import system.engine.world.api.WorldDefinition;
import system.engine.world.api.WorldInstance;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.definition.value.generator.impl.init.InitValueGenerator;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.environment.impl.EnvVariablesInstanceManagerImpl;
import system.engine.world.execution.instance.property.api.PropertyInstance;

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
    public DTOMenu3ForUi getDataForMenu3FromSE() {
        return new CreateDTOMenu3ForUi().getDataForMenu3(worldDefinition);
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
