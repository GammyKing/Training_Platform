package com.service.Impl;

import com.dao.StudentDao;
import com.pojo.*;
import com.service.StudentService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

//    学生逻辑
    @Override
    public boolean avalidateLogin(Person person) {
        //查库
        Student stu = studentDao.avalidateLogin(person);
        return stu!=null?true:false;
    }

//教师逻辑
    @Override
    public boolean avalidateLoginTea(Person person) {
        Teacher teacher = studentDao.avalidateLoginTea(person);
        return teacher!=null?true:false;
    }
//公司登录逻辑
    @Override
    public boolean avalidateLoginCompany(Person person) {
        Company company = studentDao.avalidateLoginCompany(person);
        return company!=null?true:false;
    }
//管理员登录逻辑
    @Override
    public boolean avalidateLoginManager(Person person) {
        if (person.getId()==123&&person.getPwd().equals("123456")){
            return true;
        }else {
            return false;
        }
    }


    @Override
    public boolean register(Student student) {
        Date date = new Date();
        String time = DateFormatUtil.date2String(date);
        student.setCreatetime(time);
        Student isExist = studentDao.selectReg(student);
        if (isExist!=null){
            return false;
        }else {
            int i = studentDao.register(student);
            return i!=0?true:false;
        }
    }

    @Override
    public Student studentInfo(int id) {
       return studentDao.studentInfo(id);
    }

    @Override
    public boolean applicationCompany(Student student) {
        int i = studentDao.applicationCompany(student);
        return i!=0?true:false;
    }

    @Override
    public boolean askQusetion(Question question) {
        Date date = new Date();
        String time = DateFormatUtil.date2String(date);
        question.setCreatetime(time);
        question.setIsdelete(0);
        String stuTutor = studentDao.findStuTutor(question.getId());
        question.setTutor(stuTutor);
        int i = studentDao.askQusetion(question);
        return i!=0?true:false;
    }

    @Override
    public boolean stuInsertInfo(Student student) {
        int i = studentDao.stuInsertInto(student);
        return i!=0?true:false;
    }

    @Override
    public Score queryScore(int score) {
        return studentDao.queryScore(score);
    }

    @Override
    public boolean commitPage(PaperText paperText) {
        int i = studentDao.commitPage(paperText);
        if (i != 0){
            studentDao.commitPageStu(paperText);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<String> applicationInfo() {
        return studentDao.applicationInfo();
    }

    @Override
    public String findTutor(int id) {
        return studentDao.findStuTutor(id);
    }
}
