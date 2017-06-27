package com.spring.data.entity;

import com.google.gson.Gson;

import javax.persistence.*;

/**
 * <p>Title: com.spring.data.entity.Employee</P>
 * author yl
 * date 2017/6/23 0:01
 * <p>Company: UBill</p>
 */
@Entity
@Table(name="employee")
public class Employee {

    @GeneratedValue
    @Id
    private Integer id;

    @Column(length = 20)
    private String name;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
