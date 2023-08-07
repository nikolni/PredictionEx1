package system.engine.world.termination.condition;

import system.engine.world.tick.Tick;

public class TerminationConditions {
    private int seconds = 0;
    private Tick ticks;


    public TerminationConditions(int secondsParam, Tick ticksParam){
        seconds= secondsParam;
        ticks = ticksParam;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Tick getTicks() {
        return ticks;
    }

    public void setTicks(Tick ticks) {
        this.ticks = ticks;
    }
}
