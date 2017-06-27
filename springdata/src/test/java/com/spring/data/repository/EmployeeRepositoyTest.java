package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: com.spring.data.dataSource.EmployeeRepositoyTest</P>
 * author yl
 * date 2017/6/22 23:59
 * <p>Company: UBill</p>
 */
public class EmployeeRepositoyTest {

    private ApplicationContext applicationContext;

    private EmployeeRepository employeeRepository;

    @Before
    public void getContex() {
        applicationContext = new ClassPathXmlApplicationContext("spring-new-beans.xml");
        employeeRepository = (EmployeeRepository)applicationContext.getBean("employeeRepository");
    }

    @After
    public void destoryContext() {
        applicationContext = null;
    }

    @Test
    public void testEntityManagerFactory() {
       Employee employee =  employeeRepository.findByName("tom");
        System.out.println(employee.getName());
    }

    @Test
    public void testFindByNameStartingWithAndAgeLessThan() {
        List<Employee> list = employeeRepository.findByNameStartingWithAndAgeLessThan("tom",20);
        for(Employee e:list) {
            System.out.println(e.getName());
        }
    }

    @Test
    public void testFindByNameInAndAgeLessThan() {
        List<String> strs = new ArrayList<String>();
        strs.add("tom1");
        strs.add("tom2");
        strs.add("tom3");
        strs.add("tom4");
        List<Employee> list = employeeRepository.findByNameInAndAgeLessThan(strs,20);
        for(Employee e:list) {
            System.out.println(e.getName());
        }
    }


    @Test
    public void testGetEmployeeByMaxId(){
        Employee employee = employeeRepository.getEmployeeByMaxId();
        System.out.println(employee.getName());
    }

    @Test
    public void testGetEmployeeByNameAndAge(){
        List<Employee> employees = employeeRepository.getEmployeeByNameAndAge("tom",18);
        if(employees!=null&&!employees.isEmpty()){
            for(Employee employee:employees)
                System.out.println(employee.getName());
        }
    }

    @Test
    public void testGetEmployeeByNameAndAge1(){
        List<Employee> employees = employeeRepository.getEmployeeByNameAndAge1("tom",18);
        if(employees!=null&&!employees.isEmpty()){
            for(Employee employee:employees)
                System.out.println(employee.getName());
        }
    }

    @Test
    public void testGetEmployeeByNameLike(){
        List<Employee> employees = employeeRepository.getEmployeeByNameLike("tom");
        if(employees!=null&&!employees.isEmpty()){
            for(Employee employee:employees)
                System.out.println(employee.getName());
        }
    }

    @Test
    public void testGetCount(){
        Long count = employeeRepository.getCount();
        System.out.println(count);
    }
    @Test
    public void testUpdateAge(){
        int count = employeeRepository.updateAge(1,39);
        System.out.println(count);
    }
}
