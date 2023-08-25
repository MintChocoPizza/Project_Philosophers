package philosophers;
public class Philosopher extends Thread {
    public int mID;
    public DiningPhilosophers mMain;
    
    public Philosopher(int id, DiningPhilosophers main)
    {
        mID = id;
        mMain = main;
    }
    
    @Override
    public void run() {
        int i=0;
        int next = (mID+1)%mMain.nNum;
        while (i<1000) {
            try {
                mMain.mForks[mID].get(mID);
                if ( mMain.mForks[next].tryGet(mID) == false ) {
                    mMain.mForks[mID].put();  
                    sleep(1);
                    continue;
                    
                }
            } catch (InterruptedException e) {
                return;
            }

            System.out.println(mID + "th philosopher eats");

            mMain.mForks[next].put();
            mMain.mForks[mID].put();

            System.out.println(mID + "th philosopher thinks");
            i++;
        }     
    }
}
