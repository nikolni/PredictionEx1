package system.engine.world.rule;

import system.engine.world.rule.action.impl.Action;
import system.engine.world.tick.Tick;

import java.util.Set;

public class Rule {
    private String uniqueName = "";
    private int numOfActions = 0;
    private Set<Action> actionsCollection;
    private Activation activation;

    public class Activation{
        private Tick ticks = new Tick(1);
        private float probability = 1;

        public Activation(){}

        public Activation(Tick ticksParam, float probabilityParam){
            ticks= ticksParam;
            probability = probabilityParam;
        }
        public Tick getTicks() {
            return ticks;
        }

        public void setTicks(Tick ticks) {
            this.ticks = ticks;
        }

        public float getProbability() {
            return probability;
        }

        public void setProbability(float probability) {
            this.probability = probability;
        }
    }
}
