package com.dao;

import com.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface StudentDao {
    Student avalidateLogin(Person person);

    Teacher avalidateLoginTea(Person person);

    Company avalidateLoginCompany(Person person);

    int register(Student student);

    Student studentInfo(int id);

    int applicationCompany(Student student);

    int askQusetion(Question question);

    int stuInsertInto(Student student);

    Student selectReg(Student student);


    Score queryScore(int score);

    int commitPage(PaperText paperText);

    List<String> applicationInfo();

    int commitPageStu(PaperText paperText);

    String findStuTutor(int id);

}
