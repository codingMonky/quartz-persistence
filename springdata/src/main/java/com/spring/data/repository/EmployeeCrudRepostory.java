package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>Title: com.spring.data.repository.EmployeeCrudRepostory</P>
 * author yl
 * date 2017/6/24 21:11
 * <p>Company: UBill</p>
 */
public interface EmployeeCrudRepostory extends CrudRepository<Employee,Integer> {
}
