package edu.maskleo;

public class TernaryOperationTest {

    static volatile int a = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new TernaryOperationTest.InnerThread());
        thread.start();
        int c = 0;
        for(;;){
            boolean b = (a != (a = 2));
            if (b){
                System.out.println("==================");
                break;
            } else {
                System.out.println(++c);
            }
        }
    }

    static class InnerThread implements Runnable {
        public void run() {
            for (;;){
                a = 3;
            }
        }
    }
}
