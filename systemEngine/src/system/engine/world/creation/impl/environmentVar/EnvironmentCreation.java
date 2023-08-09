package system.engine.world.creation.impl.environmentVar;

import system.engine.world.environment.variable.EnvironmentVariable;
import system.engine.world.rule.enums.Type;

public class EnvironmentCreation {
    public static EnvironmentVariable createEnvironmentVar(String uniqueNameParam, Type typeParam, Boolean isRandomInitializeParam,
                                                           float fromParam, float toParam){
        if(toParam == 0) {
            return new EnvironmentVariable(uniqueNameParam, typeParam, isRandomInitializeParam);
        }
        else{
            return new EnvironmentVariable(uniqueNameParam, typeParam, isRandomInitializeParam, fromParam, toParam);
        }
    }
}
