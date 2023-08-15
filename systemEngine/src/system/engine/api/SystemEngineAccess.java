package system.engine.api;

import dto.api.*;

public interface SystemEngineAccess {

    DTOMenu2ForUi getDataForMenu2FromSE();
    DTOMenu3ForUiEVD getEVDForMenu3FromSE();

    DTOMenu3ForUiEVI getEVIForMenu3FromSE();

    void updateEnvironmentVarDefinition(DTOMenu3ForSE dtoMenu3ForSE);
    void addWorldInstance();

    DTOMenu3ForUiTC runSimulation();

}
