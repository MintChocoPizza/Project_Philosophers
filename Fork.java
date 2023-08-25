package philosophers;

import java.util.concurrent.Semaphore;

public class Fork {
    public int mID;
    public int mOwner;
    private Semaphore mMutex = new Semaphore (1, true);
    public Fork(int id) {
        mID = id;
        mOwner = -1;
    }
    
    public void printGet(int who)
    {
        mOwner = who;
        System.out.println(mOwner + "th philosoper picks " + mID + "th fork" );
    }
    
    public void get(int who) throws InterruptedException {
        mMutex.acquire();
        printGet(who);
    }
    
    public boolean tryGet(int who)  {
        if(mMutex.tryAcquire(1) == false)
            return false;
        printGet(who);
        return true;
    }
    
    public void put () {
        System.out.println(mOwner + "th philosoper releases " + mID+ "th fork" );
        mOwner = -1;
        mMutex.release();
    }
}
