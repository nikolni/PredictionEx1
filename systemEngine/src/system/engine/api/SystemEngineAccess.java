package system.engine.api;

import dto.api.*;
import system.engine.world.api.WorldDefinition;

public interface SystemEngineAccess {

    void getXMLFromUser(String xmlPath);

    DTOMenu2ForUi getDataForMenu2FromSE();
    DTOMenu3ForUiEVD getEVDForMenu3FromSE();

    DTOMenu3ForUiEVI getEVIForMenu3FromSE();

    void updateEnvironmentVarDefinition(DTOMenu3ForSE dtoMenu3ForSE);
    void addWorldInstance();

    DTOMenu3ForUiTC runSimulation();

}
