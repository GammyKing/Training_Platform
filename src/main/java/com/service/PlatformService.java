package com.service;

import com.pojo.Student;

import java.util.List;

public interface PlatformService {
    boolean insertScore(Student student);

    String findCompanyName(int id);

    List<Student> showStudent(String companyName);
}
