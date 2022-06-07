package com.xdclass.springboot.controller;

import com.xdclass.springboot.model.Student;
import com.xdclass.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *  controller(控制层)：调用service层，做逻辑处理
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentService studentService;

    /**
     * 最原始的数据库访问方法
     *
     */
    @RequestMapping("/getStudents")
    public List<Map<String, Object>> getStudents() {
        String sql = "select * from student";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    /**
     * 使用maybatis框架访问数据库
     * 调用层顺序：controller -> service -> dao
     */
    @RequestMapping("/selectAll")
    public List<Student> selectAll() {
        return studentService.selectAll();
    }

    @RequestMapping("/insert")
    public String insert(@ModelAttribute Student student) {
        studentService.insert(student);
        return "insert success";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute Student student) {
        studentService.update(student);
        return "update success";
    }

    @RequestMapping("/delete")
    public String update(Integer id) {
        studentService.delete(id);
        return "delete success";
    }
}
