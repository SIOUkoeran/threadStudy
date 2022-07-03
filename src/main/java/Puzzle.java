public class Puzzle {
    static boolean answerReady = false;
    static int answer = 0;
    static Thread t1 = new Thread(){
        public void run(){
            answer = 42;
            answerReady = true;
        }
    };
    static Thread t2 = new Thread(){
        public void run(){
            while (!answerReady) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("The meaning of life if : " + answer);
        }
    };

    public static void main(String[] args) throws InterruptedException {

            t1.start(); t2.start();


        t1.join(); t2.join();
    }
}
