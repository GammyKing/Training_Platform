package com.service.Impl;

import com.dao.TeacherDao;
import com.pojo.Answer;
import com.pojo.PaperText;
import com.pojo.Student;
import com.pojo.Teacher;
import com.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public boolean createTeacher(Teacher teacher) {
        int i = teacherDao.createTeacher(teacher);
        return i!=0?true:false;
    }

    @Override
    public boolean checkPaper(Student student) {
        int i = teacherDao.checkPaper(student);
        return i!=0?true:false;
    }

    @Override
    public List<Answer> showStuQuestion(String tutor) {
        return teacherDao.showStuQuestion(tutor);
    }

    @Override
    public boolean answerQuestion(Answer answer) {
        int i = teacherDao.answerQuestion(answer);
        return i!=0?true:false;
    }

    @Override
    public String findTutor(int id) {
        return teacherDao.findTutor(id);
    }

    @Override
    public List<PaperText> Papers(String tutor) {
        return teacherDao.Papers(tutor);
    }

    @Override
    public String showPaper(int id) {
        return teacherDao.showPaper(id);
    }
}
