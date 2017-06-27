package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <p>Title: com.spring.data.repository.EmployeePagingAndSortingRepository</P>
 * author yl
 * date 2017/6/24 22:02
 * <p>Company: UBill</p>
 */
public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {
}
