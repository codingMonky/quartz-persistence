package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>Title: com.spring.data.repository.EmployeeJpaSpecificationExecutorRepository</P>
 * author yl
 * date 2017/6/23 0:18
 * <p>Company: UBill</p>
 */
public interface EmployeeJpaSpecificationExecutorRepository
        extends JpaRepository<Employee,Integer> ,JpaSpecificationExecutor<Employee> {


}
