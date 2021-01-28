package springTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String name;
    private String address;
    private int phone;
    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");//6
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【注入属性】name");//9
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【注入属性】address");//8
        this.address = address;
    }

    public int getPhone() {
        return phone;//10
    }

    public void setPhone(int phone) {
        System.out.println("【注入属性】phone");
        this.phone = phone;
    }

    // 这是BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用setBeanFactory方法");//12
        this.beanFactory = beanFactory;
    }

    // 这是BeanNameAware接口方法
    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用setBeanName方法");//11
        this.beanName = s;
    }

    // 这是DiposibleBean接口方法
    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用destroy方法");//21
    }

    // 这是InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用afterPropertiesSet方法");//14
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");//15
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");//22
    }
}
