package ui;

import dto.api.DTOMenu3ForUiEVD;
import dto.api.DTOMenu3ForUiTC;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.definition.property.instance.api.PropertyInstanceDTO;
import system.engine.api.SystemEngineAccess;
import ui.dto.creation.CreateDTOMenu3ForSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Menu3 {

    public void executeSimulation(SystemEngineAccess systemEngineAccess){
        DTOMenu3ForUiEVD dtoMenu3ForUiEVD = systemEngineAccess.getEVDForMenu3FromSE();
        List<Object> initValues = new ArrayList<>();

        System.out.println("Here is the list of environment variables.\n" +
                "For each environment variable you must press:" +
                "Y - entering a value for the environment variable.\n" +
                "N- random initialization.");

        printEnvironmentVarsDataAndCollectValueFromUser(dtoMenu3ForUiEVD, initValues);
        systemEngineAccess.updateEnvironmentVarDefinition(new CreateDTOMenu3ForSE().getDataForMenu3(initValues));
        printEnvironmentVarsDataAfterGeneration(systemEngineAccess.getEVIForMenu3FromSE().getEnvironmentVars());
        systemEngineAccess.addWorldInstance();
        runSimulation(systemEngineAccess);
    }

    private void runSimulation(SystemEngineAccess systemEngineAccess){
        try{
            DTOMenu3ForUiTC dtoMenu3ForUiTC = systemEngineAccess.runSimulation();
            System.out.println("Simulation running is done without errors!\n" +
                    "Simulation ID: " + dtoMenu3ForUiTC.getSimulationID() + "\n" +
                    "Termination reason: " + dtoMenu3ForUiTC.getTerminationReason());
        }
        catch (Exception e){
            System.out.println("Simulation running is terminated as a result of unexpected errors!\n" +
                    "Error description: " + e.getMessage());
        }
    }


    private void printEnvironmentVarsDataAndCollectValueFromUser(DTOMenu3ForUiEVD dtoMenu3, List<Object> initValues){
        int countEnvVar = 0;

        for(PropertyDefinitionDTO environmentVar : dtoMenu3.getEnvironmentVars()){
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
    private void printPropertyData(PropertyDefinitionDTO environmentVar, int countEnvVar){
        System.out.println("   #" + countEnvVar + " name: " + environmentVar.getUniqueName());
        System.out.println("     " + "type: " + environmentVar.getType());
        System.out.println("     " + (environmentVar.doesHaveRange() ? "range: from " +
                environmentVar.getRange().get(0) + " to " + environmentVar.getRange().get(1) : "no range"));

        System.out.println("Would you like to initialize the environment variable?\n" +
                "Y - Entering a value for the environment variable.\n" +
                "N- random initialization.");
    }

    private Object collectValueFromUserAndCheckValidity(String envVarType){
        String valueFromUser = collectValueFromUser();
        boolean isInputValid= true;
        Object value = null;

        do {
            System.out.println("Enter value");
            isInputValid= true;
            try {
                switch (envVarType) {
                    case "DECIMAL":
                        System.out.println("Enter an integer value");
                        value = Integer.parseInt(valueFromUser);
                    case "FLOAT":
                        System.out.println("Enter a decimal value");
                        value = Float.parseFloat(valueFromUser);
                    case "STRING":
                        System.out.println("Enter your chars");
                    case "BOOLEAN":
                        System.out.println("Enter 'true' or 'false'");
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
