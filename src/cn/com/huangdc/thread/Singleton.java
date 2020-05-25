package cn.com.huangdc.thread;

/**
* <pre>类名: Singleton</pre>
* <pre>描述: 单例模式 -- 县城安全处理</pre>
* <pre>日期: 2020/5/25 20:56</pre>
* <pre>作者: Administrator</pre>
*/
public class Singleton {
    private Singleton(){}

    private static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
