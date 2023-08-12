package ui;

import creation.impl.CreateDTOMenu3ForSEImpl;
import creation.impl.CreateDTOMenu3ForUiImpl;
import dto.api.DTOMenu3ForUi;
import dto.definition.property.api.PropertyDefinitionDTO;
import system.engine.api.SystemEngineAccess;
import system.engine.world.definition.property.api.PropertyDefinition;
import system.engine.world.execution.instance.property.api.PropertyInstance;
import system.engine.world.rule.enums.Type;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Menu3 {

    public void executeSimulation(SystemEngineAccess systemEngineAccess){
        DTOMenu3ForUi dtoMenu2 = new CreateDTOMenu3ForUiImpl().getDataForMenu3(systemEngineAccess);
        int countEnvVar = 0;

        System.out.println("Here is the list of environment variables.\n" +
                "For each environment variable you must press:" +
                "Y - entering a value for the environment variable.\n" +
                "N- random initialization.");

        List<Object> initValues = new ArrayList<>();

        for(PropertyDefinitionDTO environmentVar : dtoMenu2.getEnvironmentVars()){
            countEnvVar++;
            printPropertyData(environmentVar, countEnvVar);
            String userInput = collectValueFromUser();
            if(userInput.equals("Y")){
                Object valueFromUser = collectValueFromUserAndCheckValidity(environmentVar.getType());
                initValues.add(valueFromUser);
            }
            else {
                initValues.add(null);
            }
        }
        systemEngineAccess.updateEnvironmentVarDefinition(new CreateDTOMenu3ForSEImpl().getDataForMenu3(initValues));
        printEnvironmentVarsData(systemEngineAccess.getEnvironmentVarInstances());
        systemEngineAccess.addWorldInstance();
        runSimulation(systemEngineAccess);
    }

    public void runSimulation(SystemEngineAccess systemEngineAccess){    //on last index at world instances list
            //iterations by ticks
    }

    private void printEnvironmentVarsData(List<PropertyInstance> envVars) {
        int countEnvVar = 0;

        System.out.println("Here is the list of all environment variables after generation:");
        for(PropertyInstance environmentVar : envVars){
            countEnvVar++;
            System.out.println("#" + countEnvVar + " name: " + environmentVar.getPropertyDefinition().getUniqueName());
            System.out.println("   " + "value: " + environmentVar.getValue().toString());
        }
    }
    private void printPropertyData(PropertyDefinitionDTO environmentVar, int countEnvVar){
        System.out.println("   #" + countEnvVar + " name: " + environmentVar.getUniqueName());
        System.out.println("     " + "type: " + environmentVar.getType());
        System.out.println("     " + (environmentVar.doesHaveRange() ? "range: from " +
                environmentVar.getRange().get(0) + " to " + environmentVar.getRange().get(1) : "no range"));

        System.out.println("Would you like to initialize the environment variable?\n" +
                "Y - Entering a value for the environment variable.\n" +
                "N- random initialization.");
    }

    private Object collectValueFromUserAndCheckValidity(Type envVarType){
        String valueFromUser = collectValueFromUser();
        boolean isInputValid= true;
        Object value = null;

        do {
            System.out.println("Enter value");
            isInputValid= true;
            try {
                switch (envVarType) {
                    case DECIMAL:
                        value = Integer.parseInt(valueFromUser);
                    case FLOAT:
                        value = Float.parseFloat(valueFromUser);
                    case STRING:

                    case BOOLEAN:
                        value = Boolean.parseBoolean(valueFromUser);
                }
            }
            catch (NumberFormatException e){
                System.out.println("wrong value type! try again");
                isInputValid= false;
            }
        }
        while (!isInputValid);
        return value;
    }

    private String collectValueFromUser(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String userInput = reader.readLine();
            return userInput;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
