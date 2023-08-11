package system.engine.world.termination.condition.manager.api;

import system.engine.world.termination.condition.api.TerminationCondition;

import java.util.List;

public interface TerminationConditionsManager {
    public List<TerminationCondition> getTerminationConditionsList();
}
