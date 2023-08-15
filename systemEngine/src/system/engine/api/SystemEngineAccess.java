package system.engine.api;

import dto.api.*;

public interface SystemEngineAccess {

    void getXMLFromUser(String xmlPath);

    DTODefinitionsForUi getDataForMenu2FromSE();
    DTOEnvVarsDefForUi getEVDForMenu3FromSE();

    DTOEnvVarsInsForUi getEVIForMenu3FromSE();

    void updateEnvironmentVarDefinition(DTOEnvVarDefValuesForSE dtoEnvVarDefValuesForSE);
    void addWorldInstance();

    DTOSimulationDataForUi runSimulation();

}
