package cn.com.huangdc.thread;

public class TestWindow {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable {
    int ticket = 100;
    Object obj = new Object();

    /**
     * @Description: 多线程共享数据，使用同步处理
     * @author Administrator
     * @date 2020/5/25 20:38
     */
    @Override
    public void run() {
        while (true) {
            // 1、同步代码块
            synchronized (obj) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "窗口：售票号" + ticket--);
                } else {
                    break;
                }
            }

            // 2、同步方法
            sole();
        }
    }

    private synchronized void sole () {// this充当锁
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "窗口：售票号" + ticket--);
        }
    }
}


