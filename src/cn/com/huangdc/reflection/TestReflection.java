package cn.com.huangdc.reflection;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * java.lang.Class
 * java.lang.reflect.Method
 * java.lang.reflect.Field
 * java.lang.reflect.Constructor
 */
public class TestReflection {

    @Test
    public void testClassLoader () throws ClassNotFoundException, IOException {
        // 系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        // 扩展类加载器
        ClassLoader loader1 = systemClassLoader.getParent();
        System.out.println(loader1);
        // 引导类加载器（不能获取到）
        ClassLoader loader2 = loader1.getParent();
        System.out.println(loader2);

        Class clazz1 = Person.class;
        System.out.println(clazz1.getClassLoader());

        String className = "java.lang.String";
        Class clazz2 = Class.forName(className);
        System.out.println(clazz2.getClassLoader());

        // 读取配置
        ClassLoader loader = this.getClass().getClassLoader();
        InputStream resourceAsStream = loader.getResourceAsStream("cn\\com\\huangdc\\reflection\\jdbc.properties");
        Properties p = new Properties();
        p.load(resourceAsStream);
        System.out.println(p.getProperty("user"));
    }

    @Test
    public void test() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException,
            ClassNotFoundException {
        // 获取类对象
        Class clazz = Person.class;
        // 声明对象
        Object o = clazz.newInstance();
        // 字段获取(获取了所有声明的字段)
        Field[] fields = clazz.getDeclaredFields();
        int i;
        for(Field f : fields) {
            if (!f.isAccessible()) {
                f.setAccessible(true);
            }
            if (f.getType() == String.class) {
                f.set(o,"xiaoming");
            } else if (f.getType() == int.class) {
                f.set(o,1);
            }
        }
        System.out.println(o);

        // 方法获取
        Method m1 = clazz.getMethod("show");
        m1.invoke(o);
        Method m2 = clazz.getMethod("display", String.class);
        m2.invoke(o, "名字");
        System.out.println(o);

        // 获取Class的实例
        // 1、调用运行时类本身，class属性
        Class clazz1 = Person.class;
        System.out.println(clazz1.getName());

        // 2、通过对象获取
        Person p = new Person();
        Class<? extends Person> aClass = p.getClass();
        System.out.println(aClass.getName());

        // 3、通过Class静态法方法
        String s = "cn.com.huangdc.reflection.Person";
        Class<?> aClass1 = Class.forName(s);
        System.out.println(aClass1.getName());

        // 4、通过类的加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<?> aClass2 = classLoader.loadClass(s);
        System.out.println(aClass2.getName());
    }
}

class Person {
    private String name;
    private int age;

    public void show() {
        System.out.println("我是一个人");
    }

    public void display(String name) {
        System.out.println(name);
    }

    /**
     * 获取name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取age
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置age
     * @param age age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
