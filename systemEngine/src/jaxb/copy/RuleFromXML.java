package jaxb.copy;

import jaxb.generator.PRDRules;
import system.engine.world.rule.manager.api.RuleDefinitionManager;
import system.engine.world.rule.manager.impl.RuleDefinitionManagerImpl;

public class RuleFromXML {
    private RuleDefinitionManager ruleDefinitionManager=new RuleDefinitionManagerImpl();

    public RuleFromXML(PRDRules prdRules) {

    }

    public RuleDefinitionManager getRuleDefinitionManager() {
        return ruleDefinitionManager;
    }
}
