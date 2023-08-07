package system.engine.world.creation.property;

import system.engine.world.rule.enums.Type;

public class PropertyCreation {
    public static PropertyDefinition createProperty(String uniqueNameParam, Type typeParam, Boolean isRandomInitializeParam,
                                                    float fromParam, float toParam){
        if(toParam == 0) {
            return new PropertyDefinition(uniqueNameParam, typeParam, isRandomInitializeParam);
        }
        else{
            return new PropertyDefinition(uniqueNameParam, typeParam, isRandomInitializeParam, fromParam, toParam);
        }
    }

}
