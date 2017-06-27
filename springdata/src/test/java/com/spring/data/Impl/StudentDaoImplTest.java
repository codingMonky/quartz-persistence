package com.spring.data.Impl;

import com.spring.data.entity.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/** 
* StudentDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>06/22/2017</pre> 
* @version 1.0 
*/ 
public class StudentDaoImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: queryList() 
* 
*/ 
@Test
public void testQueryList() throws Exception {
    List<Student> list = new StudentDaoImpl().queryList();
    for(Student stu : list){
        System.out.println(stu.getUsername());
    }
}

    /**
     *
     * Method: save()
     *
     */
    @Test
    public void testSave() throws Exception {
       Student student = new Student();
       student.setUsername("clock");
       student.setAge(20);
       new StudentDaoImpl().save(student);
    }


} 
