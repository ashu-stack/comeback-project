package OOPs;

public class BetterCar implements Engine,Media {
    public Media media = new CDPlayer();
    public Engine engine = new RaceEngine();

    public BetterCar() {
      //  this.engine = engine;
    }

    @Override
    public void start() {
        engine.start();
    }

    @Override
    public void stop() {
        engine.stop();
    }

    @Override
    public void acc() {
        engine.acc();
    }

    public void startMusic(){
        media.start();
    }

    public void stopMusic(){
        media.stop();
    }
}
