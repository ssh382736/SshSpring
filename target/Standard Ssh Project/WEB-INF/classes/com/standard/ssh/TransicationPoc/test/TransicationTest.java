package com.standard.ssh.TransicationPoc.test;



import com.standard.ssh.TransicationPoc.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class TransicationTest {

    @Autowired
    private TeacherService service;

    /**
     * Required属性告诉容器某个特定的方法需要一个事务，
     * 如果上下文中已经存在事务，则加入；否则，开启一个事务。
     * 这是一种使用最频繁的事务属性，适用于大多数情况
     */
    @Test
    public void required(){
        service.addTeacher();
    }

    /**
     *RequiresNew属性告诉容器某个特定的方法需要一个新事务的支持。
     * 如果上下文中已经存在事务A，则该事务A挂起，并启动一个新的事务B。
     * 当事务B结束后，事务A被唤醒并继续执行
     */
    @Test
    public void requiresNew(){


    }

    /**
     *Supports属性告诉容器，该方法不需要事务支持，
     * 但如果当前上下文中已经存在了一个事务，则加入其中
     */
    @Test
    public void support(){

    }

    /**
     * NotSupported属性告诉容器，该方法不需要事务支持；
     * 如果当前上下文中已经存在事务，则该事务被挂起直到该方法执行完毕。
     * 如果当前上下文中不存在事务，该方法则在没有事务支持的环境下执行
     */
    @Test
    public void notSupport(){

    }

    /**
     *Mandatory属性告诉容器某个特定的方法需要一个事务。
     * 但是，不同于Required属性，它无论如何都不会开启新的事务；
     * 相反的，它会“强制”要求该方法被调用时上下文中必须存在事务，
     * 否则会抛出TransactionRequiredException异常，提示需要一个事务但没有找到
     */
    @Test
    public void mandatory(){

    }

    /**
     * Never属性告诉容器，该方法必须在无事务的上下文中运行。
     * 注意，这与NotSupported不同，后者意味着，如果上下文中存在事务，
     * 则将该事务暂时挂起并在无事务的上下文中运行。
     * 但Never却不同，如果当前上下文中已经存在事务，
     * 则在调用该方法时会抛出一个异常，提示该方法不能在事务环境下运行
     */
    @Test
    public void never(){


    }

    @Test
    public void nested(){


    }

}
