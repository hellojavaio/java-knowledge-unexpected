package edu.maskleo;

public class AssignmentTest {

    static volatile int a = 2;

    static volatile boolean b = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new InnerThread());
        thread.start();
        int c = 0;
        for(;;){
            b = (a != (a = 2));
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
                if (b){
                    break;
                }
            }
        }
    }

}
