package com.spring.data.repository;

import com.spring.data.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p>Title: com.spring.data.repository.EmployeeRepository</P>
 * author yl
 * date 2017/6/23 0:18
 * <p>Company: UBill</p>
 */
@RepositoryDefinition(domainClass = Employee.class,idClass = Integer.class)
public interface EmployeeRepository{ //extends Repository<Employee,Integer> {

    public Employee findByName(String name);

    public List<Employee> findByNameStartingWithAndAgeLessThan(String name,Integer age);

    public List<Employee> findByNameInAndAgeLessThan(List<String> list,Integer age);

    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    public Employee getEmployeeByMaxId();

    @Query("select o from Employee o where o.name = ?1 and o.age = ?2")
    public List<Employee> getEmployeeByNameAndAge(String name,Integer age);

    @Query("select o from Employee o where o.name =:name and o.age =:age")
    public List<Employee> getEmployeeByNameAndAge1(@Param("name")String name,@Param("age") Integer age);

    //@Query(value = "select o from Employee o where o.name like  %?1% ")
    @Query(value = "select o from Employee o where o.name like  %:name% ")
    public List<Employee> getEmployeeByNameLike(@Param("name")String name);

    @Query(nativeQuery=true,value = "select  count(*) from employee")
    public Long getCount();

    @Transactional
    @Modifying
    @Query("update Employee o set o.age=:age where o.id = :id")
    public int updateAge(@Param("id")Integer id,@Param("age") Integer age);



}
