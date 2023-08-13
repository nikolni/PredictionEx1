package ui;

import dto.api.DTOMenu3ForUiEVD;
import dto.definition.property.definition.api.PropertyDefinitionDTO;
import dto.definition.property.instance.api.PropertyInstanceDTO;
import dto.definition.rule.enums.Type;
import system.engine.api.SystemEngineAccess;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.api.Rule;
import system.engine.world.rule.context.Context;
import system.engine.world.rule.context.ContextImpl;
import ui.dto.creation.CreateDTOMenu3ForSE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Menu3 {

    public void executeSimulation(SystemEngineAccess systemEngineAccess){
        DTOMenu3ForUiEVD dtoMenu3 = systemEngineAccess.getEVDForMenu3FromSE();
        List<Object> initValues = new ArrayList<>();

        System.out.println("Here is the list of environment variables.\n" +
                "For each environment variable you must press:" +
                "Y - entering a value for the environment variable.\n" +
                "N- random initialization.");

        printEnvironmentVarsDataAndCollectValueFromUser(dtoMenu3, initValues);
        systemEngineAccess.updateEnvironmentVarDefinition(new CreateDTOMenu3ForSE().getDataForMenu3(initValues));
        printEnvironmentVarsDataAfterGeneration(systemEngineAccess.getEVIForMenu3FromSE().getEnvironmentVars());
        systemEngineAccess.addWorldInstance();
        runSimulation(systemEngineAccess);
    }

    public void runSimulation(SystemEngineAccess systemEngineAccess){    //on last index at world instances list
            int tick = 0;
            int seconds = 0;
            int numOfTicksToRun = systemEngineAccess.getNumOfTicksToRun();
            int numOfSecondsToRun = systemEngineAccess.getNumOfSecondsToRun();

            List<EntityInstance> entitiesToKill = new ArrayList<>();

            List<Action> actionsList = new ArrayList<>();
            Stream<Action> actionsStream;


            while (tick<= numOfTicksToRun && seconds<=numOfSecondsToRun){
                for(Rule rule : systemEngineAccess.getActiveRules(tick)){
                    actionsList.addAll(rule.getActionsToPerform());
                 }
                actionsStream = Stream.of((Action) actionsList);

                for(EntityInstance entityInstance : systemEngineAccess.getAllInstancesOfLastWorldInstance()){
                    for (Action action : actionsList){
                        Context context = new ContextImpl(entityInstance, systemEngineAccess.getEntityInstanceManagerOfLastWorldInstance(),
                                systemEngineAccess.getEnvVariablesInstanceManager());
                        action.executeAction(context);
                    }
                }
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
