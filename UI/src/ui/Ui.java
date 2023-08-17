package ui;

import system.engine.api.SystemEngineAccess;
import system.engine.impl.SystemEngineAccessImpl;
import ui.impl.Menu2;
import ui.impl.Menu3;
import ui.impl.Menu4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ui {
    public void runSystem(){
        SystemEngineAccess systemEngine = new SystemEngineAccessImpl();
        String userChoice = "";

        while( !userChoice.equals("5")) {
            System.out.println("Here are the following options:\n" +
                    "1. Reading the system information file\n" +
                    "2. Displaying the simulation details\n" +
                    "3. Running a simulation\n" +
                    "4. Displaying full details of past activation\n" +
                    "5. Exiting the system\n" +
                    "Please enter the options number(1-5).");

            userChoice = collectNumberFromUser();
            displayUserChoice( systemEngine, userChoice);
        }
    }

    private String collectNumberFromUser(){
        boolean isInputValid= true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = null;

        do{
            System.out.println("Enter your choice");
            isInputValid= true;

            try {
                userInput = reader.readLine();
                int num = Integer.parseInt(userInput);

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

        return userInput;
    }

    private void displayUserChoice(SystemEngineAccess systemEngine, String userChoice ){
        switch (userChoice) {
            case "1":
                new Menu1().executeUserChoice(systemEngine);
            case "2":
                new Menu2().executeUserChoice(systemEngine);
            case "3":
                new Menu3().executeUserChoice(systemEngine);
            case "4":
                new Menu4().executeUserChoice(systemEngine);
        }
    }
}

