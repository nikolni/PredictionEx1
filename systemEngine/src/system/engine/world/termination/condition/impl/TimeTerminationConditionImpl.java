package system.engine.world.termination.condition.impl;

import system.engine.world.termination.condition.api.TerminationCondition;

public class TimeTerminationConditionImpl implements TerminationCondition {
    private int seconds;

    @Override
    public int getTerminationCondition() {
        return seconds;
    }

    @Override
    public void setTerminationCondition(int terminationConditions) {
        this.seconds = terminationConditions;
    }
}
