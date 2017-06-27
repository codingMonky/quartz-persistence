package com.spring.data.Impl;

import com.spring.data.dao.StudentDao;
import com.spring.data.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/** 
* StudentDaoJdbcTemplateImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>06/22/2017</pre> 
* @version 1.0 
*/ 
public class StudentDaoJdbcTemplateImplTest {
    private ApplicationContext applicationContext;
    private StudentDao studentDao;

@Before
public void before() throws Exception {
    applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
    studentDao = (StudentDaoJdbcTemplateImpl)
            applicationContext.getBean("studentDao");
}

@After
public void after() throws Exception {
    applicationContext = null;
} 

/** 
* 
* Method: getJdbcTemplate() 
* 
*/ 
@Test
public void testGetJdbcTemplate() throws Exception {

    List<Student> list = studentDao.queryList();
    if(list!=null&&!list.isEmpty())
    for(Student stu:list){
        System.out.println(stu.getUsername());
    }
}

/** 
* 
* Method: setJdbcTemplate(JdbcTemplate jdbcTemplate) 
* 
*/ 
@Test
public void testSetJdbcTemplate() throws Exception {

    Student student = new Student();
    student.setUsername("Ann");
    student.setAge(19);
    studentDao.save(student);
}

/** 
* 
* Method: queryList() 
* 
*/ 
@Test
public void testQueryList() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: save(Student student) 
* 
*/ 
@Test
public void testSave() throws Exception { 
//TODO: Test goes here... 
} 


} 
