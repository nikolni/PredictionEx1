package system.engine.world.rule.action.expression.api;

import system.engine.world.execution.instance.environment.api.EnvVariablesInstanceManager;
import system.engine.world.rule.context.Context;

public interface Expression {
    public abstract Object evaluateExpression(Context context);
}
