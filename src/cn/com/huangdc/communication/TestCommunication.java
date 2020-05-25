package cn.com.huangdc.communication;

/**
* <pre>类名: 'TestCommunication'</pre>
* <pre>描述: 进程通信 -- 进程依次打印</pre>
* <pre>版权: 税友软件集团股份有限公司</pre>
* <pre>日期: 2020/5/25 21:52</pre>
* <pre>作者: Administrator</pre>
*/
public class TestCommunication {
    public static void main(String[] args) {
        PrintNum p = new PrintNum();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p);
        Thread t4 = new Thread(p);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class PrintNum implements Runnable {
    int num = 1;

    public void run() {
        while (true) {
            synchronized (this) {
                notify();// 唤醒
                if (num <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    num++;
                } else {
                    break;
                }
                try {
                    wait();// 等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}