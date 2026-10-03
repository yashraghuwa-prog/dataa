package com.jdcb.dataa.repo;

import com.jdcb.dataa.model.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(student student) {
        String sql ="insert into student values(id,name,tech) values (?,?,?)";
        template.update(sql ,student.getId(),student.getName(),student.getTech());
    }

    public List<student> findAll() {
        String sql =" select * from student ";



        List<student> temp=template.query(sql, (rs, _) -> {
            student s=new student();
            s.setId(rs.getInt("id"));
            s.setName(rs.getString("name"));
            s.setTech(rs.getString("tech"));
            return s;
        });
        return temp;
    }
}
