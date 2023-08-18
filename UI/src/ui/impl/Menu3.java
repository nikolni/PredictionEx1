package ui.impl;

import dto.api.DTOEnvVarsDefForUi;
import dto.api.DTOSimulationEndingForUi;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.definition.property.instance.api.PropertyInstanceDTO;
import system.engine.api.SystemEngineAccess;
import ui.api.MenuExecution;
import ui.dto.creation.CreateDTOMenu3ForSE;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Menu3 implements MenuExecution {
    @Override
    public void executeUserChoice(SystemEngineAccess systemEngine) {
        executeSimulation(systemEngine);
    }

    public void executeSimulation(SystemEngineAccess systemEngineAccess){
        DTOEnvVarsDefForUi dtoEnvVarsDefForUi = systemEngineAccess.getEVDFromSE();
        List<Object> initValues = new ArrayList<>();

        System.out.println("Here is the list of environment variables.\n" +
                "For each environment variable you must press:\n" +
                "y - entering a value for the environment variable.\n" +
                "n- random initialization.");

        printEnvironmentVarsDataAndCollectValueFromUser(dtoEnvVarsDefForUi, initValues);
        systemEngineAccess.updateEnvironmentVarDefinition(new CreateDTOMenu3ForSE().getDataForMenu3(initValues,
                dtoEnvVarsDefForUi.getEnvironmentVars()));
        printEnvironmentVarsDataAfterGeneration(systemEngineAccess.getEVIFromSE().getEnvironmentVars());
        systemEngineAccess.addWorldInstance();
        runSimulation(systemEngineAccess);
    }

    private void runSimulation(SystemEngineAccess systemEngineAccess){
        try{
            DTOSimulationEndingForUi dtoSimulationEndingForUi = systemEngineAccess.runSimulation();
            System.out.println("Simulation running is done without errors!\n" +
                    "Simulation ID: " + dtoSimulationEndingForUi.getSimulationID() + "\n" +
                    "Termination reason: " + dtoSimulationEndingForUi.getTerminationReason());
        }
        catch (Exception e){
            System.out.println("Simulation running is terminated as a result of unexpected errors!\n" +
                    "Error description: " + e.getMessage());
        }
    }


    private void printEnvironmentVarsDataAndCollectValueFromUser(DTOEnvVarsDefForUi dtoMenu3, List<Object> initValues){
        int countEnvVar = 0;
        boolean isInputValid;

        for(PropertyDefinitionDTO environmentVar : dtoMenu3.getEnvironmentVars()){
            countEnvVar++;
            printPropertyDataForInitialize(environmentVar, countEnvVar);

            do {
                isInputValid = true;
                String userInput = collectValueFromUser();

                switch (userInput) {
                    case "y":
                        Object valueFromUser = collectValueFromUserAndCheckValidity(environmentVar.getType());
                        initValues.add(valueFromUser);
                        break;
                    case "n":
                        initValues.add(null);
                        break;
                    default:
                        System.out.println("only 'y' or 'n'! Try again.");
                        isInputValid = false;
                        break;
                }
            }
            while (!isInputValid);
        }
    }
    private void printEnvironmentVarsDataAfterGeneration(List<PropertyInstanceDTO> envVars) {
        int countEnvVar = 0;

        System.out.println("Here is the list of all environment variables after generation:");
        for(PropertyInstanceDTO environmentVar : envVars){
            countEnvVar++;
            System.out.println("#" + countEnvVar + " name: " + environmentVar.getPropertyDefinition().getUniqueName());
            System.out.println("   " + "value: " + environmentVar.getValue().toString());
        }
    }
    private void printPropertyDataForInitialize(PropertyDefinitionDTO environmentVar, int countEnvVar){
        System.out.println("   #" + countEnvVar + " name: " + environmentVar.getUniqueName());
        System.out.println("     " + "type: " + environmentVar.getType());
        System.out.println("     " + (environmentVar.doesHaveRange() ? "range: from " +
                environmentVar.getRange().get(0) + " to " + environmentVar.getRange().get(1) : "no range"));

        System.out.println("Would you like to initialize the environment variable?\n" +
                "y - entering a value for the environment variable.\n" +
                "n- random initialization.");
    }

    private Object collectValueFromUserAndCheckValidity(String envVarType){

        boolean isInputValid;
        Object value = null;

        do {
            System.out.println("Enter value");
            isInputValid= true;
            String valueFromUser = collectValueFromUser();
            try {
                switch (envVarType) {
                    case "DECIMAL":
                        value = Integer.parseInt(valueFromUser);
                        break;
                    case "FLOAT":
                        value = Float.parseFloat(valueFromUser);
                        break;
                    case "STRING":
                        break;
                    case "BOOLEAN":
                        value = Boolean.parseBoolean(valueFromUser);
                        break;
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
