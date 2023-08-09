package system.engine.world.rule.impl;

import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.activation.api.Activation;
import system.engine.world.rule.api.Rule;
import java.util.ArrayList;
import java.util.List;

public class RuleImpl implements Rule {
    private final String name;
    private final List<Action> actions;;
    private Activation activation;

    public RuleImpl(String name) {
        this.name = name;
        actions = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Activation getActivation() {
        return activation;
    }

    @Override
    public List<Action> getActionsToPerform() {
        return actions;
    }

    @Override
    public void addAction(Action action) {
        actions.add(action);
    }

    @Override
    public void craeteActivation(int ticksNumber) {
        activation= new A
    }
}
