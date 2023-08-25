package philosophers;

import java.util.logging.Level;
import java.util.logging.Logger;
public class DiningPhilosophers {
    final int nNum = 5;
    Fork[] mForks;
    Philosopher[] mPhilosophers;
    
    public DiningPhilosophers() {
        mPhilosophers = new Philosopher[nNum];
        mForks = new Fork[nNum];
        for (int i=0; i<nNum; i++) {
            mPhilosophers[i] = new Philosopher(i, this);
            mForks[i] = new Fork(i);
        } 
    }
    
    public void start() {
        for (int i=0; i<nNum; i++) {
            mPhilosophers[i].start();
        }
    }
    
    public void join()
    {
        try {
            for (int i=0; i<nNum; i++) {
                mPhilosophers[i].join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(DiningPhilosophers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        DiningPhilosophers phs = new DiningPhilosophers();
        phs.start();
        phs.join();
    }
}
