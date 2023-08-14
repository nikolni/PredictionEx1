package system.engine.api;

import dto.api.DTOMenu2ForUi;
import dto.api.DTOMenu3ForSE;
import dto.api.DTOMenu3ForUiEVD;
import dto.api.DTOMenu3ForUiEVI;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.execution.instance.enitty.manager.api.EntityInstanceManager;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.api.Rule;

import java.util.List;
public interface SystemEngineAccess {

    DTOMenu2ForUi getDataForMenu2FromSE();
    DTOMenu3ForUiEVD getEVDForMenu3FromSE();

    DTOMenu3ForUiEVI getEVIForMenu3FromSE();
    EnvVariablesInstanceManager getEnvVariablesInstanceManager();  //?

    void updateEnvironmentVarDefinition(DTOMenu3ForSE dtoMenu3ForSE);
    void addWorldInstance();
    List<PropertyInstance> getEnvironmentVarInstances();

     int runSimulation();

}
