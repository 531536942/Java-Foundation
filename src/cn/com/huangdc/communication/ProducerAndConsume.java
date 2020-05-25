package cn.com.huangdc.communication;

/**
* <pre>类名: ProducerAndConsume</pre>
* <pre>描述: 消费者与生产者。产品过多时，生产者等待。产品不够时，消费者等待</pre>
* <pre>都对clerk上锁，生产和消费公用同一把锁</pre>
* <pre>版权: 税友软件集团股份有限公司</pre>
* <pre>日期: 2020/5/25 22:14</pre>
* <pre>作者: Administrator</pre>
*/
public class ProducerAndConsume {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p = new Producer(clerk);
        Consume c = new Consume(clerk);

        Thread t1 = new Thread(p);
        t1.setName("生产者1111");
        Thread t2 = new Thread(c);
        t2.setName("消费者2222");

        t1.start();
        t2.start();
    }

}

class Producer implements Runnable {
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者生产产品");
        while (true) {
            clerk.addProduct();
        }
    }
}

class Consume implements Runnable {
    Clerk clerk;

    public Consume(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("消费者消费产品");
        while (true) {
            clerk.consumeProduct();
        }
    }
}

class Clerk {
    int product;

    public synchronized void addProduct() {
        System.out.println(Thread.currentThread().getName() + ":来生产了11111111111");
        try {
            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (product >= 20) {
            try {
                System.out.println(Thread.currentThread().getName() + ":产品太多了，等一等");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":生产了第" + ++product + "个");
            notify();
        }
    }

    public synchronized void consumeProduct() {
        System.out.println(Thread.currentThread().getName() + ":来消费了2222222222");
        try {
            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (product <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + ":产品不够了，等一等");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ":消费了第" + product-- + "个");
            notify();
        }
    }
}