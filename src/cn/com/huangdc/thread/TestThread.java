package cn.com.huangdc.thread;

public class TestThread {

    public static void main(String[] args) {
        SubTread subTread = new SubTread();
        subTread.start();
        SubTread subTread1 = new SubTread();
        subTread1.start();
        SubTread subTread2 = new SubTread();
        subTread2.start();
    }
}

class SubTread extends Thread {
    public void run() {
        System.out.println("SubTread run...");
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}
