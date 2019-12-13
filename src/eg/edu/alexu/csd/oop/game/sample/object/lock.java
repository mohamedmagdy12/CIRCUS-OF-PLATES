package eg.edu.alexu.csd.oop.game.sample.object;

public class lock {

    private static Mutex mutex = new Mutex();

    public lock()
    {
        mutex.acquire();
    }

    public void release()
    {
        mutex.release();
    }

}//cl