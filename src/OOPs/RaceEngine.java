package OOPs;

public class RaceEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Racer Engine starts");
    }

    @Override
    public void stop() {
        System.out.println("Racer engine stops");
    }

    @Override
    public void acc() {
        System.out.println("Racer accelerates");
    }
}
