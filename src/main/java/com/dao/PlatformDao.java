package com.dao;

import com.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlatformDao {
//  评分
    int insertScore(Student student);

    String findCompanyName(int id);

    List<Student> showStudent(String companyName);
}
