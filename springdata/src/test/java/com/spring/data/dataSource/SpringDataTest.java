package com.spring.data.dataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>Title: com.spring.data.dataSource.EmployeeRepositoyTest</P>
 * author yl
 * date 2017/6/22 23:59
 * <p>Company: UBill</p>
 */
public class SpringDataTest {

    private ApplicationContext applicationContext;

    @Before
    public void getContex(){
        applicationContext = new ClassPathXmlApplicationContext("spring-new-beans.xml");
    }

    @After
    public void destoryContext(){
        applicationContext = null;
    }

    @Test
    public void testEntityManagerFactory(){

    }

}
