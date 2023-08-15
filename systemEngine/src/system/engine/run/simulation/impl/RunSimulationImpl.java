package system.engine.run.simulation.impl;

import system.engine.run.simulation.api.RunSimulation;
import system.engine.world.api.WorldDefinition;
import system.engine.world.api.WorldInstance;
import system.engine.world.execution.instance.enitty.api.EntityInstance;
import system.engine.world.execution.instance.enitty.manager.api.EntityInstanceManager;
import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.action.impl.KillAction;
import system.engine.world.rule.api.Rule;
import system.engine.world.rule.context.Context;
import system.engine.world.rule.context.ContextImpl;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RunSimulationImpl implements RunSimulation {

    @Override
    public String runSimulationOnLastWorldInstance(WorldDefinition worldDefinition, WorldInstance worldInstance,
                                                 EnvVariablesInstanceManager envVariablesInstanceManager)
                                                    throws IllegalArgumentException{
        Instant startTime = Instant.now();
        Instant endTime;
        Duration duration;
        int tick = 0;
        int seconds = 0;
        int numOfTicksToRun = getNumOfTicksToRun(worldDefinition);
        int numOfSecondsToRun = getNumOfSecondsToRun(worldDefinition);

        List<Action> actionsList = new ArrayList<>();
        //Stream<Action> actionsStream;


        while (tick<= numOfTicksToRun && seconds<=numOfSecondsToRun){
            for(Rule rule : getActiveRules(tick, worldDefinition)){
                actionsList.addAll(rule.getActionsToPerform());
            }
            //actionsStream = Stream.of((Action) actionsList);

            runAllActionsOnAllEntities(worldInstance, envVariablesInstanceManager, actionsList);

            tick++;
            endTime = Instant.now();
            duration = Duration.between(startTime, endTime);
            seconds = (int) duration.getSeconds();
       }

        if(tick>numOfTicksToRun){return "last tick";}
        else {return "time run out";}
    }

    private void runAllActionsOnAllEntities(WorldInstance worldInstance, EnvVariablesInstanceManager envVariablesInstanceManager,
                                            List<Action> actionsList){
        Action killAction;

        for(EntityInstance entityInstance : getAllInstancesOfWorldInstance(worldInstance)){
            killAction = null;
            Context context = new ContextImpl(entityInstance, getEntityInstanceManagerOfWorldInstance(worldInstance),
                    envVariablesInstanceManager);
            for (Action action : actionsList){   //actionsList.forEach(action -> action.executeAction(context));
                if(action instanceof KillAction){
                    killAction = action;
                    continue;
                }
                action.executeAction(context);
            }
            if(killAction != null){
                killAction.executeAction(context);
            }
        }
    }


    private int getNumOfTicksToRun(WorldDefinition worldDefinition) {
        return worldDefinition.getTerminationConditionsManager().getTerminationConditionsList().get(0).getTerminationCondition();
    }


    private int getNumOfSecondsToRun(WorldDefinition worldDefinition) {
        return worldDefinition.getTerminationConditionsManager().getTerminationConditionsList().get(1).getTerminationCondition();
    }


    private List<Rule> getActiveRules(int tickNumber, WorldDefinition worldDefinition) {
        List<Rule> activeRules = new ArrayList<>();

        for(Rule rule : worldDefinition.getRuleDefinitionManager().getDefinitions()){
            if(rule.getActivation().isActive(tickNumber)){
                activeRules.add(rule);
            }
        }
        return activeRules;
    }


    private List<EntityInstance> getAllInstancesOfWorldInstance(WorldInstance worldInstance) {
        return worldInstance.getEntityInstanceManager().getInstances();
    }


    private EntityInstanceManager getEntityInstanceManagerOfWorldInstance(WorldInstance worldInstance) {
        return worldInstance.getEntityInstanceManager();
    }
}
