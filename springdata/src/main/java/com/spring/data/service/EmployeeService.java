package com.spring.data.service;

import com.spring.data.entity.Employee;
import com.spring.data.repository.EmployeeCrudRepostory;
import com.spring.data.repository.EmployeePagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>Title: com.spring.data.service.EmployeeService</P>
 * author yl
 * date 2017/6/24 21:14
 * <p>Company: UBill</p>
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeCrudRepostory employeeCrudRepostory;

    private EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

    @Transactional
    public int save(List<Employee> list){
     Iterable<Employee> it = employeeCrudRepostory.save(list);
     return  ((List<Employee>)it).size();
    }
}
