package com.spring.data.dataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * <p>Title: com.spring.data.dataSource.DataSourceTest</P>
 * author yl
 * date 2017/6/22 21:52
 * <p>Company: UBill</p>
 */
public class DataSourceTest {

    private ApplicationContext applicationContext;

    @Before
    public void getContex(){
        applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
    }

    @After
    public void destoryContext(){
        applicationContext = null;
    }

    @Test
    public void testDataSource(){
        DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
        Assert.assertNotNull(dataSource);

    }

    @Test
    public void testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        Assert.assertNotNull(jdbcTemplate);

    }
}
