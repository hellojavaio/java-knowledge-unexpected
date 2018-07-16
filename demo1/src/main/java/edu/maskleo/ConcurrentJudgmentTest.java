package edu.maskleo;

public class ConcurrentJudgmentTest {

    volatile static Boolean test = false;

    public static void main(String[] args) {
        Thread threadTrue = new Thread(new ConcurrentJudgmentTest.InnerThreadTrue());
        threadTrue.start();
        Thread threadFalse = new Thread(new ConcurrentJudgmentTest.InnerThreadFalse());
        threadFalse.start();
        for (;;){
            if (test == null){

            } else {
                if (test == null){
                    System.out.println("===================");
                }
            }
        }
    }

    static class InnerThreadTrue implements Runnable {
        public void run() {
            for (;;){
                test = true;
            }
        }
    }

    static class InnerThreadFalse implements Runnable {
        public void run() {
            for (;;){
                test = null;
            }
        }
    }

}
