package com.spring.data.dao;

import com.spring.data.entity.Student;

import java.util.List;

/**
 * <p>Title: com.spring.data.dao.StudentDao</P>
 * author yl
 * date 2017/6/22 21:08
 * <p>Company: UBill</p>
 */
public interface StudentDao {
    /**
     * 查询所有学生信息
     *
     * @return 所有的学生信息
     */
    public List<Student> queryList();

    /**
     * 添加一个学生信息
     * @param student 学生信息
     */
    public void save(Student student);
}