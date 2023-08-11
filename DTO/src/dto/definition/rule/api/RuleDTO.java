package dto.definition.rule.api;

import dto.definition.rule.activation.api.ActivationDTO;
import system.engine.world.rule.action.api.Action;
import system.engine.world.rule.activation.api.Activation;

import java.util.List;

public interface RuleDTO {
    String getName();
    ActivationDTO getActivation();
    int getNumOfActions();
    List<String> getActionsNames();
}
