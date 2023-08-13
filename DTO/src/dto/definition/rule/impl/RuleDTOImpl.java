package dto.definition.rule.impl;

import dto.definition.rule.activation.api.ActivationDTO;
import dto.definition.rule.api.RuleDTO;
import java.util.List;

public class RuleDTOImpl implements RuleDTO {
    private final String name;
    private final List<String> actionNames;
    private ActivationDTO activation;

    public RuleDTOImpl(String name, List<String> actionNames, ActivationDTO activation) {
        this.name = name;
        this.actionNames = actionNames;
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
        return actionNames.size();
    }

    @Override
    public List<String> getActionsNames() {
        return actionNames;
    }


}
