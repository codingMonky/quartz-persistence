package com.spring.data.Impl;

import com.spring.data.dao.StudentDao;
import com.spring.data.entity.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: com.spring.data.Impl.StudentDaoJdbcTemplateImpl</P>
 * author yl
 * date 2017/6/22 22:04
 * <p>Company: UBill</p>
 */
public class StudentDaoJdbcTemplateImpl implements StudentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> queryList() {
       final List<Student> list = new ArrayList<Student>();
        String sql = "select * from student";
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    Student student = new Student();
                    student.setId(id);
                    student.setUsername(name);
                    student.setAge(age);
                    list.add(student);

            }
        });

        return list;
    }

    public void save(Student student) {
        String sql = "insert into student (name,age) values(?,?)";
        jdbcTemplate.update(sql,student.getUsername(),student.getAge());

    }
}
