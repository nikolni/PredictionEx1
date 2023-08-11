package system.engine.world.termination.condition.manager.impl;

import system.engine.world.termination.condition.api.TerminationCondition;

import java.util.List;

public class TerminationConditionsManagerImpl {
    private List<TerminationCondition> terminationConditionList;

    public List<TerminationCondition> getTerminationConditionsList(){
        return terminationConditionList;
    }

    public void addTerminationCondition (TerminationCondition terminationCondition){
        terminationConditionList.add(terminationCondition);
    }
}
