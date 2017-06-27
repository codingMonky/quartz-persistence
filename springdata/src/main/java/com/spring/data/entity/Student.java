package com.spring.data.entity;

import java.io.Serializable;

/**
 * <p>Title: com.spring.data.entity.Student</P>
 * author yl
 * date 2017/6/22 21:04
 * <p>Company: UBill</p>
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -6792250821748560077L;
    /**
     * 主键
     */
    private int id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 年龄
     */
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
