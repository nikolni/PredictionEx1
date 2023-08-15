
package system.engine.impl;

import dto.api.*;
import dto.creation.CreateDTOMenu2ForUi;
import dto.creation.CreateDTOMenu3EVDForUi;
import dto.creation.CreateDTOMenu3EVIForUi;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.impl.DTOSimulationDataForUiImpl;
import jaxb.copy.WorldFromXml;
import system.engine.api.SystemEngineAccess;
import system.engine.run.simulation.api.RunSimulation;
import system.engine.run.simulation.impl.RunSimulationImpl;
import system.engine.world.api.WorldDefinition;
import system.engine.world.api.WorldInstance;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.definition.value.generator.impl.init.InitValueGenerator;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.environment.impl.EnvVariablesInstanceManagerImpl;

import java.util.*;

public class SystemEngineAccessImpl implements SystemEngineAccess {

    private WorldDefinition worldDefinition;
    private List< WorldInstance> worldInstances;
    private EnvVariablesInstanceManager envVariablesInstanceManager;


    public SystemEngineAccessImpl() {
        this.worldInstances = new ArrayList<>();
    }



    @Override
    public void getXMLFromUser(String xmlPath) {
        WorldFromXml worldFromXml = new WorldFromXml();
        worldDefinition = worldFromXml.FromXmlToPRDWorld(xmlPath);
    }

    @Override
    public DTODefinitionsForUi getDataForMenu2FromSE() {
        return new CreateDTOMenu2ForUi().getDataForMenu2(worldDefinition);
    }

    @Override
    public DTOEnvVarsDefForUi getEVDForMenu3FromSE() {
        return new CreateDTOMenu3EVDForUi().getDataForMenu3(worldDefinition);
    }

    @Override
    public DTOEnvVarsInsForUi getEVIForMenu3FromSE() {
        return new CreateDTOMenu3EVIForUi().getDataForMenu3(envVariablesInstanceManager);
    }

    @Override
    public void updateEnvironmentVarDefinition(DTOEnvVarDefValuesForSE dtoEnvVarDefValuesForSE) {
        int index = 0;

        List<Object> initValues = dtoEnvVarDefValuesForSE.getEnvironmentVarInitValues();
        List<PropertyDefinition> propertyDefinitions = createListOfPropertyDefinitionsFromDTO(dtoEnvVarDefValuesForSE.getPropertyDefinitionDTOList());
        for (PropertyDefinition propertyDefinition : propertyDefinitions) {
            if (initValues.get(index) != null) {
                propertyDefinition.setValueGenerator(new InitValueGenerator(initValues.get(index)));
            }
            index++;
        }
        createEnvVarInstanceManager();
    }

    private List<PropertyDefinition> createListOfPropertyDefinitionsFromDTO(List<PropertyDefinitionDTO> propertyDefinitionDTOList){
        List<PropertyDefinition> propertyDefinitions = new ArrayList<>();
        for(PropertyDefinitionDTO environmentVar : propertyDefinitionDTOList){
            propertyDefinitions.add(worldDefinition.getEnvVariablesDefinitionManager().getEnvVar(environmentVar.getUniqueName()));
        }
        return propertyDefinitions;
    }

    private void createEnvVarInstanceManager(){
        envVariablesInstanceManager= new EnvVariablesInstanceManagerImpl(worldDefinition.getEnvVariablesDefinitionManager());

    }
    @Override
    public void addWorldInstance(){
        worldInstances.add(worldDefinition.createWorldInstance(worldInstances.size() + 1));
    }

    @Override
    public DTOSimulationDataForUi runSimulation() throws IllegalArgumentException{    //on last index at world instances list
        int simulationID = worldInstances.size() - 1;
        String terminationCondition;

        RunSimulation runSimulationInstance = new RunSimulationImpl();
        terminationCondition = runSimulationInstance.runSimulationOnLastWorldInstance(worldDefinition,
                worldInstances.get(simulationID) ,envVariablesInstanceManager);

        return new DTOSimulationDataForUiImpl(simulationID, terminationCondition);
    }
}
