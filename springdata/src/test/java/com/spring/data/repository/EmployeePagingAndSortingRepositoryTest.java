package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * <p>Title: com.spring.data.repository.EmployeePagingAndSortingRepositoryTest</P>
 * author yl
 * date 2017/6/24 22:11
 * <p>Company: UBill</p>
 */
public class EmployeePagingAndSortingRepositoryTest {

    private ApplicationContext applicationContext;
    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("spring-new-beans.xml");
        employeePagingAndSortingRepository = applicationContext.getBean(EmployeePagingAndSortingRepository.class);

    }

    @After
    public void after(){
        applicationContext = null;
        employeePagingAndSortingRepository = null;
    }

    @Test
    public void testSort(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(0,5,sort);
        Page<Employee> page = employeePagingAndSortingRepository.findAll(pageable);

        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getContent());
        System.out.println(page.getNumber());
        System.out.println(page.getNumberOfElements());
        System.out.println(page.getSize());
        System.out.println(page.getSort());
    }
}
