package system.engine.world.impl;

import system.engine.world.execution.instance.enitty.manager.api.EntityInstanceManager;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.execution.instance.property.api.PropertyInstance;

public class WorldInstance {
    private EntityInstanceManager entityInstanceManager;
    private static EnvVariablesInstanceManager envVariablesInstanceManager;

    public WorldInstance(WorldDefinitionImpl worldDefinitionImpl){
        entityInstanceManager = worldDefinitionImpl.getEntityDefinitionManager().createEntityInstanceManager();
        envVariablesInstanceManager = worldDefinitionImpl.getEnvVariablesDefinitionManager().createEnvironmentVarInstanceManager();
    }

    public static PropertyInstance getEnvVarFromEnvVarManager(String envVarName){
        return envVariablesInstanceManager.getProperty(envVarName);
    }

    //implement menu2+3
    /*public EntityDefinition getSingleEntityFromString (String entityName){

        return entitiesCollection.get(entityName);
    }

    public static EnvironmentVariable getSingleEnvironmentVariableFromString (String environmentVariableName){
        return environmentVariableCollection.get(environmentVariableName);
    }*/

}

