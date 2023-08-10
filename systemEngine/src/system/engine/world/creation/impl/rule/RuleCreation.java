package system.engine.world.creation.impl.rule;

import system.engine.world.rule.api.Rule;
import system.engine.world.rule.impl.RuleImpl;

public class RuleCreation {
    public static Rule craeteRule(String ruleName)
    {
        return new RuleImpl(ruleName);
    }
}
