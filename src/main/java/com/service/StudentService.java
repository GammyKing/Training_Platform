package com.service;

import com.pojo.*;

import java.util.List;

public interface StudentService {
//    登录
//    学生
    boolean avalidateLogin(Person person);
//    老师
    boolean avalidateLoginTea(Person person);
//    公司
    boolean avalidateLoginCompany(Person person);
//    管理员
    boolean avalidateLoginManager(Person person);
//    注册
    boolean register(Student student);
//    学生信息
    Student studentInfo(int id);
//    申请公司
    boolean applicationCompany(Student student);
//    提问
    boolean askQusetion(Question question);
//  学生插入信息
    boolean stuInsertInfo(Student student);

//  学生查看成绩
    Score queryScore(int score);
//  提交论文
    boolean commitPage(PaperText paperText);
// 公司申请
    List<String> applicationInfo();

    String findTutor(int id);
}
