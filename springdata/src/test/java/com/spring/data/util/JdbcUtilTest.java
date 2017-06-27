package com.spring.data.util; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.sql.Connection;

/** 
* JdbcUtil Tester. 
* 
* @author <Authors name> 
* @since <pre>06/22/2017</pre> 
* @version 1.0 
*/ 
public class JdbcUtilTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getConnection() 
* 
*/ 
@Test
public void testGetConnection() throws Exception {
    Connection connection = JdbcUtil.getConnection();
    Assert.assertNotNull(connection);
} 


} 
