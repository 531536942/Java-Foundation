package cn.com.huangdc.proxy;

import org.junit.Test;

/**
 * 静态代理demo
 * UserManager 功能接口类
 * UserManagerImpl 功能实现类
 * ProxyUserManager 代理类
 * UserManagerFactory 工厂类
 */
public class TestStaticProxy {
    @Test
    public void test() {
        UserManager userManager = UserManagerFactory.getUserManager();
        ProxyUserManager proxyUserManager = new ProxyUserManager(userManager);
        proxyUserManager.addUser();
        proxyUserManager.deleteUser();
    }
}

interface UserManager {

    public void addUser();

    public void deleteUser();
}

class UserManagerImpl implements UserManager {

    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}

class ProxyUserManager implements UserManager {

    private UserManager userManager;

    public ProxyUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addUser() {
        userManager.addUser();
        System.out.println("添加结束");
    }

    @Override
    public void deleteUser() {
        userManager.deleteUser();
        System.out.println("删除结束");
    }
}

class UserManagerFactory {
    public static UserManager getUserManager() {
        return new UserManagerImpl();
    }
}