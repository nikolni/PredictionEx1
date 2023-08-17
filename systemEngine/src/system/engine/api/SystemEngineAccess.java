package system.engine.api;

import dto.api.*;

public interface SystemEngineAccess {

    void getXMLFromUser(String xmlPath);

    DTODefinitionsForUi getDefinitionsDataFromSE();
    DTOEnvVarsDefForUi getEVDFromSE();

    DTOEnvVarsInsForUi getEVIFromSE();
    DTOSimulationsTimeRunDataForUi getSimulationsTimeRunDataFromSE();

    DTOEntitiesAfterSimulationByQuantityForUi getEntitiesDataAfterSimulationRunningByQuantity(Integer simulationID);

    DTONamesListForUi getEntitiesNames();

    DTONamesListForUi getPropertiesNames(int entityDefinitionIndex );
    DTOPropertyHistogramForUi getPropertyDataAfterSimulationRunningByHistogram(Integer simulationID,
                                                                               int entityDefinitionIndex,int propertyIndex);

    void updateEnvironmentVarDefinition(DTOEnvVarDefValuesForSE dtoEnvVarDefValuesForSE);
    void addWorldInstance();

    DTOSimulationEndingForUi runSimulation();

}
