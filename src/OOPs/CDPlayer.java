package OOPs;

public class CDPlayer implements Media{
    @Override
    public void start() {
        System.out.println("Music from CD plays");
    }

    @Override
    public void stop() {
        System.out.println("Music from CD stops");
    }
}
