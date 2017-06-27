package com.spring.data.Impl;

import com.spring.data.dao.StudentDao;
import com.spring.data.entity.Student;
import com.spring.data.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: com.spring.data.Impl.StudentDaoImpl</P>
 * author yl
 * date 2017/6/22 21:10
 * <p>Company: UBill</p>
 */
public class StudentDaoImpl implements StudentDao {
    public List<Student> queryList() {
        Connection connection = JdbcUtil.getConnection();
        List<Student> list = new ArrayList<Student>();
        String sql = "select * from student";
        PreparedStatement ps = null;
        ResultSet set =null;
        try {
            ps = connection.prepareStatement(sql);
            set = ps.executeQuery();
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                int age = set.getInt("age");
                Student student = new Student();
                student.setId(id);
                student.setUsername(name);
                student.setAge(age);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.release(connection,ps,set);
        }


        return list;
    }

    public void save(Student student) {
        Connection connection = null;

        PreparedStatement ps = null;
        try {
            connection = JdbcUtil.getConnection();
            String sql = "insert into student (name,age) values(?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, student.getUsername());
            ps.setInt(2, student.getAge());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.release(connection, ps, null);
        }
    }
}
