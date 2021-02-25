package com.service;

import com.pojo.Company;
import com.pojo.Student;

import java.util.List;

public interface ManagerService {
    List<Student> selectStuUser();

    boolean modifyStuUser(Student student);

    boolean deleteStuUser(Student student);

    boolean registerCompany(Student student);

    List<Company> selectCompany();

    boolean modifyCompany(Company company);

    boolean deleteCompany(Company company);

    boolean addCompany(Company company);

    boolean modifyScore(Student student);

    List<Student> scoreInfo();

    List<Company> selectCompanyInfo();

    boolean modifyCompanyPwd(Company company);
}
