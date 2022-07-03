public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(){

            @Override
            public void run(){
                System.out.println("Hello World from new Thread");
            }
        };
        myThread.start();
        Thread.yield();
        System.out.println("Hello from main Thread");
        myThread.join();
    }
}
