package com.xdclass.springboot.service;

import com.xdclass.springboot.dao.StudentDao;
import com.xdclass.springboot.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * serice层(业务层)：调用dao层，做业务处理
 */
@Service
public class StudentService {

    @Resource
    private StudentDao studentDao;

    public List<Student> selectAll() {
        return studentDao.selectAll();
    }

    public void insert(Student student) {
        studentDao.insert(student);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void delete(Integer id) {
        studentDao.delete(id);
    }
}
