
package system.engine.impl;

import dto.api.*;
import dto.creation.*;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.impl.DTOSimulationEndingForUiImpl;
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
    public DTODefinitionsForUi getDefinitionsDataFromSE() {
        return new CreateDTODefinitionsForUi().getData(worldDefinition);
    }

    @Override
    public DTOEnvVarsDefForUi getEVDFromSE() {
        return new CreateDTOEVDForUi().getData(worldDefinition);
    }

    @Override
    public DTOEnvVarsInsForUi getEVIFromSE() {
        return new CreateDTOEVIForUi().getData(envVariablesInstanceManager);
    }

    @Override
    public DTOSimulationsTimeRunDataForUi getSimulationsTimeRunDataFromSE() {
        return new CreateDTOSimulationsTimeRunDataForUi().getData(worldInstances);
    }

    @Override
    public DTOEntitiesAfterSimulationByQuantityForUi getEntitiesDataAfterSimulationRunningByQuantity(Integer simulationID) {
        return new CreateDTOEntitiesAfterSimulationByQuantityForUi().getData(worldDefinition, worldInstances.get(simulationID));
    }

    @Override
    public DTONamesListForUi getEntitiesNames() {
        return new CreateEntitiesNamesListForUi().getData(worldDefinition);
    }

    @Override
    public DTONamesListForUi getPropertiesNames(int entityDefinitionIndex) {
        return new CreatePropertiesNamesListForUi().getData(worldDefinition.getEntityDefinitionManager().
                getDefinitions().get(entityDefinitionIndex -1));
    }

    @Override
    public DTOPropertyHistogramForUi getPropertyDataAfterSimulationRunningByHistogram(Integer simulationID,
                                                  int entityDefinitionIndex,int propertyIndex) {
        String entityName = worldDefinition.getEntityDefinitionManager().
                getDefinitions().get(entityDefinitionIndex -1).getUniqueName();
        String propertyName = worldDefinition.getEntityDefinitionManager().
                getDefinitions().get(entityDefinitionIndex -1).getProps().get(propertyIndex -1).getUniqueName();

        return new CreateDTOPropertyHistogramForUi().getData(worldInstances.get(simulationID), entityName, propertyName);
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
    public DTOSimulationEndingForUi runSimulation() throws IllegalArgumentException{    //on last index at world instances list
        int simulationID = worldInstances.size() - 1;
        String terminationCondition;

        RunSimulation runSimulationInstance = new RunSimulationImpl();
        terminationCondition = runSimulationInstance.runSimulationOnLastWorldInstance(worldDefinition,
                worldInstances.get(simulationID) ,envVariablesInstanceManager);

        return new DTOSimulationEndingForUiImpl(simulationID, terminationCondition);
    }
}
