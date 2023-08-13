package dto.definition.rule.api;

import dto.definition.rule.activation.api.ActivationDTO;

import java.util.List;

public interface RuleDTO {
    String getName();
    ActivationDTO getActivation();
    int getNumOfActions();
    List<String> getActionsNames();
}
