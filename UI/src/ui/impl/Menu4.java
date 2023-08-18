package ui.impl;

import dto.api.DTOEntitiesAfterSimulationByQuantityForUi;
import dto.api.DTOPropertyHistogramForUi;
import dto.api.DTOSimulationsTimeRunDataForUi;
import system.engine.api.SystemEngineAccess;
import ui.api.MenuExecution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


public class Menu4 implements MenuExecution {

    @Override
    public void executeUserChoice(SystemEngineAccess systemEngine) {
        showFullDetailsOfPastSimulation(systemEngine);
    }


    public void showFullDetailsOfPastSimulation(SystemEngineAccess systemEngineAccess){
        DTOSimulationsTimeRunDataForUi simulationsTimeRunDataForUi = systemEngineAccess.getSimulationsTimeRunDataFromSE();
        printListOfPastSimulationsData(simulationsTimeRunDataForUi);
        System.out.println("Enter the number of the simulation you want to get the details of.");
        Integer simulationChoice = collectNumberFromUser();
        String displayWay= collectDisplayWayFromUser();
        callSystemEngineMethod(systemEngineAccess, simulationChoice, displayWay);
    }

    private void callSystemEngineMethod(SystemEngineAccess systemEngineAccess,
                                        Integer simulationChoice, String displayWay){

        switch (displayWay){
            case "quantity":
                DTOEntitiesAfterSimulationByQuantityForUi entitiesAfterSimulationForUi= systemEngineAccess.getEntitiesDataAfterSimulationRunningByQuantity( simulationChoice);
                printDataByQuantity(entitiesAfterSimulationForUi, simulationChoice);
                break;
            case "histogram of a property":
                printDataByHistogram( systemEngineAccess, simulationChoice);
                break;
        }
    }

    private void printDataByQuantity(DTOEntitiesAfterSimulationByQuantityForUi entitiesAfterSimulationForUi, Integer simulationID){
        List<String> entitiesNames = entitiesAfterSimulationForUi.getEntitiesNames();
        List<Integer> entitiesPopulationBeforeSimulation =entitiesAfterSimulationForUi.getEntitiesPopulationBeforeSimulation();
        List<Integer> entitiesPopulationAfterSimulation =entitiesAfterSimulationForUi.getEntitiesPopulationAfterSimulation();
        int count = 0;

        System.out.println("Here is simulation #" + simulationID +  " data by quantity:");

        for(String entityName : entitiesNames){
            count++;
            System.out.println("#" + count + " entity name: " + entityName+
                    " ,population before running: " + entitiesPopulationBeforeSimulation.get(count-1) +
                    " ,population after running: " + entitiesPopulationAfterSimulation.get(count-1));
        }
    }

    private void printDataByHistogram(SystemEngineAccess systemEngineAccess, Integer simulationID){
        List<String> entitiesNames = systemEngineAccess.getEntitiesNames().getNames();

        int count = 0;

        System.out.println("Here is all entities names. Choose the entity you would like to see her properties:");
        for(String entityName : entitiesNames){
            count++;
            System.out.println("#" + count + " entity name: " + entityName);
        }
        int entityChoice =collectNumberFromUser();

        List<String> propertiesNames = systemEngineAccess.getPropertiesNames(entityChoice).getNames();
        count = 0;
        System.out.println("Here is all properties names. Choose the property you would like to see his histogram:");
        for(String propertyName : propertiesNames){
            count++;
            System.out.println("#" + count + " property name: " + propertyName);
        }
        int propertyChoice =collectNumberFromUser();

        DTOPropertyHistogramForUi dtoPropertyHistogramForUi = systemEngineAccess.getPropertyDataAfterSimulationRunningByHistogram
                (simulationID,entityChoice, propertyChoice );
        Map< Object, Long> propertyHistogramMap = dtoPropertyHistogramForUi.getPropertyHistogram();
        for(Object value : propertyHistogramMap.keySet()){
            System.out.println(propertyHistogramMap.get(value) + " instances which the property '" +
                    dtoPropertyHistogramForUi.getPropertyName() + "'  is " + value.toString());
        }
    }

    private void printListOfPastSimulationsData(DTOSimulationsTimeRunDataForUi simulationsTimeRunDataForUi){
        List<Integer> idList = simulationsTimeRunDataForUi.getIdList();
        List<LocalDateTime> simulationRunTimeList = simulationsTimeRunDataForUi.getSimulationRunTimeList();

        int count = 0;

        System.out.println("Here is list of all past simulations:");

        for(Integer idNum : idList){
            count++;
            System.out.println("#" + count + " simulation Run Time: " + convertLocalDateTimeToString(simulationRunTimeList.get(count-1))+ " ,ID: " + idNum);
        }
    }

    private String convertLocalDateTimeToString(LocalDateTime simulationRunTime){
        String simulationRunTimeStr;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy | HH.mm.ss");
        simulationRunTimeStr = simulationRunTime.format(formatter);

        return simulationRunTimeStr;
    }

    private int collectNumberFromUser(){
        boolean isInputValid= true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;

        do{
            System.out.println("Enter your choice");
            isInputValid= true;

            try {
                String userInput = reader.readLine();
                num = Integer.parseInt(userInput);

            } catch (IOException e) {
                e.printStackTrace();
                isInputValid= false;
            }
            catch (NumberFormatException e){
                System.out.println("Only numbers! Try again.");
                isInputValid= false;
            }
        }
        while (!isInputValid);

        return num;
    }

    private String collectDisplayWayFromUser(){
        boolean isInputValid= true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String displayWay = null;

        System.out.println("Choose the desired information display mode(Write exactly one of the following options): " +
                "\n1. quantity\n" +"2. histogram of a property");

        do{
            System.out.println("Enter your choice");
            isInputValid= true;

            try {
                displayWay = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
                isInputValid= false;
            }
        }
        while (!isInputValid | !(displayWay.equals("quantity") | displayWay.equals("histogram of a property")));

        return displayWay;
    }

}
