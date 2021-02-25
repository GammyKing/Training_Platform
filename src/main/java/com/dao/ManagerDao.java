package com.dao;

import com.pojo.Company;
import com.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerDao {
    List<Student> selectStuUser();

    int modifyPwd(Student student);

    int modifyStuName(Student student);

    int modifyTutor(Student student);

    int deleteStuUser(Student student);

    int registerCompany(Student student);

    List<Company> selectCompany();

    int modifyCompany(Company company);

    int deleteCompany(Company company);

    int addCompany(Company company);

    int modifyScore(Student student);

    List<Student> scoreInfo();

    int modifyCompanyPwd(Company company);

    Student selectUserTutor(Student student);

    int insertTutor(Student student);
}
