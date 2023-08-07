package system.engine.world.tick;

public class Tick {
    private int tick = 0;

    public Tick(int num){
        tick = num;
    }
    public int getTick() {
        return tick;
    }

    public void setTick(int tick) {
        this.tick = tick;
    }
}
