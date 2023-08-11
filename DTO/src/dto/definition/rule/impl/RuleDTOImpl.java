package dto.definition.rule.impl;

import dto.definition.rule.activation.api.ActivationDTO;
import dto.definition.rule.api.RuleDTO;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.activation.api.Activation;
import system.engine.world.rule.activation.impl.ActivationImpl;
import system.engine.world.rule.api.Rule;
import java.util.ArrayList;
import java.util.List;

public class RuleDTOImpl implements RuleDTO {
    private final String name;
    private final List<Action> actions;
    private ActivationDTO activation;

    public RuleDTOImpl(String name, List<Action> actions, ActivationDTO activation) {
        this.name = name;
        this.actions = actions;
        this.activation = activation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ActivationDTO getActivation() {
        return activation;
    }

    @Override
    public int getNumOfActions() {
        return actions.size();
    }

    @Override
    public List<String> getActionsNames() {
        List<String> names = new ArrayList<>();
        for(Action action: actions){
            names.add((action.getActionType()).toString());
        }
        return names;
    }

}
