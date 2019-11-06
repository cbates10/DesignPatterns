package creational;

public class StaticMazeFactory {

    // Volatile keeps the instance value from being written to cache
    private volatile static StaticMazeFactory instance;

    public static StaticMazeFactory instance() {
        // Uses double checking synchronization as making the entire method synchronized could bog down performance
        if(instance == null) {
            synchronized (StaticMazeFactory.class) {
                if(instance == null) {
                    instance = new StaticMazeFactory();
                }
            }
        }
        return instance;
    }

    protected StaticMazeFactory() {}

}
