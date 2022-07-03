package reentarntlock;

import java.util.concurrent.locks.ReentrantLock;

public class Interrupt {
    final ReentrantLock reentrantLock1 = new ReentrantLock();
    final ReentrantLock reentrantLock2 = new ReentrantLock();

    Thread t1 = new Thread(){
        public void run(){
            try{
                reentrantLock1.lockInterruptibly();
                Thread.sleep(1000);
                reentrantLock2.lockInterruptibly();
            } catch (InterruptedException e){
                System.out.println("t1 interrupted");
            }
        }
    };
}
