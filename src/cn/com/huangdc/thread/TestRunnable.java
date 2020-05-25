package cn.com.huangdc.thread;

public class TestRunnable {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        Thread t = new Thread(printNum);
        t.start();
    }
}

class PrintNum implements Runnable {
    @Override
    public void run() {
        System.out.println("PrintNum run...");
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}