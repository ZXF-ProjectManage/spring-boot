package com.xdclass.springboot.dao;

import com.xdclass.springboot.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
*  dao层(数据访问层)：与数据库直接关联
*
*/
@Mapper
public interface StudentDao {

    /**
     *
     * mybatis调用sql文的两种方法
     * 1.通过配置在resources下面的.xml文件获取对用的sql语句
     * 2.通过添加"@关键字(select,insert...)("sql语句")",如下
     */
    @Select("select * from student")
    List<Student> selectAll();

    @Insert("insert into student(age,username,password,creattime) values(#{age},#{username},#{password},now())")
    void insert(Student student);

    @Update("update student set age = #{age},username = #{username},password = #{password},creattime = now()" + "where id = #{id}")
    void update(Student student);

    @Delete("delete from student where id = #{id}")
    void delete(Integer id);
}
