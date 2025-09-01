package OOPs;

public class CarMain {
    public static void main(String[] args) {
        Media brake = new Car();
        brake.stop();
        BetterCar betterCar = new BetterCar();
        betterCar.start();
        betterCar.startMusic();
        betterCar.acc();

    }
}
