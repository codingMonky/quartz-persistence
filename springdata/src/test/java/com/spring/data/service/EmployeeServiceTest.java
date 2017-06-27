package com.spring.data.service;

import com.spring.data.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>06/24/2017</pre>
 */
public class EmployeeServiceTest {

    private ApplicationContext applicationContext;

    private EmployeeService employeeService;

    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring-new-beans.xml");
        employeeService = (EmployeeService) applicationContext.getBean("employeeService");
    }

    @After
    public void after() throws Exception {
        employeeService = null;
        applicationContext = null;
    }

    /**
     * Method: save(List<Employee> list)
     */
    @Test
    public void testSave() throws Exception {
        List<Employee> list = new ArrayList<Employee>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setName("jack" + i);
            employee.setAge(20 + i);
            list.add(employee);
        }
        int count = employeeService.save(list);
        System.out.println(count);

    }


} 
