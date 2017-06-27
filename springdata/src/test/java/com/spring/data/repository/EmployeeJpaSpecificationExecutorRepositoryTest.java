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
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * <p>Title: com.spring.data.repository.EmployeeJpaSpecificationExecutorRepositoryTest</P>
 * author yl
 * date 2017/6/24 23:04
 * <p>Company: UBill</p>
 */
public class EmployeeJpaSpecificationExecutorRepositoryTest {
    private ApplicationContext applicationContext;
    private EmployeeJpaSpecificationExecutorRepository employeeJpaSpecificationExecutorRepository;

    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("spring-new-beans.xml");
        employeeJpaSpecificationExecutorRepository = applicationContext.getBean(EmployeeJpaSpecificationExecutorRepository.class);

    }

    @After
    public void after(){
        applicationContext = null;
        employeeJpaSpecificationExecutorRepository = null;
    }

    @Test
    public void testSort(){

        Specification<Employee> specification = new Specification<Employee>() {
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path path = root.get("age");
                return cb.gt(path,26);
            }
        };

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(0,3,sort);
        Page<Employee> page = employeeJpaSpecificationExecutorRepository.findAll(specification,pageable);

        System.out.println(page.getTotalElements());
        System.out.println(page.getTotalPages());
        System.out.println(page.getContent());
        System.out.println(page.getNumber());
        System.out.println(page.getNumberOfElements());
        System.out.println(page.getSize());
        System.out.println(page.getSort());
    }
}
