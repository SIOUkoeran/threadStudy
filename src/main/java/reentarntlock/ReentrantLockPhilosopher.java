package reentarntlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPhilosopher extends Thread{
    private ReentrantLock leftChopstick, rightChopstick;
    private Random random;

    public ReentrantLockPhilosopher(ReentrantLock leftChopstick, ReentrantLock rightChopstick){
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        random = new Random();
    }

    @Override
    public void run(){
        try {
            while (true){
                Thread.sleep(random.nextInt(1000));
                leftChopstick.lock();
                try{
                    if (rightChopstick.tryLock(1000, TimeUnit.MILLISECONDS)){
                        try{
                            Thread.sleep(random.nextInt(1000));
                        }finally {
                            rightChopstick.unlock();}
                    }
                    else{
                        System.out.println("Philosopher" + this + "timed out");
                    }
                    }finally {leftChopstick.unlock(); }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
