package philosopher;

import philosopher.Chopstick;

import java.util.Random;

public class Philosopher extends Thread{
    private Chopstick first, second;
    private Random random;
    private int count;
    public Philosopher(Chopstick left, Chopstick right){
        if (left.getId() < right.getId()){
            first = left;
            second = right;
        }

        else first = right; second = left;
        random = new Random();
    }

    @Override
    public void run(){
        try{
            while(true){
                ++count;
                if (count % 10 == 0)
                    System.out.println("philosopher.Philosopher " + this + " has thought " + count + "times");
                Thread.sleep(random.nextInt(1000));
                synchronized (first){
                    synchronized (second){
                        Thread.sleep(random.nextInt(1000));
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
